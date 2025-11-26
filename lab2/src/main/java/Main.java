import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
  private static Object getDefaultPrimitiveValue(Class<?> type) {
    if (type.isArray()) return Array.newInstance(type.getComponentType(), 0);

    return switch (type.getName()) {
      case "byte" -> (byte) 0;
      case "char" -> '\u0000';
      case "short" -> (short) 0;
      case "int" -> 0;
      case "long" -> 0L;
      case "float" -> 0.0f;
      case "double" -> 0.0;
      case "boolean" -> false;
      default -> null;
    };
  }

  private static Object getDefaultObject(Class<?> type) {
    try {
      if (type.isPrimitive()) return getDefaultPrimitiveValue(type);
      var ctor = type.getDeclaredConstructor();
      ctor.setAccessible(true);
      return ctor.newInstance();
    } catch (Exception e) {
      System.out.println("Failed to create default object: " + type.getName());
      return null;
    }
  }

  public static void main(String[] args) {
    TestClass obj = new TestClass();

    Class<?> clazz = obj.getClass();

    for (Method method : clazz.getDeclaredMethods()) {
      if (Modifier.isPublic(method.getModifiers())) continue;
      if (!method.isAnnotationPresent(RunCount.class)) continue;

      int times = method.getAnnotation(RunCount.class).value();

      var params = Arrays.stream(method.getParameterTypes()).map(Main::getDefaultObject).toArray();

      for (int i = 0; i < times; i++) {
        try {
          method.setAccessible(true);
          method.invoke(obj, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

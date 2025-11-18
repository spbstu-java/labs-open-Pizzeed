import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
  public static void main(String[] args) {
    TestClass obj = new TestClass();

    Class<?> clazz = obj.getClass();

    for (Method method : clazz.getDeclaredMethods()) {

      if (method.isAnnotationPresent(RunCount.class)) {

        int times = method.getAnnotation(RunCount.class).value();

        method.setAccessible(true);
        for (int i = 0; i < times; i++) {
          try {
            method.invoke(obj);
          } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}

import java.util.*;
import java.util.stream.*;

public class Tasks {

  // Среднее значение списка целых чисел
  public static double average(List<Integer> list) {
    return list.stream()
        .mapToInt(Integer::intValue)
        .average()
        .orElseThrow(() -> new IllegalArgumentException("List is empty"));
  }

  // Верхний регистр + префикс "_new_"
  public static List<String> toUpperWithPrefix(List<String> list) {
    return list.stream().map(s -> "_new_" + s.toUpperCase()).toList();
  }

  // Квадраты элементов, которые встречаются ровно 1 раз
  public static List<Integer> uniqueSquares(List<Integer> list) {
    return list.stream()
        .filter(n -> list.stream().filter(x -> x.equals(n)).count() == 1)
        .map(n -> n * n)
        .toList();
  }

  // Последний элемент коллекции или исключение
  public static <T> T lastElement(Collection<T> collection) {
    return collection.stream()
        .reduce((first, second) -> second)
        .orElseThrow(() -> new NoSuchElementException("Collection is empty"));
  }

  // Сумма чётных чисел массива или 0, если их нет
  public static int sumEven(List<Integer> list) {
    return list.stream().mapToInt(Integer::intValue).filter(n -> n % 2 == 0).sum();
  }

  //  Map из строк: ключ = первая буква, значение = остальной текст
  public static Map<Character, String> toMap(List<String> list) {
    return list.stream()
        .collect(
            Collectors.toMap(
                s -> s.charAt(0), s -> s.substring(1), (existing, replacement) -> existing));
  }
}

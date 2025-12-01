import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 5);
    List<String> strings = Arrays.asList("apple", "banana", "apricot");

    System.out.println("Среднее: " + Tasks.average(nums));
    System.out.println("Строки с префиксом: " + Tasks.toUpperWithPrefix(strings));
    System.out.println("Квадраты уникальных: " + Tasks.uniqueSquares(nums));
    System.out.println("Последний элемент: " + Tasks.lastElement(nums));
    System.out.println("Сумма чётных: " + Tasks.sumEven(nums));
    System.out.println("Map из строк: " + Tasks.toMap(strings));
  }
}

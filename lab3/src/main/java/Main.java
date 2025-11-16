import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Translator t = new Translator();
    try {
      t.loadDictionary("dict.txt");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter text:");
    String input = sc.nextLine();
    System.out.println(t.translate(input));
  }
}

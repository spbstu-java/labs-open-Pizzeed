public class TestClass {

  @RunCount(3)
  private void privateMethod1(int arg) {
    System.out.println("privateMethod1 executed " + arg);
  }

  private void privateMethod2(double arg) {
    System.out.println("privateMethod2 executed " + arg);
  }

  @RunCount(2)
  protected void protectedMethod1(String arg) {
    System.out.println("protectedMethod1 executed" + arg);
  }

  @RunCount(4)
  protected void protectedMethod2(int arg1, double arg2) {
    System.out.println("protectedMethod2 executed " + arg1 + " " + arg2);
  }

  public void publicMethod1(int arg) {
    System.out.println("publicMethod1 executed " + arg);
  }

  @RunCount(4)
  public void publicMethod2(double arg) {
    System.out.println("publicMethod2 executed" + arg);
  }
}

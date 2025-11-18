public class TestClass {

  @RunCount(3)
  private void privateMethod1() {
    System.out.println("privateMethod1 executed");
  }

  private void privateMethod2() {
    System.out.println("privateMethod2 executed");
  }

  @RunCount(2)
  protected void protectedMethod1() {
    System.out.println("protectedMethod1 executed");
  }

  protected void protectedMethod2() {
    System.out.println("protectedMethod2 executed");
  }

  public void publicMethod1() {
    System.out.println("publicMethod1 executed");
  }

  @RunCount(4)
  public void publicMethod2() {
    System.out.println("publicMethod2 executed");
  }
}

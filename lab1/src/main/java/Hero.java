package strategies;

public class Hero {

  public static class Position {
    int x;
    int y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public String toString() {
      return "{" + x + ", " + y + "}";
    }
  }

  public void setMoveStrategy(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public void move(Position positionTo) {
    moveStrategy.move(this, positionTo);
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public String toString() {
    return "The Hero is at " + position.toString() + " and is " + moveStrategy.getState();
  }

  private MoveStrategy moveStrategy = new WalkStrategy();
  private Position position = new Position(0, 0);
}

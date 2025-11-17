package strategies;

public class WalkStrategy implements MoveStrategy {
  @Override
  public void move(Hero hero, Hero.Position positionTo) {
    System.out.println(
        "Walking by foot from " + hero.getPosition().toString() + " to " + positionTo.toString());
    System.out.println("Boring...");
    hero.setPosition(positionTo);
  }

  @Override
  public String getState() {
    return "standing still like a lamp post";
  }
}

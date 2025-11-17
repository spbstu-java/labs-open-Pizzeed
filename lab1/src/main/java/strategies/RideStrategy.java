package strategies;

public class RideStrategy implements MoveStrategy {
  @Override
  public void move(Hero hero, Hero.Position positionTo) {
    System.out.println(
        "Riding on a horseback from "
            + hero.getPosition().toString()
            + " to "
            + positionTo.toString());
    System.out.println("Neigh!");
    hero.setPosition(positionTo);
  }

  @Override
  public String getState() {
    return "sitting atop his noble steed";
  }
}

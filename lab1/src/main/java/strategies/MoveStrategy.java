package strategies;

public interface MoveStrategy {

  void move(Hero hero, Hero.Position positionTo);

  String getState();
}

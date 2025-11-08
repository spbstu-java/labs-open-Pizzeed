package strategies;

interface MoveStrategy {

    void move(Hero hero, Position positionTo);

    String getState();
}

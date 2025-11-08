package strategies;

public class FlyStrategy implements MoveStrategy{
    @Override
    public void move(Hero hero, Position positionTo) {
        System.out.println("Flying through the sky from " + hero.getPosition().toString() + " to " + positionTo.toString());
        System.out.println("Whoosh!");
    }
    
    @Override
    public String getState() {
        return "flying through the sapphire skies";
    }
}

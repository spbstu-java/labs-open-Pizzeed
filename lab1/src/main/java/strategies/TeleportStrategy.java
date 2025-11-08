package strategies;

public class TeleportStrategy implements MoveStrategy{
    @Override
    public void move(Hero hero, Position positionTo) {
        System.out.println("Casting a teleportation spell from " + hero.getPosition().toString() + " to " + positionTo.toString());
        System.out.println("BZZZZZZT!!");
    }
    
    @Override
    public String getState() {
        return "casting a fascinating teleportation spell";
    }
}

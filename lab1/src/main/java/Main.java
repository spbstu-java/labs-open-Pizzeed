import strategies.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hero hero = new Hero();

        FlyStrategy flyStrategy = new FlyStrategy();
        TeleportStrategy teleportStrategy = new TeleportStrategy();
        RideStrategy rideStrategy = new RideStrategy();
        WalkStrategy walkStrategy = new WalkStrategy();

        System.out.println("A Hero moves out on a quest starting at " + hero.getPosition().toString());

        while(true)
        {
            System.out.println("What shall he do now?");
            System.out.println("1 - Take a walk");
            System.out.println("2 - Get on a horse");
            System.out.println("3 - Cast a flight spell");
            System.out.println("4 - Cast a teleportation spell");
            System.out.println("5 - Move");
            System.out.println("6 - Show current state");
            System.out.println("0 - Go home");
            System.out.println();
            int cmd = scanner.nextInt();
            switch(cmd)
            {
                case 1:
                    hero.setMoveStrategy(walkStrategy);
                    System.out.println("The Hero decides to take a walk");
                    break;
                case 2:
                    hero.setMoveStrategy(rideStrategy);
                    System.out.println("The Hero decides to get on a horse");
                    break;
                case 3:
                    hero.setMoveStrategy(flyStrategy);
                    System.out.println("The Hero decides to fly high above the clouds");
                    break;
                case 4:
                    hero.setMoveStrategy(teleportStrategy);
                    System.out.println("The Hero decides to cast a teleportation spell");
                    break;
                case 5:
                    System.out.print("Enter X Coordinate: ");
                    float x = scanner.nextFloat();
                    System.out.print("Enter Y coordinate: ");
                    float y = scanner.nextFloat();
                    hero.move(new Position(x, y));
                    break;
                case 6:
                    System.out.println(hero.toString());
                    break;
                case 0: 
                    System.out.println("The hero decides to go home and take a nap.");
                    System.exit(0);
                default: 
                    System.out.println("Invalid command");
                    continue;
            }
        }
    }
}

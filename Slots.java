// Imports
import java.util.Scanner;

public class Slots extends Casino {
    // Class Variables
    static int[] nums = {0, 0, 0};
    static int min = 1;
    static int max = 7;

    public void play() {
        // Intoduce
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Welcome to slots! The game costs $10, get all sevens and win $1000000! Press 1 to play and 0 to exit.");

        while (true) {
            // Create Slot Input
            Scanner slotScanner = new Scanner(System.in);
            int slotInput = slotScanner.nextInt();

            // Check Slot Input
            if (slotInput == 1 && money > 0) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

                // Take Fee
                money -= 10;

                // Assign Slot Numbers
                nums[0] = (int)(Math.random() * (max - min + 1) + min);
                nums[1] = (int)(Math.random() * (max - min + 1) + min);
                nums[2] = (int)(Math.random() * (max - min + 1) + min);

                // Check If You Win
                if (nums[0] == 7 && nums[1] == 7 && nums[2] == 7) {
                    System.out.println("You Win!");
                    money += 1000000;
                } else {
                    System.out.println("You Lost! Maybe Next Time?");
                }

                System.out.println("Numbers: " + nums[0] + ", " + nums[1] + ", " + nums[2]);
                System.out.println("Money: " + money);
                
            } else if (slotInput == 0) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                break;
            } else if (money <= 0) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Get out of my Casino.");
                break;
            } else {
                System.out.println("Invalid Option");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
            }
        }
    }
}

// Imports
import java.util.Scanner;

public class TwentyOne extends Casino {
    // Class Variables
    static int min = 1;
    static int max = 10;
    static int total = 0;
    static int opponentTotal = 0;
    static boolean done = false;

    // Functions
    private void lose() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("You lose!");

        System.out.println("Money: " + money);

        if (money > 0) {
            System.out.println("Press 0 to return to home or 1 to play again: ");
        }

        done = true;
    }

    private void win() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("You Win!");
        
        System.out.println("Money: " + money);
        System.out.println("Press 0 to return to home or 1 to play again: ");

        done = true;
    }

    private void tie() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Tie!");

        System.out.println("Money: " + money);
        System.out.println("Press 0 to return to home or 1 to play again: ");

        done = true;
    }

    public void play() {
        // Reset
        done = false;
        total = 0;
        opponentTotal = 0;

        // Introduce
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Welcome to 21! Get a higher score than the opponent, but don't go over 21! Press 1 to play and 0 to exit.");

        while (true) {
            // Setup User Input
            Scanner twentyOneScanner = new Scanner(System.in);
            int twentyOneInput = twentyOneScanner.nextInt();

            // Reset
            total = 0;
            opponentTotal = 0;
            done = false;

            // Setup User Input Conditionals
            if (twentyOneInput == 1 && money > 0) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Bet: ");

                // Bet User Input
                Scanner betScanner = new Scanner(System.in);
                float bet = betScanner.nextFloat();

                // Check If The Bet Is Valid
                if (bet < 0) {
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("Nice Try");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                    break;
                }

                // Claim Bet
                money -= bet;

                // Get Hands
                total += (int)(Math.random() * (max - min + 1) + min);
                total += (int)(Math.random() * (max - min + 1) + min);

                opponentTotal += (int)(Math.random() * (max - min + 1) + min);
                opponentTotal += (int)(Math.random() * (max - min + 1) + min);

                // Display Hands
                System.out.println("Opponent Total: " + opponentTotal);
                System.out.println("Your Total: " + total);

                // Play Loop
                while (!done) {
                    // Draw User Input
                    Scanner drawScanner = new Scanner(System.in);
                    int draw = drawScanner.nextInt();

                    // Draw User Input Conditionals
                    if (draw == 1) {
                        // User Draws Card
                        total += (int)(Math.random() * (max - min + 1) + min);

                        // Bot Draws Card
                        opponentTotal += (int)(Math.random() * (max - min + 1) + min);

                        // Display Hands
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                        System.out.println("Opponent Total: " + opponentTotal);
                        System.out.println("Your Total: " + total);

                        // Check If Someone Wins Or Loses After That Turn
                        if (opponentTotal == total && opponentTotal > 21 && total > 21) {
                            money += bet;
                            tie();
                        } else if (opponentTotal > 21 && total > 21) {
                            money += bet;
                            tie();
                        } else if (opponentTotal == 21 && total < 21) {
                            lose();
                        } else if (total == 21 && opponentTotal < 21) {
                            money += bet * 2;
                            win();
                        } else if (opponentTotal > 21) {
                            money += bet * 2;
                            win();
                        } else if (total > 21) {
                            lose();
                        }
                    
                    } else if (draw == 0) {
                        // Bot Draws
                        opponentTotal += (int)(Math.random() * (max - min + 1) + min);

                        // Display Hands
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                        System.out.println("Opponent Total: " + opponentTotal);
                        System.out.println("Your Total: " + total);

                        // Check Who Wins Or Loses
                        if (opponentTotal == total) {
                            money += bet;
                            tie();
                        } else if (opponentTotal < total) {
                            money += bet * 2;
                            win();
                        } else if (opponentTotal > 21) {
                            money += bet * 2;
                            win();
                        } else if (opponentTotal > total && opponentTotal < 22) {
                            lose();
                        }
                    
                    // Checks If The Input Is Valid
                    } else {
                        System.out.println("Invalid Option");
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                    }
                }
            
            } else if (twentyOneInput == 0) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                break;
            } else {
                System.out.println("Invalid Option");
            }

            // Checks If You Have Enough Money To Play
            if (money <= 0) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Get out of my Casino.");
                break;
            }
        }
    }
}

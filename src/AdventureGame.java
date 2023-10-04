import java.util.Scanner;

public class AdventureGame {
    private static int playerHealth = 100;
    private static int playerGold = 0;
    private static String playerName = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You find yourself in a mysterious dungeon.");
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "! Choose your character:\n1. Warrior\n2. Wizard");
        int characterChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (characterChoice == 1) {
            System.out.println("You have chosen the Warrior class. Your journey begins!");
        } else if (characterChoice == 2) {
            System.out.println("You have chosen the Wizard class. Your journey begins!");
        } else {
            System.out.println("Invalid choice. Starting as a Warrior.");
        }

        enterDungeon(scanner);
        scanner.close();
    }

    private static void enterDungeon(Scanner scanner) {
        System.out.println("You enter a dark room. Do you want to enter? (yes/no)");
        String enterChoice = scanner.nextLine();

        if (enterChoice.equalsIgnoreCase("yes")) {
            System.out.println("You enter the room and find two doors.");
            System.out.println("Which door do you choose?\n1. Left\n2. Right");
            int doorChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (doorChoice == 1) {
                System.out.println("You open the left door...");
                if (Math.random() < 0.5) {
                    System.out.println("Congratulations! You find a treasure chest with 100 gold.");
                    playerGold += 100;
                    winGame();
                } else {
                    System.out.println("Oh no! A trap is triggered and you are hit.");
                    playerHealth -= 30;
                    checkPlayerHealth(scanner);
                }
            } else if (doorChoice == 2) {
                System.out.println("You open the right door...");
                if (Math.random() < 0.5) {
                    System.out.println("Congratulations! You discover a secret passage and find the exit.");
                    winGame();
                } else {
                    System.out.println("Oops! The room is filled with toxic gas. You struggle to breathe.");
                    playerHealth -= 40;
                    checkPlayerHealth(scanner);
                }
            } else {
                System.out.println("Invalid choice. Try again.");
                enterDungeon(scanner);
            }
        } else if (enterChoice.equalsIgnoreCase("no")) {
            System.out.println("You decide not to enter the room. The adventure ends here.");
            loseGame();
        } else {
            System.out.println("Invalid choice. Try again.");
            enterDungeon(scanner);
        }
    }

    private static void checkPlayerHealth(Scanner scanner) {
        System.out.println("Your health: " + playerHealth);
        if (playerHealth <= 0) {
            System.out.println("Game over! You have lost all your health.");
            loseGame();
        } else {
            enterDungeon(scanner);
        }
    }

    private static void winGame() {
        System.out.println("Congratulations, " + playerName + "! You have won the game.");
        System.out.println("Final health: " + playerHealth);
        System.out.println("Final gold: " + playerGold);
    }

    private static void loseGame() {
        System.out.println("Better luck next time, " + playerName + ".");
        System.out.println("Final health: " + playerHealth);
        System.out.println("Final gold: " + playerGold);
    }
}
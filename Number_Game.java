package YashM;
import java.util.*;

public class Number_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("WELCOME TO THE NUMBER GAME");
        System.out.println("Enter 'start' to start the game. Type 'exit' to quit.");

        while (true) {
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("start")) {
                play();
            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("Closing Program.");
                break;
            } else {
                System.out.println("Enter 'start' to start the game. Type 'exit' to quit.");
            }
        }
    }

    static void play() {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("\nStarting the game\n");

        int a, guess, start = 5;
        boolean flag = false;
        boolean go_on = true;

        while (go_on) {
            a = r.nextInt(100) + 1;

            while (start > 0) {
                System.out.println("Enter your Guess (chances left: " + start + "): ");
                guess = sc.nextInt();

                if (guess == a) {
                    flag = true;
                    break;
                } else {
                    if (guess < a) {
                        System.out.println("Your guess is too low.");
                    } else {
                        System.out.println("Your guess is too high.");
                    }
                    start--;
                }
            }

            if (flag) {
                System.out.println("Congratulations! You won the game.");
            } else {
                System.out.println("Oops! The number was " + a);
            }

            System.out.println("Do you want to play again? (Y/N)");
            String b = sc.next();
            if (b.equalsIgnoreCase("N")) {
                go_on = false;
            } else {
                // Reset the game
                start = 5;
                flag = false;
            }
        }
        System.out.println("Thank you for Playing...");
        }
}

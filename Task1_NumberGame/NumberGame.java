import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            int number = random.nextInt(100) + 1; // 1–100
            int attempts = 5;
            int guess;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and 100");
            System.out.println("You have " + attempts + " attempts.");

            while (attempts > 0) {

                System.out.print("Enter your guess: ");
                guess = sc.nextInt();

                // RANGE VALIDATION
                if (guess < 1 || guess > 100) {
                    System.out.println("⚠ Invalid input! Please enter a number between 1 and 100.");
                    continue; // does not reduce attempts
                }

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    score++;
                    guessedCorrectly = true;
                    break;
                }
                else if (guess > number) {
                    System.out.println("Too high!");
                }
                else {
                    System.out.println("Too low!");
                }

                attempts--;
                System.out.println("Attempts left: " + attempts);
            }

            if (!guessedCorrectly) {
                System.out.println("You lost! The correct number was: " + number);
            }

            System.out.println("Your Score: " + score);

            System.out.print("\nDo you want to play again? (1 = Yes, 0 = No): ");
            playAgain = sc.nextInt();

        } while (playAgain == 1);

        System.out.println("\nFinal Score: " + score);
        System.out.println("Thank you for playing!");
        sc.close();
    }
}

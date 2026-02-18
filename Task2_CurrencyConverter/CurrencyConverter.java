import java.util.Scanner;

public class CurrencyConverter {

    // Method to get conversion rate
    static double getRate(int from, int to) {

        // Rates with respect to INR
        double INR = 1.0;
        double USD = 83.0;   // 1 USD = 83 INR
        double EUR = 90.0;   // 1 EUR = 90 INR

        double fromRate = 0, toRate = 0;

        switch (from) {
            case 1: fromRate = INR; break;
            case 2: fromRate = USD; break;
            case 3: fromRate = EUR; break;
            default: return -1;
        }

        switch (to) {
            case 1: toRate = INR; break;
            case 2: toRate = USD; break;
            case 3: toRate = EUR; break;
            default: return -1;
        }

        return fromRate / toRate;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== CURRENCY CONVERTER =====");
            System.out.println("1. INR");
            System.out.println("2. USD");
            System.out.println("3. EUR");

            System.out.print("Select Base Currency (1-3): ");
            int from = sc.nextInt();

            System.out.print("Select Target Currency (1-3): ");
            int to = sc.nextInt();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            double rate = getRate(from, to);

            if (rate == -1) {
                System.out.println("Invalid currency selection!");
            } else {
                double convertedAmount = amount * rate;
                System.out.println("Converted Amount = " + convertedAmount);
            }

            System.out.print("\nDo you want to convert again? (1-Yes / 0-No): ");
            choice = sc.nextInt();

        } while (choice == 1);

        System.out.println("Thank you for using Currency Converter!");
        sc.close();
    }
}

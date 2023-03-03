import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * This is the main function that runs the currency conversion program.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Coin coin = null;
        List<Double> resultList = new ArrayList<>();
        System.out.println("Welcome to currency converter");

        // Get user input and perform currency conversion until user decides to stop

        String option;
        do {
            displayOptions();

            option = getUserOption(scanner);

            if (option.equals("1")) {
                coin = CoinFactory.getCoinInstance(Coins.USD);
            } else if (option.equals("2")) {
                coin = CoinFactory.getCoinInstance(Coins.ILS);
            }

            System.out.println("Please enter an amount to convert");
            double amount = getAmount(scanner);
            double result = coin.calculate(amount);
            System.out.println(result);
            resultList.add(result);

            System.out.println("You want to start over Y / N");
            option = scanner.next();
            while (!option.equalsIgnoreCase("y") && !option.equalsIgnoreCase("n")) {
                System.out.println("Invalid choice, please enter 'Y' or 'N'");
                option = scanner.next();
            }
        } while (option.equalsIgnoreCase("y"));

        System.out.println("Thanks for using our currency converter");
        String filePath = "C:\\Users\\Avi\\Desktop\\result.txt";

        printResults(resultList);

        writeResultsToFile(filePath, resultList);
    }

    /**
     * Displays the available currency conversion options to the user.
     */
    public static void displayOptions() {
        System.out.println("Please choose an option (1/2): \n 1. Dollars to Shekels " +
                "\n 2. Shekels to Dollars ");
    }

    /**
     * Gets the user's choice for the available currency conversion options.
     */
    public static String getUserOption(Scanner scanner) {
        String option = scanner.next();
        while (!option.equals("1") && !option.equals("2")) {
            System.out.println("Invalid Choice, please try again");
            displayOptions();
            option = scanner.next();
        }
        return option;
    }

    /**
     * Gets a numeric amount to be used for currency conversion.
     */
    public static double getAmount(Scanner scanner) {
        double amount = 0;
        boolean validInput = false;
        while (validInput == false) {
            try {
                amount = Double.parseDouble(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number in the format of double (e.g. 12.50)");
            }
        }
        return amount;
    }
    /**
     * Prints the currency conversion results to the console.
     */
    public static void printResults(List<Double> resultList) {
        System.out.println("Conversion Results:");
        for (Double result : resultList) {
            System.out.printf("%.2f%n", result);
        }
    }
    /**
     * Writes the currency conversion results to a file.
     */
    public static void writeResultsToFile(String filePath, List<Double> resultList) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filePath));
            writer.println("Conversion Results:");
            for (Double result : resultList) {
                writer.printf("%.2f%n", result);
            }
            writer.close();
            System.out.println("Results written to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing results to file: " + e.getMessage());
        }
    }




}

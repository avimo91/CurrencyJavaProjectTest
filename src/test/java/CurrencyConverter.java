import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CurrencyConverter {

    /**
     * This is the main function that runs the currency conversion program.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Coin coin = null;
        List<Result> resultList = new ArrayList<>();
        System.out.println("Welcome to currency converter");

        // Get user input and perform currency conversion until user decides to stop

        String option;
        do {
            displayOptions();

            option = getUserOption(scanner);

            String conversionFlow = "";

            if (option.equals("1")) {
                coin = CoinFactory.getCoinInstance(Coins.USD);
                conversionFlow = "USD to ILS";
            } else if (option.equals("2")) {
                coin = CoinFactory.getCoinInstance(Coins.ILS);
                conversionFlow = "ILS to USD";
            }else if (option.equals("3")) {
                coin = CoinFactory.getCoinInstance(Coins.EUR);
                conversionFlow = "ILS to EUR";
            }


            double amount = getAmount(scanner);
            double result = coin.calculate(amount);
            Result resultCurrency = new Result(result, conversionFlow);
            System.out.println(result);
            resultList.add(resultCurrency);

        } while (wantToStartOver(scanner));

        System.out.println("Thanks for using our currency converter");
        String filePath = "C:\\Users\\Avi\\Desktop\\result.txt";

        printResults(resultList);

        writeResultsToFile(filePath, resultList);
    }

    /**
     * Displays the available currency conversion options to the user.
     */
    public static void displayOptions() {
        System.out.println("Please choose an option (1/2/3): \n 1. Dollars to Shekels " +
                "\n 2. Shekels to Dollars \n 3. Shekels to Euros");
    }

    /**
     * Gets the user's choice for the available currency conversion options.
     */
    public static String getUserOption(Scanner scanner) {
        String option = scanner.next();
        while (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
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
        System.out.println("Please enter an amount to convert");
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
     * Asks the user if they want to start over and returns a boolean indicating the answer.
     */
    public static boolean wantToStartOver(Scanner scanner) {
        System.out.println("Do you want to start over? Y / N");
        String option = scanner.next();
        while (!option.equalsIgnoreCase("y") && !option.equalsIgnoreCase("n")) {
            System.out.println("Invalid choice, please enter 'Y' or 'N'");
            option = scanner.next();
        }
        return option.equalsIgnoreCase("y");
    }

    /**
     * Prints the currency conversion results to the console.
     */
    public static void printResults(List<Result> resultList) {
        System.out.println("Conversion Results:");
        for (Result result : resultList) {
            System.out.printf("%.2f %s %n", result.getResult(), result.getConversionFlow() );
        }
    }

    /**
     * Writes the currency conversion results to a file.
     */
    public static void writeResultsToFile(String filePath, List<Result> resultList) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filePath));
            writer.println("Conversion Results:");
            for (Result result : resultList) {
                writer.printf("%.2f %s %n", result.getResult(), result.getConversionFlow());
            }
            writer.close();
            System.out.println("Results written to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing results to file: " + e.getMessage());
        }
    }


}
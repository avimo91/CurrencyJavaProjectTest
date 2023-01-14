import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double input = scanner.nextDouble();
        Coin ilsValue = CoinFactory.getCoinInstance(Coins.USD);
        double value = usd.calculate(input);
    }
}

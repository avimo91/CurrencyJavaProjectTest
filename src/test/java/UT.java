import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

public class UT {

    @Test
    public void testGetAmount() {
        Coin coin = null;

        double amount = 12.8;
        coin = CoinFactory.getCoinInstance(Coins.USD);
        double expected = 3.52*amount;
        double actual = coin.calculate(amount);

        Assert.assertEquals(expected, actual, 0.0001 );
    }
    @Test
    public void readFile() throws FileNotFoundException {
        String filePath = "C:\\Users\\Avi\\Desktop\\result.txt";
        String expectedFileContent = "Conversion Results:1518.72 ILS to USD";

        // Read the file and compare contents
        Scanner scanner = new Scanner(new FileReader(filePath));
        String fileContent = "";
        while (scanner.hasNextLine()) {
            fileContent += scanner.nextLine().trim();
        }
        scanner.close();
        System.out.println("File contents: " + fileContent);
        Assert.assertEquals(expectedFileContent, fileContent);
    }
}

public class CoinFactory {
    public static Coin getCoinInstance(Coins coin) {
        switch (coin) {
            case ILS:
                return new ILS();
            case USD:
                return new USD();
            default:
                throw new IllegalArgumentException("Invalid coin type: " + coin);
        }
    }

}

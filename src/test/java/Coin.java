public abstract class Coin implements ICalculate {
    public abstract double getValue();

    @Override
    public double calculate(double value) {
        return value;
    }
}



//public abstract class Coin implements ICalculate {
//    /**
//     * Abstract method to get the value of the coin
//     * @return double
//     */
//    public abstract double getValue();
//    /**
//     * Method to calculate the value of the coin
//     * @param value the value to be calculated
//     * @return double
//     */
//    @Override
//    public double calculate(double value) {
//        return value;
//    }
//}
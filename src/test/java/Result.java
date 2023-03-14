public class Result {
    private double result;
    private String conversionFlow;

    public Result(double inResult, String inConversionFlow) {
        result = inResult;
        conversionFlow = inConversionFlow;
    }

    public double getResult() {
        return result;
    }
    public String getConversionFlow(){
        return conversionFlow;
    }
}

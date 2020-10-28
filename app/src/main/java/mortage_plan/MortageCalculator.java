package mortage_plan;

public class MortageCalculator {

    /**
     * Pow function with time complexity O(n) where n = exponent
     * Implemented because use of java.math is not allowed
     * @param base
     * @param exponent
     * @return
     */
    public static double pow(double base, int exponent) {
        double result = 1.0;
        for(int i = exponent; i > 0; i--) {
            result *= base;
        }
        return result;
    }

    /**
     * Calculate the amount to pay each month
     * NOTE this can have precision issues that could be improved by using BigDecimal from java.math
     * @param totalLoan The total amount ot the loan
     * @param numberOfPayments How many payments is the loan going to be paid in
     * @param yearlyInterest Yearly interest
     * @return The amount the customer should pay each month to pay of the loan with interest
     */
    public static double CalculateMonthlyPayment(double totalLoan, int numberOfPayments, double yearlyInterest) {
        // The mortage formula uses interest on a monthly basis which is the yearly interest divided by 12 months
        double monthlyInterest = yearlyInterest / 12.0;
        double pow = MortageCalculator.pow(1 + monthlyInterest, numberOfPayments);
        return totalLoan * (monthlyInterest * pow) / (pow-1);
    }
}

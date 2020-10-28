package mortage_plan;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<CustomerLoan> loans;
        if(args.length > 0 && args[0].equals("useDatabase")) {
            loans = DataLoader.LoadCustomerLoansFromDatabase();
        } else {
            loans = DataLoader.LoadCustomerLoansFromFile();
        }

        int i = 0;
        for (; i < loans.size(); i++) {
            CustomerLoan loan = loans.get(i);
            double monthlyPayment = MortageCalculator.CalculateMonthlyPayment(loan.total, loan.years*12, loan.yearlyInterest);
            System.out.println("****************************************************************************************************");
            System.out.printf("Prospect %d: %s wants to borrow %.2f€ for a period of %d years and pay %.2f€ each month\n",
                    i+1, loan.customerName, loan.total, loan.years, monthlyPayment);
        }
        // Only print end if we actually printed some output
        if(i>0) System.out.println("****************************************************************************************************");
    }
}

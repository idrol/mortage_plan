package mortage_plan;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DataLoaderTest {
    @Test
    public void TestLoadCustomerLoansFromFile() {
        System.out.println("Testing FileReader.LoadCustomerLoansFromFile");
        ArrayList<CustomerLoan> loans = DataLoader.LoadCustomerLoansFromFile();

        CustomerLoan loan1Actual = loans.get(0);
        CustomerLoan loan1Expected = new CustomerLoan();
        loan1Expected.customerName = "Juha";
        loan1Expected.total = 1000.0;
        loan1Expected.yearlyInterest = 0.05;
        loan1Expected.years = 2;
        assertEquals(loan1Expected, loan1Actual);

        CustomerLoan loan2Actual = loans.get(1);
        CustomerLoan loan2Expected = new CustomerLoan();
        loan2Expected.customerName = "Karvinen";
        loan2Expected.total = 4356.0;
        loan2Expected.yearlyInterest = 0.0127;
        loan2Expected.years = 6;
        assertEquals(loan2Expected, loan2Actual);

        CustomerLoan loan3Actual = loans.get(2);
        CustomerLoan loan3Expected = new CustomerLoan();
        loan3Expected.customerName = "Claes Månsson";
        loan3Expected.total = 1300.55;
        loan3Expected.yearlyInterest = 0.0867;
        loan3Expected.years = 2;
        assertEquals(loan3Expected, loan3Actual);

        CustomerLoan loan4Actual = loans.get(3);
        CustomerLoan loan4Expected = new CustomerLoan();
        loan4Expected.customerName = "Clarencé,Andersson";
        loan4Expected.total = 2000.0;
        loan4Expected.yearlyInterest = 0.06;
        loan4Expected.years = 4;
        assertEquals(loan4Expected, loan4Actual);
    }

    @Test
    public void TestLoadCustomerLoansFromDatabase() {
        System.out.println("Testing FileReader.LoadCustomerLoansFromDatabase");
        ArrayList<CustomerLoan> loans = DataLoader.LoadCustomerLoansFromDatabase();

        CustomerLoan loan1Actual = loans.get(0);
        CustomerLoan loan1Expected = new CustomerLoan();
        loan1Expected.customerName = "Juha";
        loan1Expected.total = 1000.0;
        loan1Expected.yearlyInterest = 0.05;
        loan1Expected.years = 2;
        assertEquals(loan1Expected, loan1Actual);

        CustomerLoan loan2Actual = loans.get(1);
        CustomerLoan loan2Expected = new CustomerLoan();
        loan2Expected.customerName = "Karvinen";
        loan2Expected.total = 4356.0;
        loan2Expected.yearlyInterest = 0.0127;
        loan2Expected.years = 6;
        assertEquals(loan2Expected, loan2Actual);

        CustomerLoan loan3Actual = loans.get(2);
        CustomerLoan loan3Expected = new CustomerLoan();
        loan3Expected.customerName = "Claes Månsson";
        loan3Expected.total = 1300.55;
        loan3Expected.yearlyInterest = 0.0867;
        loan3Expected.years = 2;
        assertEquals(loan3Expected, loan3Actual);

        CustomerLoan loan4Actual = loans.get(3);
        CustomerLoan loan4Expected = new CustomerLoan();
        loan4Expected.customerName = "Clarencé,Andersson";
        loan4Expected.total = 2000.0;
        loan4Expected.yearlyInterest = 0.06;
        loan4Expected.years = 4;
        assertEquals(loan4Expected, loan4Actual);
    }
}

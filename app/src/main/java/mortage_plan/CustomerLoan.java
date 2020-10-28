package mortage_plan;

public class CustomerLoan {
    public String customerName;
    public double total;
    public double yearlyInterest;
    public int years;

    public boolean equals(Object other) {
        if(!(other instanceof CustomerLoan)) return false;
        CustomerLoan otherLoan = (CustomerLoan)other;
        return customerName.equals(otherLoan.customerName) &&
                total == otherLoan.total &&
                yearlyInterest == otherLoan.yearlyInterest &&
                years == otherLoan.years;
    }
}

package mortage_plan;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

import com.opencsv.CSVParser;

public class DataLoader {
    /**
     * Load the data from prospects.txt
     * @return ArrayList of loans loaded from prospects.txt
     */
    public static ArrayList<CustomerLoan> LoadCustomerLoansFromFile() {
        ArrayList<CustomerLoan> list = new ArrayList<>();
        InputStream stream = DataLoader.class.getClassLoader().getResourceAsStream("prospects.txt");
        if(stream == null) {
            System.out.println("Failed to open prospects.txt");
            return new ArrayList<>();
        }
        CSVParser parser = new CSVParser();
        Scanner scanner = new Scanner(stream);
        scanner.nextLine(); // Skip header

        // Go through each line and use the csv parse to correctly split lines and the construct a CustomerLoan object
        while(scanner.hasNextLine()) {
            try {
                String line = scanner.nextLine();
                if(line.isBlank()) continue; // Ignore blank lines
                String[] data = parser.parseLine(line);

                try {
                    CustomerLoan loan = new CustomerLoan();
                    loan.customerName = data[0];
                    loan.total = Double.parseDouble(data[1]);
                    // Parse the interest column
                    // according to the CEO of the bank the interest is a fixed yearly %
                    loan.yearlyInterest = Double.parseDouble(data[2]) / 100; // Convert interest from 5% to 0.05
                    loan.years = Integer.parseInt(data[3]);

                    list.add(loan);
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    // If the data does not contain 4 columns or any column that should be a number is not a number
                    //   then log the line to the console and continue instead of crashing
                    System.out.printf("Could not read line: \"%s\". This line will be ignored!\n", line);
                }
            } catch(IOException e) {
                System.out.println("Failed to parse csv line");
            }
        }
        return list;
    }

    public static ArrayList<CustomerLoan> LoadCustomerLoansFromDatabase() {
        String dbUrl = "jdbc:mysql://localhost/mortage_plan?useUnicode=yes&characterEncoding=UTF-8";
        String user = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;
        ArrayList<CustomerLoan> loans = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl,user,password);
            statement = connection.createStatement();
            String sql;
            sql = "SELECT * FROM prospects";
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                CustomerLoan loan = new CustomerLoan();
                loan.customerName = result.getString("customer");
                loan.total = result.getDouble("total_loan");
                loan.yearlyInterest = result.getDouble("interest")/100;
                loan.years = result.getInt("years");
                loans.add(loan);

            }
            result.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            System.out.println("Failed to Load data from server: localhost table: mortage_plan user: root password: password");
            e.printStackTrace();
            return new ArrayList<>();
        }finally{
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){}
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return loans;
    }
}

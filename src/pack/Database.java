package pack;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Database {

    private static boolean isConnected = false;
    private static Connection c;
    private static Statement s;

    // method to set connection
    private static void SetConnecion() {

        if (!isConnected) {
            try {
                c = DriverManager.getConnection("jdbc:mysql:///user_accounts", "root", "admin");
                s = c.createStatement();
                isConnected = true;
            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    }

    // method to add account to database
    public static void AddAccount(Account account) {

        SetConnecion();

        try {
            String query;
            query = "INSERT INTO users \n" +
                    "(accountNum, fullName, fatherName, dob, cnic, gender, email, phoneNum, pinCode, initialDeposit, balance)\n"
                    +
                    "VALUES\n" +
                    "('" +
                    account.getAccountNum() + "', '" +
                    account.getfullName() + "', '" +
                    account.getfatherName() + "', '" +
                    account.getDOB() + "', '" +
                    account.getCNIC() + "', '" +
                    account.getGender() + "', '" +
                    account.getEmail() + "', '" +
                    account.getPhoneNum() + "', '" +
                    account.getPinCode() + "', '" +
                    account.getIniDeposit() + "','" +
                    account.getBalance() + "');";

            s.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    // method to check whether the user exists in database
    public static boolean CheckUser(String accountNum, String pinCode) {

        boolean present = false;
        SetConnecion();

        try {
            if (CheckAccount(accountNum)) {
                String query;
                query = String.format("SELECT pinCode FROM users WHERE accountNum = %s", accountNum);

                ResultSet rs = s.executeQuery(query);
                rs.next();
                if (pinCode.equals(rs.getString("pinCode"))) {
                    present = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        if (present)
            return true;
        else
            return false;
    }

    // method to check whether the account number exists in database
    public static boolean CheckAccount(String accountNum) {

        boolean present = false;
        SetConnecion();

        try {
            String query;
            query = String.format("SELECT accountNum FROM users");

            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                if (accountNum.equals(rs.getString("accountNum"))) {
                    present = true;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        if (present)
            return true;
        else
            return false;

    }

    // method to retrieve any data
    public static String GetData(String accountNum, String info) {

        SetConnecion();
        String data = "";

        try {
            String query;
            query = String.format("SELECT %s FROM users WHERE accountNum = %s", info, accountNum);

            ResultSet rs = s.executeQuery(query);
            rs.next();
            data = "" + rs.getString(info);

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        return data;
    }

    // method to add amount
    public static void AddBalance(String accountNum, double amount) {

        SetConnecion();
        try {
            String query;
            query = String.format("SELECT balance FROM users WHERE accountNum = %s", accountNum);

            ResultSet rs = s.executeQuery(query);
            rs.next();
            String balanceStr = rs.getString("balance");
            double balance = Double.parseDouble(balanceStr);
            balance += amount;

            query = String.format("UPDATE users SET balance = %f WHERE accountNum = %s", balance, accountNum);
            s.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

    }

    // method to Subtract amount
    public static void Subtractbalance(String accountNum, double amount) {

        SetConnecion();
        try {
            String query;
            query = String.format("SELECT balance FROM users WHERE accountNum = %s", accountNum);

            ResultSet rs = s.executeQuery(query);
            rs.next();
            String balanceStr = rs.getString("balance");
            double balance = Double.parseDouble(balanceStr);

            balance -= amount;

            query = String.format("UPDATE users SET balance = %f WHERE accountNum = %s", balance, accountNum);
            s.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    // method to check if the pin matches
    public static boolean CheckPin(String accountNum, String prePin) {

        SetConnecion();
        boolean present = false;
        String pin = "";

        try {
            String query;
            query = String.format("SELECT pinCode FROM users WHERE accountNum = %s", accountNum);

            ResultSet rs = s.executeQuery(query);
            rs.next();
            pin = "" + rs.getString("pinCode");

            if (pin.equals(prePin))
                present = true;

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        if (present)
            return true;
        else
            return false;
    }

    // method to change pin
    public static void ChangePin(String accountNum, String pin) {

        SetConnecion();

        try {

            String query;
            query = String.format("UPDATE users SET pinCode = %s WHERE accountNum = %s", pin, accountNum);
            s.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    // method to update the user details
    public static void UpdateUser(String accountNum, String fullName, String fatherName, String DOB, String CNIC,
            String gender, String email, String phoneNum) {

        SetConnecion();

        try {
            String query;
            query = String.format("UPDATE users SET " +
                    "fullName = '%s', " +
                    "fatherName = '%s', " +
                    "dob = '%s', " +
                    "cnic = '%s', " +
                    "gender = '%s', " +
                    "email = '%s', " +
                    "phoneNum = '%s' " +
                    "WHERE accountNum = '%s'", fullName, fatherName, DOB, CNIC, gender, email, phoneNum, accountNum);

            s.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

    }
}

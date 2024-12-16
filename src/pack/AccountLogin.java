package pack;

public class AccountLogin {

    private static Account account;

    public static Account GetUser(String accountNum) {

        String fullName = Database.GetData(accountNum, "fullName");
        String fatherName = Database.GetData(accountNum, "fatherName");
        String DOB = Database.GetData(accountNum, "dob");
        String CNIC = Database.GetData(accountNum, "cnic");
        String gender = Database.GetData(accountNum, "gender");
        String email = Database.GetData(accountNum, "email");
        String phoneNum = Database.GetData(accountNum, "phoneNum");
        String pinCode = Database.GetData(accountNum, "pinCode");
        double iniDeposit = Double.parseDouble(Database.GetData(accountNum, "initialDeposit"));
        double balance = Double.parseDouble(Database.GetData(accountNum, "balance"));

        account = new Account(accountNum, fullName, fatherName, DOB, CNIC, gender, email,
                phoneNum, pinCode, iniDeposit, balance);

        return account;
    }

}

package pack;

import java.util.Random;

public class AccountRegistration {

    private static Account account;

    public AccountRegistration() {
        // Constructor
    }

    // method to create account
    public static Account CreateAccount(String fullName, String fatherName, String DOB, String CNIC,
            String gender, String email, String phoneNum, String pinCode, double iniDepositAmnt) {

        String accountNum = GenerateAccountNum();

        account = new Account(accountNum, fullName, fatherName, DOB, CNIC, gender, email,
                phoneNum, pinCode, iniDepositAmnt, iniDepositAmnt);

        Database.AddAccount(account);

        return account;
    }

    private static String GenerateAccountNum() {

        final String PREFIX = "0019";
        String accountNum = PREFIX;

        do {

            accountNum = "";
            accountNum += PREFIX;

            // Generate random digits
            Random random = new Random();

            for (int i = 0; i < 8; i++) {
                accountNum += random.nextInt(10); // Append random digit (0-9)
            }

            if (CheckUnique(accountNum))
                break;

        } while (true);

        return accountNum;

    }

    private static boolean CheckUnique(String accountNum) {

        System.out.println("Hello World");

        if (!Database.CheckAccount(accountNum))
            return true;
        else
            return false;

    }

}

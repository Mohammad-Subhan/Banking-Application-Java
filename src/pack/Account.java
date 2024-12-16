package pack;

public class Account {

    // Personal Details Fields
    private String fullName;
    private String fatherName;
    private String DOB;
    private String CNIC;
    private String gender;
    private String email;
    private String phoneNum;

    // Account Details Fields
    private String accountNum;
    private String pinCode;
    private double iniDeposit;
    private double balance;

    // Constructor
    public Account(String accountNum, String fullName, String fatherName, String DOB, String CNIC,
            String gender, String email, String phoneNum, String pinCode, double iniDepositAmnt,
            double amount) {

        setAccountNum(accountNum);
        setfullName(fullName);
        setfatherName(fatherName);
        setDOB(DOB);
        setCNIC(CNIC);
        setGender(gender);
        setEmail(email);
        setPhoneNum(phoneNum);
        setPinCode(pinCode);
        setIniDeposit(iniDepositAmnt);
        setBalance(amount);
    }

    public void setfullName(String newfullName) {
        fullName = newfullName;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfatherName(String newfatherName) {
        fatherName = newfatherName;
    }

    public String getfatherName() {
        return fatherName;
    }

    public void setDOB(String newDOB) {
        DOB = newDOB;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String newCNIC) {
        CNIC = newCNIC;
    }

    public String getDOB() {
        return DOB;
    }

    public void setGender(String newGender) {
        gender = newGender;
    }

    public String getGender() {
        return gender;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNum(String newPhoneNum) {
        phoneNum = newPhoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setAccountNum(String newAccountNum) {
        accountNum = newAccountNum;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setPinCode(String newPinCode) {
        pinCode = newPinCode;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setIniDeposit(double newIniDeposit) {
        iniDeposit = newIniDeposit;
    }

    public double getIniDeposit() {
        return iniDeposit;
    }

    public void setBalance(double newIniDeposit) {
        balance = newIniDeposit;
    }

    public double getBalance() {
        return balance;
    }

    // method to deposit amount
    public void CashDeposit(double balance) {

        this.balance += balance;
        Database.AddBalance(accountNum, balance);

    }

    // method to withdraw cash
    public void CashWithdrawl(double balance) {

        this.balance -= balance;
        Database.Subtractbalance(accountNum, balance);

    }

    // method to change pin
    public void PinChange(String newPin) {

        Database.ChangePin(accountNum, newPin);
        pinCode = newPin;

    }

    // method to transfer money
    public void amountTransfer(String recipientAccountNum, double amount) {

        balance -= amount;
        Database.Subtractbalance(accountNum, amount);
        Database.AddBalance(recipientAccountNum, amount);

    }

    public void UpdateUser(String accountNum, String fullName, String fatherName, String DOB, String CNIC,
            String gender, String email, String phoneNum) {

        setfullName(fullName);
        setfatherName(fatherName);
        setDOB(DOB);
        setCNIC(CNIC);
        setGender(gender);
        setEmail(email);
        setPhoneNum(phoneNum);

        Database.UpdateUser(accountNum, fullName, fatherName, DOB, CNIC, gender, email,
                phoneNum);

    }

    public String toString() {
        return "Full Name: " + getfullName()
                + "\nFather Nane: " + getfatherName()
                + "\nDate of Birth: " + getDOB()
                + "\nCNIC: " + getCNIC()
                + "\nGender: " + getGender()
                + "\nEmail: " + getEmail()
                + "\nPhone Number: " + getPhoneNum()
                + "\nAccount Number: " + getAccountNum()
                + "\nPin Code: " + getPinCode()
                + "\nInitial Deposit: " + getIniDeposit()
                + "\nBalance: " + getBalance();
    }
}

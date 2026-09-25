import java.io.Serializable;

public class Account implements Serializable {
    private String accountNumber;
    private String customerId;
    private String accountType;
    private double balance;
    private String status;
    private String openedDate;

    public Account(String accountNumber, String customerId, String accountType,
                   double balance, String status, String openedDate) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
        this.openedDate = openedDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public String getOpenedDate() {
        return openedDate;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOpenedDate(String openedDate) {
        this.openedDate = openedDate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public String toFileString() {
        return accountNumber + "|" + customerId + "|" + accountType + "|" +
               balance + "|" + status + "|" + openedDate;
    }

    public static Account fromFileString(String line) {
        String[] p = line.split("\\|", -1);
        if (p.length != 6) {
            return null;
        }

        try {
            double balance = Double.parseDouble(p[3]);
            return new Account(p[0], p[1], p[2], balance, p[4], p[5]);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public void display() {
        System.out.println("---------------------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer ID    : " + customerId);
        System.out.println("Account Type   : " + accountType);
        System.out.printf("Balance        : Rs. %.2f%n", balance);
        System.out.println("Status         : " + status);
        System.out.println("Opened Date    : " + openedDate);
        System.out.println("---------------------------------------------");
    }
}

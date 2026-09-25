import java.io.Serializable;

public class Transaction implements Serializable {
    private String transactionId;
    private String accountNumber;
    private String type;
    private double amount;
    private double balanceAfter;
    private String dateTime;
    private String relatedAccount;
    private String description;

    public Transaction(String transactionId, String accountNumber, String type,
                       double amount, double balanceAfter, String dateTime,
                       String relatedAccount, String description) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.dateTime = dateTime;
        this.relatedAccount = relatedAccount;
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getRelatedAccount() {
        return relatedAccount;
    }

    public String getDescription() {
        return description;
    }

    public String toFileString() {
        return clean(transactionId) + "|" + clean(accountNumber) + "|" +
               clean(type) + "|" + amount + "|" + balanceAfter + "|" +
               clean(dateTime) + "|" + clean(relatedAccount) + "|" +
               clean(description);
    }

    public static Transaction fromFileString(String line) {
        String[] p = line.split("\\|", -1);
        if (p.length != 8) {
            return null;
        }

        try {
            return new Transaction(
                p[0], p[1], p[2],
                Double.parseDouble(p[3]),
                Double.parseDouble(p[4]),
                p[5], p[6], p[7]
            );
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private String clean(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("|", "/").replace("\n", " ").replace("\r", " ");
    }

    public void display() {
        System.out.printf(
            "%-12s %-14s %-12s %10.2f %10.2f %-20s %-14s%n",
            transactionId,
            accountNumber,
            type,
            amount,
            balanceAfter,
            dateTime,
            relatedAccount
        );
    }
}

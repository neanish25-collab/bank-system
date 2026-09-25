import java.io.*;
import java.util.*;

public class FileManager {
    private final String customerFile = "customers.txt";
    private final String accountFile = "accounts.txt";
    private final String transactionFile = "transactions.txt";

    public FileManager() {
        createFileIfMissing(customerFile);
        createFileIfMissing(accountFile);
        createFileIfMissing(transactionFile);
    }

    private void createFileIfMissing(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Unable to create " + fileName);
            }
        }
    }

    public List<Customer> loadCustomers() {
        List<Customer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Customer c = Customer.fromFileString(line);
                    if (c != null) {
                        list.add(c);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading customer data: " + ex.getMessage());
        }
        return list;
    }

    public List<Account> loadAccounts() {
        List<Account> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(accountFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Account a = Account.fromFileString(line);
                    if (a != null) {
                        list.add(a);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading account data: " + ex.getMessage());
        }
        return list;
    }

    public List<Transaction> loadTransactions() {
        List<Transaction> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(transactionFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Transaction t = Transaction.fromFileString(line);
                    if (t != null) {
                        list.add(t);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading transaction data: " + ex.getMessage());
        }
        return list;
    }

    public boolean saveCustomers(List<Customer> customers) {
        try (PrintWriter out = new PrintWriter(new FileWriter(customerFile))) {
            for (Customer customer : customers) {
                out.println(customer.toFileString());
            }
            return true;
        } catch (IOException ex) {
            System.out.println("Error saving customers: " + ex.getMessage());
            return false;
        }
    }

    public boolean saveAccounts(List<Account> accounts) {
        try (PrintWriter out = new PrintWriter(new FileWriter(accountFile))) {
            for (Account account : accounts) {
                out.println(account.toFileString());
            }
            return true;
        } catch (IOException ex) {
            System.out.println("Error saving accounts: " + ex.getMessage());
            return false;
        }
    }

    public boolean saveTransactions(List<Transaction> transactions) {
        try (PrintWriter out = new PrintWriter(new FileWriter(transactionFile))) {
            for (Transaction transaction : transactions) {
                out.println(transaction.toFileString());
            }
            return true;
        } catch (IOException ex) {
            System.out.println("Error saving transactions: " + ex.getMessage());
            return false;
        }
    }

    public void backupAllData() {
        backupFile(customerFile);
        backupFile(accountFile);
        backupFile(transactionFile);
    }

    private void backupFile(String original) {
        String backup = original.replace(".txt", "_backup.txt");

        try (
            BufferedReader br = new BufferedReader(new FileReader(original));
            PrintWriter out = new PrintWriter(new FileWriter(backup))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Backup failed for " + original);
        }
    }
}

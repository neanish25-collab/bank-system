import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankSystem {
    private final Scanner scanner;
    private final FileManager fileManager;
    private final List<Customer> customers;
    private final List<Account> accounts;
    private final List<Transaction> transactions;

    private final DateTimeFormatter dateFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final DateTimeFormatter dateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public BankSystem() {
        scanner = new Scanner(System.in);
        fileManager = new FileManager();
        customers = fileManager.loadCustomers();
        accounts = fileManager.loadAccounts();
        transactions = fileManager.loadTransactions();
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    accountMenu();
                    break;
                case 3:
                    transactionMenu();
                    break;
                case 4:
                    searchMenu();
                    break;
                case 5:
                    reportMenu();
                    break;
                case 6:
                    fileManager.backupAllData();
                    System.out.println("Backup files created successfully.");
                    break;
                case 0:
                    saveAll();
                    running = false;
                    System.out.println("Thank you for using the Bank Account Management System.");
                    break;
                default:
                    System.out.println("Invalid menu choice.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("====================================================");
        System.out.println("          BANK ACCOUNT MANAGEMENT SYSTEM");
        System.out.println("====================================================");
        System.out.println("1. Customer Management");
        System.out.println("2. Account Management");
        System.out.println("3. Banking Transactions");
        System.out.println("4. Search");
        System.out.println("5. Reports and Summaries");
        System.out.println("6. Backup Data");
        System.out.println("0. Exit");
        System.out.println("====================================================");
    }

    private void customerMenu() {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("------------- CUSTOMER MANAGEMENT -------------");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Sort Customers by Name");
            System.out.println("0. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    displayAllCustomers();
                    break;
                case 3:
                    searchCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    deleteCustomer();
                    break;
                case 6:
                    sortCustomersByName();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void accountMenu() {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("-------------- ACCOUNT MANAGEMENT --------------");
            System.out.println("1. Open Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Update Account");
            System.out.println("5. Close Account");
            System.out.println("6. View Customer Accounts");
            System.out.println("7. Sort Accounts by Balance");
            System.out.println("0. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    openAccount();
                    break;
                case 2:
                    displayAllAccounts();
                    break;
                case 3:
                    searchAccount();
                    break;
                case 4:
                    updateAccount();
                    break;
                case 5:
                    closeAccount();
                    break;
                case 6:
                    viewCustomerAccounts();
                    break;
                case 7:
                    sortAccountsByBalance();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void transactionMenu() {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("------------- BANKING TRANSACTIONS -------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Balance Inquiry");
            System.out.println("5. Transaction History");
            System.out.println("6. Account Statement");
            System.out.println("0. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    balanceInquiry();
                    break;
                case 5:
                    transactionHistory();
                    break;
                case 6:
                    accountStatement();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void searchMenu() {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("---------------- SEARCH ----------------");
            System.out.println("1. Search Customer by ID");
            System.out.println("2. Search Customer by Name");
            System.out.println("3. Search Account by Number");
            System.out.println("4. Search Accounts by Type");
            System.out.println("5. Search Transactions by Type");
            System.out.println("0. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    searchCustomerById();
                    break;
                case 2:
                    searchCustomerByName();
                    break;
                case 3:
                    searchAccountByNumber();
                    break;
                case 4:
                    searchAccountsByType();
                    break;
                case 5:
                    searchTransactionsByType();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void reportMenu() {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("------------- REPORTS AND SUMMARIES -------------");
            System.out.println("1. Bank Summary");
            System.out.println("2. Account Type Summary");
            System.out.println("3. Transaction Summary");
            System.out.println("4. Customer Account Report");
            System.out.println("5. Total Bank Deposits");
            System.out.println("6. Recent Transactions");
            System.out.println("0. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    bankSummary();
                    break;
                case 2:
                    accountTypeSummary();
                    break;
                case 3:
                    transactionSummary();
                    break;
                case 4:
                    customerAccountReport();
                    break;
                case 5:
                    totalBankDeposits();
                    break;
                case 6:
                    recentTransactions();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addCustomer() {
        System.out.println();
        System.out.println("ADD NEW CUSTOMER");

        String id = readNonEmpty("Customer ID: ");

        if (findCustomer(id) != null) {
            System.out.println("Customer ID already exists.");
            return;
        }

        String name = readNonEmpty("Full name: ");
        String address = readNonEmpty("Address: ");
        String phone = readPhone("Phone: ");
        String email = readEmail("Email: ");

        Customer customer = new Customer(id, name, address, phone, email);
        customers.add(customer);

        saveAll();
        System.out.println("Customer added successfully.");
    }

    private void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customer records found.");
            return;
        }

        System.out.println();
        System.out.println("ALL CUSTOMERS");

        for (Customer customer : customers) {
            customer.display();
        }

        System.out.println("Total customers: " + customers.size());
    }

    private void searchCustomer() {
        String id = readNonEmpty("Enter customer ID: ");
        Customer customer = findCustomer(id);

        if (customer == null) {
            System.out.println("Customer not found.");
        } else {
            customer.display();
        }
    }

    private void updateCustomer() {
        String id = readNonEmpty("Enter customer ID to update: ");
        Customer customer = findCustomer(id);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        customer.display();

        String name = readOptional("New name (press Enter to keep current): ");
        String address = readOptional("New address (press Enter to keep current): ");
        String phone = readOptional("New phone (press Enter to keep current): ");
        String email = readOptional("New email (press Enter to keep current): ");

        if (!name.isEmpty()) {
            customer.setName(name);
        }

        if (!address.isEmpty()) {
            customer.setAddress(address);
        }

        if (!phone.isEmpty()) {
            if (!isValidPhone(phone)) {
                System.out.println("Invalid phone number. Update cancelled.");
                return;
            }
            customer.setPhone(phone);
        }

        if (!email.isEmpty()) {
            if (!isValidEmail(email)) {
                System.out.println("Invalid email. Update cancelled.");
                return;
            }
            customer.setEmail(email);
        }

        saveAll();
        System.out.println("Customer updated successfully.");
    }

    private void deleteCustomer() {
        String id = readNonEmpty("Enter customer ID to delete: ");
        Customer customer = findCustomer(id);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        if (hasAccounts(id)) {
            System.out.println("Cannot delete customer while accounts exist.");
            return;
        }

        customer.display();

        if (confirm("Delete this customer?")) {
            customers.remove(customer);
            saveAll();
            System.out.println("Customer deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    private void sortCustomersByName() {
        if (customers.isEmpty()) {
            System.out.println("No customers to sort.");
            return;
        }

        customers.sort(Comparator.comparing(
            Customer::getName,
            String.CASE_INSENSITIVE_ORDER
        ));

        System.out.println("Customers sorted by name.");
        displayAllCustomers();
    }

    private void openAccount() {
        System.out.println();
        System.out.println("OPEN NEW ACCOUNT");

        String customerId = readNonEmpty("Customer ID: ");
        Customer customer = findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer does not exist.");
            return;
        }

        String accountNumber = readNonEmpty("Account number: ");

        if (findAccount(accountNumber) != null) {
            System.out.println("Account number already exists.");
            return;
        }

        String accountType = readAccountType();
        double openingBalance = readNonNegativeDouble("Opening balance: ");

        String date = LocalDate.now().format(dateFormatter);

        Account account = new Account(
            accountNumber,
            customerId,
            accountType,
            openingBalance,
            "ACTIVE",
            date
        );

        accounts.add(account);

        if (openingBalance > 0) {
            addTransaction(
                accountNumber,
                "OPENING",
                openingBalance,
                account.getBalance(),
                "",
                "Initial account balance"
            );
        }

        saveAll();

        System.out.println("Account opened successfully.");
        account.display();
    }

    private void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No account records found.");
            return;
        }

        System.out.println();
        System.out.println("ALL ACCOUNTS");

        for (Account account : accounts) {
            account.display();
        }

        System.out.println("Total accounts: " + accounts.size());
    }

    private void searchAccount() {
        String number = readNonEmpty("Enter account number: ");
        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            account.display();
            showAccountOwner(account);
        }
    }

    private void updateAccount() {
        String number = readNonEmpty("Enter account number to update: ");
        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (!account.getStatus().equals("ACTIVE")) {
            System.out.println("Only active accounts can be updated.");
            return;
        }

        account.display();

        System.out.println("1. Change account type");
        System.out.println("2. Change opened date");
        System.out.println("0. Cancel");

        int choice = readInt("Choose field: ");

        if (choice == 1) {
            account.setAccountType(readAccountType());
        } else if (choice == 2) {
            String date = readNonEmpty("Enter date (YYYY-MM-DD): ");

            if (!isValidDate(date)) {
                System.out.println("Invalid date.");
                return;
            }

            account.setOpenedDate(date);
        } else {
            System.out.println("Update cancelled.");
            return;
        }

        saveAll();
        System.out.println("Account updated successfully.");
    }

    private void closeAccount() {
        String number = readNonEmpty("Enter account number to close: ");
        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (!account.getStatus().equals("ACTIVE")) {
            System.out.println("Account is already closed.");
            return;
        }

        if (Math.abs(account.getBalance()) > 0.001) {
            System.out.println("Account must have zero balance before closing.");
            System.out.printf("Current balance: Rs. %.2f%n", account.getBalance());
            return;
        }

        if (confirm("Close account " + number + "?")) {
            account.setStatus("CLOSED");

            addTransaction(
                number,
                "CLOSE",
                0,
                account.getBalance(),
                "",
                "Account closed"
            );

            saveAll();
            System.out.println("Account closed successfully.");
        }
    }

    private void viewCustomerAccounts() {
        String customerId = readNonEmpty("Enter customer ID: ");
        Customer customer = findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Accounts belonging to " + customer.getName());

        int count = 0;
        for (Account account : accounts) {
            if (account.getCustomerId().equalsIgnoreCase(customerId)) {
                account.display();
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No accounts found for this customer.");
        }
    }

    private void sortAccountsByBalance() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to sort.");
            return;
        }

        accounts.sort(Comparator.comparingDouble(Account::getBalance).reversed());

        System.out.println("Accounts sorted by balance, highest first.");
        displayAllAccounts();
    }

    private void deposit() {
        String number = readNonEmpty("Account number: ");
        Account account = findAccount(number);

        if (!isUsableAccount(account)) {
            return;
        }

        double amount = readPositiveDouble("Deposit amount: ");

        account.deposit(amount);

        addTransaction(
            number,
            "DEPOSIT",
            amount,
            account.getBalance(),
            "",
            "Cash deposit"
        );

        saveAll();

        System.out.printf("Deposit successful. New balance: Rs. %.2f%n",
                          account.getBalance());
    }

    private void withdraw() {
        String number = readNonEmpty("Account number: ");
        Account account = findAccount(number);

        if (!isUsableAccount(account)) {
            return;
        }

        double amount = readPositiveDouble("Withdrawal amount: ");

        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance.");
            return;
        }

        if (!account.withdraw(amount)) {
            System.out.println("Withdrawal failed.");
            return;
        }

        addTransaction(
            number,
            "WITHDRAW",
            amount,
            account.getBalance(),
            "",
            "Cash withdrawal"
        );

        saveAll();

        System.out.printf("Withdrawal successful. New balance: Rs. %.2f%n",
                          account.getBalance());
    }

    private void transfer() {
        String sourceNumber = readNonEmpty("Source account number: ");
        Account source = findAccount(sourceNumber);

        if (!isUsableAccount(source)) {
            return;
        }

        String destinationNumber =
            readNonEmpty("Destination account number: ");

        if (sourceNumber.equalsIgnoreCase(destinationNumber)) {
            System.out.println("Source and destination accounts must be different.");
            return;
        }

        Account destination = findAccount(destinationNumber);

        if (!isUsableAccount(destination)) {
            return;
        }

        double amount = readPositiveDouble("Transfer amount: ");

        if (amount > source.getBalance()) {
            System.out.println("Insufficient source account balance.");
            return;
        }

        if (!confirm("Confirm transfer of Rs. " + amount + "?")) {
            System.out.println("Transfer cancelled.");
            return;
        }

        source.withdraw(amount);
        destination.deposit(amount);

        addTransaction(
            sourceNumber,
            "TRANSFER_OUT",
            amount,
            source.getBalance(),
            destinationNumber,
            "Transfer to another account"
        );

        addTransaction(
            destinationNumber,
            "TRANSFER_IN",
            amount,
            destination.getBalance(),
            sourceNumber,
            "Transfer from another account"
        );

        saveAll();

        System.out.println("Transfer completed successfully.");
        System.out.printf("Source balance: Rs. %.2f%n", source.getBalance());
        System.out.printf("Destination balance: Rs. %.2f%n",
                          destination.getBalance());
    }

    private void balanceInquiry() {
        String number = readNonEmpty("Account number: ");
        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println();
        System.out.println("BALANCE INQUIRY");
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Status : " + account.getStatus());
        System.out.printf("Balance: Rs. %.2f%n", account.getBalance());

        showAccountOwner(account);
    }

    private void transactionHistory() {
        String number = readNonEmpty("Account number: ");
        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        List<Transaction> history = getTransactionsForAccount(number);

        if (history.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        printTransactionHeader();

        for (Transaction transaction : history) {
            transaction.display();
        }

        System.out.println("Total transactions: " + history.size());
    }

    private void accountStatement() {
        String number = readNonEmpty("Account number: ");
        Account account = findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        Customer customer = findCustomer(account.getCustomerId());
        List<Transaction> history = getTransactionsForAccount(number);

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                    ACCOUNT STATEMENT");
        System.out.println("==============================================================");

        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Customer       : " +
                           (customer == null ? "Unknown" : customer.getName()));
        System.out.println("Account Type   : " + account.getAccountType());
        System.out.println("Opened Date    : " + account.getOpenedDate());
        System.out.println("Status         : " + account.getStatus());

        System.out.println("--------------------------------------------------------------");

        if (history.isEmpty()) {
            System.out.println("No transactions.");
        } else {
            printTransactionHeader();

            for (Transaction transaction : history) {
                transaction.display();
            }
        }

        System.out.println("--------------------------------------------------------------");
        System.out.printf("Current Balance: Rs. %.2f%n", account.getBalance());
        System.out.println("==============================================================");
    }

    private void searchCustomerById() {
        String id = readNonEmpty("Customer ID: ");
        Customer customer = findCustomer(id);

        if (customer == null) {
            System.out.println("No customer found.");
        } else {
            customer.display();
        }
    }

    private void searchCustomerByName() {
        String keyword = readNonEmpty("Enter name keyword: ").toLowerCase();
        int found = 0;

        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(keyword)) {
                customer.display();
                found++;
            }
        }

        System.out.println("Matching customers: " + found);
    }

    private void searchAccountByNumber() {
        String number = readNonEmpty("Account number: ");
        Account account = findAccount(number);

        if (account == null) {
            System.out.println("No account found.");
        } else {
            account.display();
        }
    }

    private void searchAccountsByType() {
        String type = readAccountType();
        int found = 0;

        for (Account account : accounts) {
            if (account.getAccountType().equalsIgnoreCase(type)) {
                account.display();
                found++;
            }
        }

        System.out.println("Matching accounts: " + found);
    }

    private void searchTransactionsByType() {
        String type = readTransactionType();
        int found = 0;

        printTransactionHeader();

        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase(type)) {
                transaction.display();
                found++;
            }
        }

        if (found == 0) {
            System.out.println("No matching transactions.");
        } else {
            System.out.println("Matching transactions: " + found);
        }
    }

    private void bankSummary() {
        int active = 0;
        int closed = 0;
        double totalBalance = 0;

        for (Account account : accounts) {
            if (account.getStatus().equalsIgnoreCase("ACTIVE")) {
                active++;
            } else {
                closed++;
            }

            totalBalance += account.getBalance();
        }

        System.out.println();
        System.out.println("BANK SUMMARY");
        System.out.println("--------------------------------");
        System.out.println("Total customers : " + customers.size());
        System.out.println("Total accounts  : " + accounts.size());
        System.out.println("Active accounts : " + active);
        System.out.println("Closed accounts : " + closed);
        System.out.println("Transactions    : " + transactions.size());
        System.out.printf("Total balance   : Rs. %.2f%n", totalBalance);
        System.out.println("--------------------------------");
    }

    private void accountTypeSummary() {
        int savings = 0;
        int current = 0;
        int fixed = 0;
        double savingsBalance = 0;
        double currentBalance = 0;
        double fixedBalance = 0;

        for (Account account : accounts) {
            String type = account.getAccountType().toUpperCase();

            if (type.equals("SAVINGS")) {
                savings++;
                savingsBalance += account.getBalance();
            } else if (type.equals("CURRENT")) {
                current++;
                currentBalance += account.getBalance();
            } else if (type.equals("FIXED")) {
                fixed++;
                fixedBalance += account.getBalance();
            }
        }

        System.out.println();
        System.out.println("ACCOUNT TYPE SUMMARY");
        System.out.println("---------------------------------------------");
        System.out.printf("Savings : %d accounts, Rs. %.2f%n",
                          savings, savingsBalance);
        System.out.printf("Current : %d accounts, Rs. %.2f%n",
                          current, currentBalance);
        System.out.printf("Fixed   : %d accounts, Rs. %.2f%n",
                          fixed, fixedBalance);
        System.out.println("---------------------------------------------");
    }

    private void transactionSummary() {
        int deposits = 0;
        int withdrawals = 0;
        int transfersIn = 0;
        int transfersOut = 0;

        double depositAmount = 0;
        double withdrawalAmount = 0;
        double transferInAmount = 0;
        double transferOutAmount = 0;

        for (Transaction transaction : transactions) {
            switch (transaction.getType()) {
                case "DEPOSIT":
                    deposits++;
                    depositAmount += transaction.getAmount();
                    break;
                case "WITHDRAW":
                    withdrawals++;
                    withdrawalAmount += transaction.getAmount();
                    break;
                case "TRANSFER_IN":
                    transfersIn++;
                    transferInAmount += transaction.getAmount();
                    break;
                case "TRANSFER_OUT":
                    transfersOut++;
                    transferOutAmount += transaction.getAmount();
                    break;
                default:
                    break;
            }
        }

        System.out.println();
        System.out.println("TRANSACTION SUMMARY");
        System.out.println("---------------------------------------------");
        System.out.printf("Deposits       : %d, Rs. %.2f%n",
                          deposits, depositAmount);
        System.out.printf("Withdrawals    : %d, Rs. %.2f%n",
                          withdrawals, withdrawalAmount);
        System.out.printf("Transfers In   : %d, Rs. %.2f%n",
                          transfersIn, transferInAmount);
        System.out.printf("Transfers Out  : %d, Rs. %.2f%n",
                          transfersOut, transferOutAmount);
        System.out.println("---------------------------------------------");
    }

    private void customerAccountReport() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println();
        System.out.println("CUSTOMER ACCOUNT REPORT");

        for (Customer customer : customers) {
            int count = 0;
            double balance = 0;

            for (Account account : accounts) {
                if (account.getCustomerId().equalsIgnoreCase(
                        customer.getCustomerId())) {
                    count++;
                    balance += account.getBalance();
                }
            }

            System.out.printf(
                "%-12s %-25s Accounts: %-3d Total Balance: Rs. %.2f%n",
                customer.getCustomerId(),
                customer.getName(),
                count,
                balance
            );
        }
    }

    private void totalBankDeposits() {
        double total = 0;

        for (Account account : accounts) {
            if (account.getStatus().equalsIgnoreCase("ACTIVE")) {
                total += account.getBalance();
            }
        }

        System.out.println();
        System.out.printf("Total money currently held in active accounts: Rs. %.2f%n",
                          total);
    }

    private void recentTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        List<Transaction> copy = new ArrayList<>(transactions);

        copy.sort(Comparator.comparing(
            Transaction::getDateTime
        ).reversed());

        int count = Math.min(10, copy.size());

        System.out.println();
        System.out.println("10 MOST RECENT TRANSACTIONS");
        printTransactionHeader();

        for (int i = 0; i < count; i++) {
            copy.get(i).display();
        }
    }

    private Customer findCustomer(String id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equalsIgnoreCase(id)) {
                return customer;
            }
        }
        return null;
    }

    private Account findAccount(String number) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(number)) {
                return account;
            }
        }
        return null;
    }

    private boolean hasAccounts(String customerId) {
        for (Account account : accounts) {
            if (account.getCustomerId().equalsIgnoreCase(customerId)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsableAccount(Account account) {
        if (account == null) {
            System.out.println("Account not found.");
            return false;
        }

        if (!account.getStatus().equalsIgnoreCase("ACTIVE")) {
            System.out.println("Account is not active.");
            return false;
        }

        return true;
    }

    private void showAccountOwner(Account account) {
        Customer customer = findCustomer(account.getCustomerId());

        if (customer != null) {
            System.out.println("Customer name: " + customer.getName());
        }
    }

    private List<Transaction> getTransactionsForAccount(String number) {
        List<Transaction> result = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber().equalsIgnoreCase(number)) {
                result.add(transaction);
            }
        }

        return result;
    }

    private void addTransaction(String accountNumber,
                                String type,
                                double amount,
                                double balanceAfter,
                                String relatedAccount,
                                String description) {
        String id = generateTransactionId();

        String dateTime =
            LocalDateTime.now().format(dateTimeFormatter);

        Transaction transaction = new Transaction(
            id,
            accountNumber,
            type,
            amount,
            balanceAfter,
            dateTime,
            relatedAccount,
            description
        );

        transactions.add(transaction);
    }

    private String generateTransactionId() {
        int max = 0;

        for (Transaction transaction : transactions) {
            String id = transaction.getTransactionId();

            if (id.startsWith("TX")) {
                try {
                    int number = Integer.parseInt(id.substring(2));
                    if (number > max) {
                        max = number;
                    }
                } catch (NumberFormatException ignored) {
                }
            }
        }

        return String.format("TX%06d", max + 1);
    }

    private void printTransactionHeader() {
        System.out.printf(
            "%-12s %-14s %-12s %10s %10s %-20s %-14s%n",
            "ID",
            "ACCOUNT",
            "TYPE",
            "AMOUNT",
            "BALANCE",
            "DATE/TIME",
            "RELATED"
        );

        System.out.println(
            "--------------------------------------------------------------------------------"
        );
    }

    private String readAccountType() {
        while (true) {
            System.out.println("1. SAVINGS");
            System.out.println("2. CURRENT");
            System.out.println("3. FIXED");

            int choice = readInt("Select account type: ");

            switch (choice) {
                case 1:
                    return "SAVINGS";
                case 2:
                    return "CURRENT";
                case 3:
                    return "FIXED";
                default:
                    System.out.println("Invalid account type.");
            }
        }
    }

    private String readTransactionType() {
        while (true) {
            System.out.println("1. DEPOSIT");
            System.out.println("2. WITHDRAW");
            System.out.println("3. TRANSFER_IN");
            System.out.println("4. TRANSFER_OUT");
            System.out.println("5. OPENING");
            System.out.println("6. CLOSE");

            int choice = readInt("Select transaction type: ");

            switch (choice) {
                case 1:
                    return "DEPOSIT";
                case 2:
                    return "WITHDRAW";
                case 3:
                    return "TRANSFER_IN";
                case 4:
                    return "TRANSFER_OUT";
                case 5:
                    return "OPENING";
                case 6:
                    return "CLOSE";
                default:
                    System.out.println("Invalid transaction type.");
            }
        }
    }

    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    private String readOptional(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private double readPositiveDouble(String prompt) {
        while (true) {
            double value = readDouble(prompt);

            if (value > 0) {
                return value;
            }

            System.out.println("Amount must be greater than zero.");
        }
    }

    private double readNonNegativeDouble(String prompt) {
        while (true) {
            double value = readDouble(prompt);

            if (value >= 0) {
                return value;
            }

            System.out.println("Amount cannot be negative.");
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readPhone(String prompt) {
        while (true) {
            String phone = readNonEmpty(prompt);

            if (isValidPhone(phone)) {
                return phone;
            }

            System.out.println("Phone must contain 7 to 15 digits.");
        }
    }

    private String readEmail(String prompt) {
        while (true) {
            String email = readNonEmpty(prompt);

            if (isValidEmail(email)) {
                return email;
            }

            System.out.println("Please enter a valid email address.");
        }
    }

    private boolean isValidPhone(String phone) {
        String digits = phone.replaceAll("[\\s+()-]", "");
        return digits.matches("\\d{7,15}");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    private boolean isValidDate(String value) {
        try {
            LocalDate.parse(value, dateFormatter);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean confirm(String prompt) {
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("Y")) {
                return true;
            }

            if (answer.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Please enter Y or N.");
        }
    }

    private void saveAll() {
        boolean customerSaved = fileManager.saveCustomers(customers);
        boolean accountSaved = fileManager.saveAccounts(accounts);
        boolean transactionSaved = fileManager.saveTransactions(transactions);

        if (!customerSaved || !accountSaved || !transactionSaved) {
            System.out.println("Warning: one or more data files could not be saved.");
        }
    }
}

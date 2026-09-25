BANK ACCOUNT MANAGEMENT SYSTEM
==============================

Language:
Java

Project type:
Console-based Object-Oriented Programming project

Features:
1. Customer CRUD
2. Account CRUD
3. Deposit
4. Withdrawal
5. Account-to-account transfer
6. Balance inquiry
7. Transaction history
8. Account statement
9. Customer and account searching
10. Sorting
11. Reports and summaries
12. File handling using text files
13. Data backup
14. Input validation
15. Duplicate ID/account validation
16. Account closing validation
17. Transaction IDs
18. Account type summaries
19. Recent transaction report

Files:
Main.java
BankSystem.java
Customer.java
Account.java
Transaction.java
FileManager.java

Generated data files:
customers.txt
accounts.txt
transactions.txt

Compilation:
javac *.java

Run:
java Main

Important:
Run the program from the project directory so the generated
customers.txt, accounts.txt and transactions.txt files are stored
with the application.

Data format:
The application uses | as a field separator.

Customer:
customerId|name|address|phone|email

Account:
accountNumber|customerId|accountType|balance|status|openedDate

Transaction:
transactionId|accountNumber|type|amount|balanceAfter|dateTime|relatedAccount|description

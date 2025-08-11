# Elevate-Labs-Task-5
Bank Operations Simulator

**Overview**
This Java program simulates basic bank operations using Object-Oriented Programming (OOP) principles. It includes an Account class to manage deposits, withdrawals, and transaction history, with a Transaction class to store details of each transaction.

**Features**
Create a bank account with an account number and initial balance.
Perform deposits and withdrawals with input validation.
Track and display transaction history with timestamps.
Ensure safe operations (e.g., prevent overdrafts or negative deposits).

**Prerequisites**
Java Development Kit (JDK) 8 or higher
Visual Studio Code (VS Code) or any Java-compatible IDE
Terminal or command-line interface

Compile the Program
javac BankAccount.java

Run the Program
java BankAccount


Expected Output

The program will execute sample transactions (deposits and withdrawals) and display:
Confirmation messages for each transaction.
Final account balance.
Complete transaction history with timestamps.





Program Structure

Transaction Class

Stores transaction details: type (e.g., Deposit, Withdrawal), amount, balance after transaction, and timestamp.
Provides a toString method for formatted output.


Account Class

Manages account details: account number, balance, and transaction history.
Methods:
deposit(double amount): Adds funds if the amount is positive.
withdraw(double amount): Deducts funds if sufficient balance exists.
printTransactionHistory(): Displays all transactions.
getBalance(): Returns current balance.
getAccountNumber(): Returns account number.




BankAccount Class

Contains the main method to demonstrate functionality with sample transactions.



**Example Output**
Deposited $500.00. New balance: $1500.00
Withdrew $200.00. New balance: $1300.00
Deposited $1000.00. New balance: $2300.00
Invalid withdrawal. Insufficient funds or invalid amount.
Withdrew $300.00. New balance: $2000.00

Final Balance: $2000.00

Transaction History for Account 123456789:
2025-08-11 22:32:45 | Initial Deposit: $1000.00 | Balance: $1000.00
2025-08-11 22:32:45 | Deposit: $500.00 | Balance: $1500.00
2025-08-11 22:32:45 | Withdrawal: $200.00 | Balance: $1300.00
2025-08-11 22:32:45 | Deposit: $1000.00 | Balance: $2300.00
2025-08-11 22:32:45 | Withdrawal: $300.00 | Balance: $2000.00


**Notes**
The program uses java.time.LocalDateTime for timestamps, ensuring accurate transaction logging.
Input validation prevents invalid operations (e.g., negative deposits or overdrafts).
The transaction history is stored in an ArrayList for dynamic management.



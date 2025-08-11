import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Transaction {
    private String type;
    private double amount;
    private double balanceAfter;
    private String timestamp;

    public Transaction(String type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return String.format("%s | %s: $%.2f | Balance: $%.2f", timestamp, type, amount, balanceAfter);
    }
}

class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        if (initialBalance > 0) {
            transactionHistory.add(new Transaction("Initial Deposit", initialBalance, balance));
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount, balance));
            System.out.printf("Deposited $%.2f. New balance: $%.2f%n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount, balance));
            System.out.printf("Withdrew $%.2f. New balance: $%.2f%n", amount, balance);
            return true;
        } else {
            System.out.println("Invalid withdrawal. Insufficient funds or invalid amount.");
            return false;
        }
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History for Account " + accountNumber + ":");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}

public class BankAccount {
    public static void main(String[] args) {
        // Create a new account with initial balance
        Account account = new Account("123456789", 1000.00);

        // Perform some transactions
        account.deposit(500.00);
        account.withdraw(200.00);
        account.deposit(1000.00);
        account.withdraw(3000.00); // Should fail due to insufficient funds
        account.withdraw(300.00);

        // Print final balance and transaction history
        System.out.printf("\nFinal Balance: $%.2f%n", account.getBalance());
        account.printTransactionHistory();
    }
}
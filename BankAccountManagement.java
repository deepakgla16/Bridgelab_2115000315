// BankAccount.java
class BankAccount {
    // Attributes with appropriate access modifiers
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    // Constructor to initialize the bank account details
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to access balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify balance
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    // Private method to apply interest (Example encapsulation)
    private void applyInterest() {
        if (balance > 1000) {
            balance += balance * 0.05;  // 5% interest for balances over 1000
        }
    }
}

// SavingsAccount.java
class SavingsAccount extends BankAccount {
    // Constructor to initialize the SavingsAccount details
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    // Method to display account details, demonstrating access to protected and public members
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);  // Accessing public member
        System.out.println("Account Holder: " + accountHolder);  // Accessing protected member
        System.out.println("Account Balance: " + getBalance());  // Using public method to access balance
    }
}

// Main.java
public class BankAccountManagement {
    public static void main(String[] args) {
        // Creating an instance of BankAccount
        BankAccount account1 = new BankAccount("1234567890", "Alice Green", 1500.00);
        System.out.println("Initial Account Balance: " + account1.getBalance());

        // Modifying balance using the public method
        account1.setBalance(2000.00);
        System.out.println("Updated Account Balance: " + account1.getBalance());

        // Creating an instance of SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount("9876543210", "Bob Brown", 1200.00);
        savingsAccount.displayAccountDetails();
    }
}

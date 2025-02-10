// Abstract class representing a Bank Account
abstract class BankAccount {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods for deposit and withdrawal
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Abstract method to calculate interest
    public abstract double calculateInterest();

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
}

// Interface for loanable accounts
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount class extending BankAccount
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04; // 4% annual interest

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

// CurrentAccount class extending BankAccount and implementing Loanable
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02; // 2% annual interest
    private static final double LOAN_ELIGIBILITY_THRESHOLD = 5000;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan approved for: $" + amount);
        } else {
            System.out.println("Loan application denied.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return balance >= LOAN_ELIGIBILITY_THRESHOLD;
    }
}

// Main class to demonstrate polymorphism
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SAV123", "Alice", 10000),
            new CurrentAccount("CUR456", "Bob", 4000),
            new CurrentAccount("CUR789", "Charlie", 6000)
        };

        for (BankAccount account : accounts) {
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Interest Earned: $" + account.calculateInterest());
            
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(2000);
            }
            System.out.println("-----------------------------------");
        }
    }
}

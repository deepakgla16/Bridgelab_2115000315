import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>(); // Store account balances
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>(); // Sort by balance
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>(); // Process withdrawals

    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        public WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    // Open a new account
    public void openAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Deposit money
    public void deposit(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        double newBalance = accounts.get(accountNumber) + amount;
        sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
        accounts.put(accountNumber, newBalance);
        sortedAccounts.put(newBalance, accountNumber); // Update new balance
        System.out.println("Deposited $" + amount + " to Account " + accountNumber);
    }

    // Queue a withdrawal request
    public void requestWithdrawal(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request of $" + amount + " from Account " + accountNumber + " queued.");
    }

    // Process all withdrawals
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            if (accounts.get(request.accountNumber) >= request.amount) {
                double newBalance = accounts.get(request.accountNumber) - request.amount;
                sortedAccounts.remove(accounts.get(request.accountNumber)); // Remove old balance
                accounts.put(request.accountNumber, newBalance);
                sortedAccounts.put(newBalance, request.accountNumber); // Update new balance
                System.out.println("Processed withdrawal of $" + request.amount + " from Account " + request.accountNumber);
            } else {
                System.out.println("Insufficient funds for Account " + request.accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getValue() + " -> Balance: $" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Open accounts
        bank.openAccount(101, 5000);
        bank.openAccount(102, 3000);
        bank.openAccount(103, 7000);

        // Deposits
        bank.deposit(101, 2000);
        bank.deposit(102, 1000);

        // Withdrawal requests
        bank.requestWithdrawal(101, 2500);
        bank.requestWithdrawal(102, 5000);
        bank.requestWithdrawal(103, 1000);

        // Process withdrawals
        bank.processWithdrawals();

        // Display accounts sorted by balance
        bank.displaySortedAccounts();
    }
}

class BankAccount {
    // Static variable shared across all accounts
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;

    // Instance variables
    private String accountHolderName;
    private final int accountNumber; // Final to ensure immutability

    // Constructor using 'this' to resolve ambiguity
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++; // Increment total accounts on new account creation
    }

    // Static method to get total accounts
    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

    // Method to display account details (checking instanceof)
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
        } else {
            System.out.println("Invalid account object.");
        }
    }

    public static void main(String[] args) {
        // Creating BankAccount objects
        BankAccount acc1 = new BankAccount("Alice Johnson", 1001);
        BankAccount acc2 = new BankAccount("Bob Smith", 1002);

        // Displaying account details
        acc1.displayAccountDetails();
        acc2.displayAccountDetails();

        // Displaying total accounts
        BankAccount.getTotalAccounts();
    }
}

import java.util.ArrayList;
import java.util.List;

class Bank {
    String name;
        private List<Customer> customers;
    
        public Bank(String name) {
            this.name = name;
            this.customers = new ArrayList<>();
        }
    
        public void openAccount(Customer customer, double initialDeposit) {
            Account newAccount = new Account(customer, this, initialDeposit);
            customer.addAccount(newAccount);
            if (!customers.contains(customer)) {
                customers.add(customer);
            }
            System.out.println("Account opened for " + customer.getName() + " at " + name + " with initial deposit: $" + initialDeposit);
        }
        
        public void displayCustomers() {
            System.out.println("Bank: " + name);
            if (customers.isEmpty()) {
                System.out.println("No customers yet.");
            } 
            else {
                for (Customer customer : customers) {
                    customer.displayAccounts();
                }
            }
        }
    }
    
    
    class Customer {
        private String name;
        private List<Account> accounts;
    
        public Customer(String name) {
            this.name = name;
            this.accounts = new ArrayList<>();
        }
    
        public String getName() {
            return name;
        }
    
        public void addAccount(Account account) {
            accounts.add(account);
        }
    
        public void viewBalance() {
            System.out.println(name + "'s Accounts:");
            for (Account account : accounts) {
                System.out.println("Bank: " + account.getBankName() + " | Balance: $" + account.getBalance());
            }
        }
    
        public void displayAccounts() {
            System.out.println("Customer: " + name);
            for (Account account : accounts) {
                System.out.println("  Account in " + account.getBankName() + " | Balance: $" + account.getBalance());
            }
        }
    }
    
    
    class Account {
        private Customer customer;
        private Bank bank;
        private double balance;
    
        public Account(Customer customer, Bank bank, double initialDeposit) {
            this.customer = customer;
            this.bank = bank;
            this.balance = initialDeposit;
        }
    
        public String getBankName() {
            return bank.name;
    }

    public double getBalance() {
        return balance;
    }
}


public class BankAndAccountHolder {
    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank");

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        bank1.openAccount(customer1, 5000);
        bank1.openAccount(customer1, 3000);
        bank1.openAccount(customer2, 7000);

        System.out.println();
        customer1.viewBalance();
        customer2.viewBalance();

        System.out.println();
        bank1.displayCustomers();
    }
}

import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return String.format("Policy[%s, %s, Expiry: %s, Type: %s, Premium: %.2f]",
                policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
}

public class InsurancePolicySystem {
    private Map<String, Policy> policyMap = new HashMap<>(); // Fast lookup
    private Map<String, Policy> orderedPolicies = new LinkedHashMap<>(); // Insertion order
    private TreeMap<LocalDate, Policy> sortedByExpiry = new TreeMap<>(); // Sorted by expiry date

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        sortedByExpiry.put(policy.expiryDate, policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getExpiringPolicies(int days) {
        LocalDate today = LocalDate.now();
        LocalDate limitDate = today.plusDays(days);
        return new ArrayList<>(sortedByExpiry.subMap(today, limitDate).values());
    }

    public List<Policy> getPoliciesByHolder(String policyholder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholder)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedByExpiry.headMap(today, true).clear(); // Remove expired policies from sorted map
        policyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
        orderedPolicies.values().removeIf(policy -> policy.expiryDate.isBefore(today));
    }

    public void displayAllPolicies() {
        for (Policy policy : orderedPolicies.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        // Adding sample policies
        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(5), "Auto", 300.0));
        system.addPolicy(new Policy("P003", "Alice", LocalDate.now().minusDays(1), "Home", 400.0));
        system.addPolicy(new Policy("P004", "Charlie", LocalDate.now().plusDays(40), "Life", 600.0));

        // Display all policies
        System.out.println("All Policies:");
        system.displayAllPolicies();

        // Retrieve policy by number
        System.out.println("\nRetrieve Policy P002: " + system.getPolicyByNumber("P002"));

        // List policies expiring in next 30 days
        System.out.println("\nPolicies Expiring in Next 30 Days: " + system.getExpiringPolicies(30));

        // List policies by policyholder
        System.out.println("\nPolicies for Alice: " + system.getPoliciesByHolder("Alice"));

        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("\nAfter Removing Expired Policies:");
        system.displayAllPolicies();
    }
}

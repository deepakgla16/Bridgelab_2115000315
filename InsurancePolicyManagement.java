import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy policy = (InsurancePolicy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Unique Policies:");
        for (InsurancePolicy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    public void displayPoliciesExpiringSoon() {
        System.out.println("\nPolicies Expiring Within 30 Days:");
        LocalDate today = LocalDate.now();
        for (InsurancePolicy policy : treeSetPolicies) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                System.out.println(policy);
            }
        }
    }

    public void displayPoliciesByCoverageType(String type) {
        System.out.println("\nPolicies with Coverage Type: " + type);
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        System.out.println("\nDuplicate Policies:");
        Map<String, Integer> policyCount = new HashMap<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate Policy Number: " + entry.getKey());
            }
        }
    }

    public void comparePerformance() {
        int testSize = 100000;
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>();

        List<InsurancePolicy> testPolicies = new ArrayList<>();
        for (int i = 0; i < testSize; i++) {
            testPolicies.add(new InsurancePolicy("P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Auto", 1000 + i));
        }

        System.out.println("\nPerformance Comparison:");

        // HashSet Performance
        long start = System.nanoTime();
        hashSet.addAll(testPolicies);
        long end = System.nanoTime();
        System.out.println("HashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        // LinkedHashSet Performance
        start = System.nanoTime();
        linkedHashSet.addAll(testPolicies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.contains(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        // TreeSet Performance
        start = System.nanoTime();
        treeSet.addAll(testPolicies);
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(testPolicies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        // Sample Policies
        manager.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 1200.50));
        manager.addPolicy(new InsurancePolicy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 900.75));
        manager.addPolicy(new InsurancePolicy("P103", "Charlie", LocalDate.now().plusDays(5), "Home", 1500.25));
        manager.addPolicy(new InsurancePolicy("P104", "David", LocalDate.now().plusDays(25), "Health", 1000.00));
        manager.addPolicy(new InsurancePolicy("P105", "Eve", LocalDate.now().plusDays(60), "Auto", 800.00));
        manager.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 1200.50)); // Duplicate

        // Display all unique policies
        manager.displayAllPolicies();

        // Display policies expiring within 30 days
        manager.displayPoliciesExpiringSoon();

        // Display policies by coverage type
        manager.displayPoliciesByCoverageType("Health");

        // Find duplicate policies
        manager.findDuplicatePolicies();

        // Compare performance of different sets
        manager.comparePerformance();
    }
}

import java.util.*;

class Patient {
    private String name;
    private int severity;
    private int arrivalTime; // Ensures FIFO order for same severity

    public Patient(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    public int getSeverity() {
        return severity;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        if (p1.getSeverity() != p2.getSeverity()) {
            return Integer.compare(p2.getSeverity(), p1.getSeverity()); // Higher severity first
        }
        return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime()); // Earlier arrivals first
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new PatientComparator());

        // Simulating patient arrivals
        triageQueue.offer(new Patient("John", 3, 1));
        triageQueue.offer(new Patient("Alice", 5, 2));
        triageQueue.offer(new Patient("Bob", 2, 3));
        triageQueue.offer(new Patient("Eve", 5, 4)); // Same severity as Alice, but arrives later

        System.out.println("Order of treatment:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}

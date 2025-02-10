// Abstract class representing a Patient
abstract class Patient {
    protected String patientId;
    protected String name;
    protected int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method to calculate bill
    public abstract double calculateBill();

    // Concrete method to get patient details
    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

// Interface for medical records
interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

// InPatient class extending Patient and implementing MedicalRecord
class InPatient extends Patient implements MedicalRecord {
    private static final double DAILY_RATE = 500.0;
    private int daysAdmitted;
    private StringBuilder medicalHistory = new StringBuilder();

    public InPatient(String patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * DAILY_RATE;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.append(record).append("\n");
    }

    @Override
    public String viewRecords() {
        return medicalHistory.toString();
    }
}

// OutPatient class extending Patient and implementing MedicalRecord
class OutPatient extends Patient implements MedicalRecord {
    private static final double CONSULTATION_FEE = 100.0;
    private StringBuilder medicalHistory = new StringBuilder();

    public OutPatient(String patientId, String name, int age) {
        super(patientId, name, age);
    }

    @Override
    public double calculateBill() {
        return CONSULTATION_FEE;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.append(record).append("\n");
    }

    @Override
    public String viewRecords() {
        return medicalHistory.toString();
    }
}

// Main class to demonstrate polymorphism
public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient[] patients = {
            new InPatient("P001", "Alice", 30, 5),
            new OutPatient("P002", "Bob", 45)
        };

        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Total Bill: $" + patient.calculateBill());
            
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).addRecord("Initial diagnosis recorded.");
                System.out.println("Medical Records:\n" + ((MedicalRecord) patient).viewRecords());
            }
            System.out.println("-----------------------------------");
        }
    }
}

class Patient {
    // Static variable shared across all patients
    private static String hospitalName = "City General Hospital";
    private static int totalPatients = 0;

    // Instance variables
    private String name;
    private int age;
    private String ailment;
    private final int patientID; // Final to ensure immutability

    // Constructor using 'this' to resolve ambiguity
    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++; // Increment total patients on new patient creation
    }

    // Static method to display the total number of patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to display patient details (checking instanceof)
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Ailment: " + this.ailment);
            System.out.println("Patient ID: " + this.patientID);
        } else {
            System.out.println("Invalid patient object.");
        }
    }

    public static void main(String[] args) {
        // Display hospital name
        System.out.println("Welcome to " + hospitalName);

        // Creating Patient objects
        Patient patient1 = new Patient("Alice Johnson", 45, "Flu", 1001);
        Patient patient2 = new Patient("Bob Smith", 60, "Diabetes", 1002);

        // Displaying patient details
        patient1.displayPatientDetails();
        patient2.displayPatientDetails();

        // Displaying total patients
        Patient.getTotalPatients();
    }
}

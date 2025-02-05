class Employee {
    // Static variable shared across all employees
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;

    // Instance variables
    private String name;
    private final int id; // Final to ensure immutability
    private String designation;

    // Constructor using 'this' to resolve ambiguity
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++; // Increment employee count on new employee creation
    }

    // Static method to display the total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details (checking instanceof)
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Employee Name: " + this.name);
            System.out.println("Employee ID: " + this.id);
            System.out.println("Designation: " + this.designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }

    public static void main(String[] args) {
        // Display the company name
        System.out.println("Welcome to " + companyName);

        // Creating Employee objects
        Employee emp1 = new Employee("Alice Johnson", 101, "Software Engineer");
        Employee emp2 = new Employee("Bob Smith", 102, "Project Manager");

        // Displaying employee details
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();

        // Displaying total employees
        Employee.displayTotalEmployees();
    }
}

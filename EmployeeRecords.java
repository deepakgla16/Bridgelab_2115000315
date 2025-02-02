// Employee.java
class Employee {
    // Attributes with appropriate access modifiers
    public String employeeID;
    protected String department;
    private double salary;

    // Constructor to initialize the employee details
    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to access salary
    public double getSalary() {
        return salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }
}

// Manager.java
class Manager extends Employee {
    // Constructor to initialize the Manager details
    public Manager(String employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    // Method to display employee and manager details, demonstrating access to employeeID and department
    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);   // Accessing public member employeeID
        System.out.println("Department: " + department);    // Accessing protected member department
        System.out.println("Salary: " + getSalary());       // Using public method to access salary
    }
}

// Main.java
public class EmployeeRecords {
    public static void main(String[] args) {
        // Creating an instance of Employee
        Employee employee1 = new Employee("E12345", "HR", 50000.00);
        System.out.println("Initial Salary: " + employee1.getSalary());

        // Modifying salary using the public method
        employee1.setSalary(55000.00);
        System.out.println("Updated Salary: " + employee1.getSalary());

        // Creating an instance of Manager
        Manager manager1 = new Manager("M98765", "Sales", 75000.00);
        manager1.displayManagerDetails();
    }
}

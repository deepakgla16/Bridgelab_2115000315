// Employee class to store and display employee details
class Employee {
    private String name;
    private int id;
    private double salary;

    // Constructor to initialize Employee attributes
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }


    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}
    // Main method to test the Employee class
    public class main{
        public static void main(String[] args) {
            // Creating an Employee object
            Employee emp1 = new Employee("John Doe", 101, 50000);

            // Displaying employee details
            emp1.displayDetails();
        }
    }
//     public static void main(String[] args) {
//         // Creating an Employee object
//         Employee emp1 = new Employee("John Doe", 101, 50000);

//         // Displaying employee details
//         emp1.displayDetails();
//     }
// }

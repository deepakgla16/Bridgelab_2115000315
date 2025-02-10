// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public abstract double calculateSalary();
    
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Salary: " + calculateSalary());
    }
}

// Interface Department
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double bonus;
    
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }
    
    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
    
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int workHours;
    private double hourlyRate;
    
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (workHours * hourlyRate);
    }
    
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Main class to test the implementation
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(101, "Alice", 50000, 10000);
        Employee emp2 = new PartTimeEmployee(102, "Bob", 20000, 40, 500);
        
        ((Department) emp1).assignDepartment("HR");
        ((Department) emp2).assignDepartment("IT");
        
        emp1.displayDetails();
        System.out.println(((Department) emp1).getDepartmentDetails());
        System.out.println();
        
        emp2.displayDetails();
        System.out.println(((Department) emp2).getDepartmentDetails());
    }
}

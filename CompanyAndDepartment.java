import java.util.ArrayList;
import java.util.List;


class Employee {
    private String name;
    private String position;

    
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    
    public void displayEmployee() {
        System.out.println("   Employee: " + name + " | Position: " + position);
    }
}


class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String position) {
        employees.add(new Employee(name, position));
    }

    public void displayDepartment() {
        System.out.println(" Department: " + name);
        if (employees.isEmpty()) {
            System.out.println("   No employees in this department.");
        } else {
            for (Employee emp : employees) {
                emp.displayEmployee();
            }
        }
    }
}


class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public Department getDepartment(String deptName) {
        for (Department dept : departments) {
            if (deptName.equals(deptName)) {
                return dept;
            }
        }
        return null;
    }

    
    public void displayCompany() {
        System.out.println("Company: " + name);
        if (departments.isEmpty()) {
            System.out.println("No departments available.");
        } else {
            for (Department dept : departments) {
                dept.displayDepartment();
            }
        }
    }

    public void deleteCompany() {
        System.out.println("Deleting company: " + name);
        departments.clear(); 
    }
}


public class CompanyAndDepartment {
    public static void main(String[] args) {       
        Company company = new Company("TechCorp");

        company.addDepartment("IT");
        company.addDepartment("HR");

        Department itDept = company.getDepartment("IT");
        if (itDept != null) {
            itDept.addEmployee("Alice", "Software Engineer");
            itDept.addEmployee("Bob", "System Administrator");
        }

        Department hrDept = company.getDepartment("HR");
        if (hrDept != null) {
            hrDept.addEmployee("Charlie", "HR Manager");
        }

        company.displayCompany();

        System.out.println("\nDeleting company...\n");
        company.deleteCompany();

        company.displayCompany();
    }
}

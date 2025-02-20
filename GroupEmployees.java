import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name; // Print only the name for readability
    }
}

public class GroupEmployees {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee emp : employees) {
            // Add employee to their department list
            departmentMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        // Sample employee list
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR"),
            new Employee("David", "Finance"),
            new Employee("Eve", "IT")
        );

        // Group by department
        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);

        // Print output
        groupedEmployees.forEach((dept, empList) -> 
            System.out.println(dept + ": " + empList));
    }
}

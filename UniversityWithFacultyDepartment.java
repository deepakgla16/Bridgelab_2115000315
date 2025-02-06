import java.util.ArrayList;
import java.util.List;


class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class University {
    private String name;
    private List<Department> departments;  
    private List<Faculty> faculties;  

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    
    public void showDepartments() {
        System.out.println("University: " + name);
        if (departments.isEmpty()) {
            System.out.println("  No departments available.");
        } else {
            for (Department dept : departments) {
                System.out.println("  Department: " + dept.getName());
            }
        }
    }

    
    public void showFaculties() {
        System.out.println("Faculty Members of " + name);
        if (faculties.isEmpty()) {
            System.out.println("  No faculty members.");
        } else {
            for (Faculty faculty : faculties) {
                System.out.println("  Faculty: " + faculty.getName());
            }
        }
    }

    
    public void deleteUniversity() {
        System.out.println("Deleting University: " + name);
        departments.clear(); 
        faculties.clear(); 
    }
}


public class UniversityWithFacultyDepartment {
    public static void main(String[] args) {
        
        University uni = new University("Oxford University");

        
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical Engineering");

        
        Faculty profAlice = new Faculty("Dr. Alice");
        Faculty profBob = new Faculty("Dr. Bob");

        
        uni.addFaculty(profAlice);
        uni.addFaculty(profBob);

        
        uni.showDepartments();
        System.out.println();
        uni.showFaculties();

        
        System.out.println("\nDeleting University...");
        uni.deleteUniversity();

        
        System.out.println();
        profAlice = new Faculty("Dr. Alice");  
        System.out.println("Independent Faculty: " + profAlice.getName());
    }
}

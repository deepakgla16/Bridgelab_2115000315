import java.util.ArrayList;
import java.util.List;

abstract class CourseType{
	private String courseName;

	public CourseType(String courseName){
		this.courseName = courseName;
	}

	public String getCourseName(){
		return courseName;
	}

	public abstract void evaluate();
}

class ExamCourse extends CourseType{
	public ExamCourse(String courseName){
		super(courseName);
	}

	@Override
	public void evaluate(){
		System.out.println(getCourseName() + " is evaluated through exams.");
	}
}

class AssignmentCourse extends CourseType{
	public AssignmentCourse(String courseName){
		super(courseName);
	}

	@Override
	public void evaluate(){
		System.out.println(getCourseName() + " is evaluated through assignments.");
	}
}

class ResearchCourse extends CourseType{
	public ResearchCourse(String courseName){
		super(courseName);
	}

	@Override
	public void evaluate(){
		System.out.println(getCourseName() + " is evaluated through research work.");
	}
}

class Course<T extends CourseType>{
	private T courseType;

	public Course(T courseType){
		this.courseType = courseType;
	}

	public T getCourseType(){
		return courseType;
	}

	public void displayCourseDetails(){
		System.out.println("Course: " + courseType.getCourseName());
		courseType.evaluate();
	}
}

class University{
	private List<Course<? extends CourseType>> courses = new ArrayList<>();

	public void addCourse(Course<? extends CourseType> course){
		courses.add(course);
	}

	public void displayAllCourses(){
		for(Course<? extends CourseType> course : courses){
			course.displayCourseDetails();
		}
	}
}

public class UniversityCourseManagementSystem{
	public static void main(String[] args){
		University university = new University();

		Course<ExamCourse> mathCourse = new Course<>(new ExamCourse("Maths"));
		Course<AssignmentCourse> programmingCourse = new Course<>(new AssignmentCourse("Java"));
		Course<ResearchCourse> aiCourse = new Course<>(new ResearchCourse("AI"));

		university.addCourse(mathCourse);
		university.addCourse(programmingCourse);
		university.addCourse(aiCourse);

		university.displayAllCourses();
	}
}

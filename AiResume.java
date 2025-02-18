import java.util.ArrayList;
import java.util.List;

abstract class JobRole{
	private String candidateName;

	public JobRole(String candidateName){
		this.candidateName = candidateName;
	}

	public String getCandidateName(){
		return candidateName;
	}

	public abstract void evaluateResume();
}

class SoftwareEngineer extends JobRole{
	public SoftwareEngineer(String candidateName){
		super(candidateName);
	}

	@Override
	public void evaluateResume(){
		System.out.println(getCandidateName() + " is applying for Software Engineer role.");
	}
}

class DataScientist extends JobRole{
	public DataScientist(String candidateName){
		super(candidateName);
	}

	@Override
	public void evaluateResume(){
		System.out.println(getCandidateName() + " is applying for Data Scientist role.");
	}
}

class ProductManager extends JobRole{
	public ProductManager(String candidateName){
		super(candidateName);
	}

	@Override
	public void evaluateResume(){
		System.out.println(getCandidateName() + " is applying for Product Manager role.");
	}
}

class Resume<T extends JobRole>{
	private T jobRole;

	public Resume(T jobRole){
		this.jobRole = jobRole;
	}

	public T getJobRole(){
		return jobRole;
	}

	public void processResume(){
		jobRole.evaluateResume();
	}
}

class ResumeScreeningSystem{
	private List<Resume<? extends JobRole>> resumePipeline = new ArrayList<>();

	public void addResume(Resume<? extends JobRole> resume){
		resumePipeline.add(resume);
	}

	public void processAllResumes(){
		for(Resume<? extends JobRole> resume : resumePipeline){
			resume.processResume();
		}
	}
}

public class AiResume{
	public static void main(String[] args){
		ResumeScreeningSystem system = new ResumeScreeningSystem();

		Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice"));
		Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob"));
		Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie"));

		system.addResume(seResume);
		system.addResume(dsResume);
		system.addResume(pmResume);

		system.processAllResumes();
	}
}

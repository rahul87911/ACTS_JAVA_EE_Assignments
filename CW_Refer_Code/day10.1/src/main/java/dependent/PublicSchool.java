package dependent;

import dependency.Coach;
import dependency.Teacher;

public class PublicSchool implements School {	
	private Teacher subjectTeacher;//=new MathsTeacher();
	private Coach sportsCoach;
	//ctor based D.I (Dependency injection)
	//D.I = Making the dependencies available to dependent 
	//objects directly @ run time
	public PublicSchool(Teacher teacher) {
		this.subjectTeacher=teacher;
		System.out.println("In constructor - " + getClass());
	}

	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	@Override
	public void organizeSportsEvent() {
		System.out.println("organize a sports event !");
		System.out.println(sportsCoach.getDailyWorkout());
	}

	public void setSportsCoach(Coach sportsCoach) {
		System.out.println("in setter : coach");
		this.sportsCoach = sportsCoach;
	}
	//custom init n destry methods
	public void anyInit() {
		System.out.println("in init");
	}
	public void anyDestroy() {
		System.out.println("in destroy");
	}

}

package dependent;

import dependency.Coach;
import dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	private Coach sportsCoach;

	public PublicSchool(Teacher subjectTeacher,Coach myCoach) {		
		System.out.println("In constructor - " + getClass());
		this.subjectTeacher=subjectTeacher;
		this.sportsCoach=myCoach;		
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

	// custom init n destry methods
	public void anyInit() {
		System.out.println("in init");
	}

	public void anyDestroy() {
		System.out.println("in destroy");
	}

}

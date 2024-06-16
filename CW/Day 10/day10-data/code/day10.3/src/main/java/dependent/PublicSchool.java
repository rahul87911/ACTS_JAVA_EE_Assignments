package dependent;

import dependency.Coach;
import dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	private Coach sportsCoach;

	public PublicSchool() {		
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

	// custom init n destry methods
	public void anyInit() {
		System.out.println("in init");
	}

	public void anyDestroy() {
		System.out.println("in destroy");
	}

	public void setSubjectTeacher(Teacher subjectTeacher) {
		System.out.println("in set teacher");
		this.subjectTeacher = subjectTeacher;
	}

	public void setSportsCoach(Coach sportsCoach) {
		System.out.println("in set coach");
		this.sportsCoach = sportsCoach;
	}

	

}

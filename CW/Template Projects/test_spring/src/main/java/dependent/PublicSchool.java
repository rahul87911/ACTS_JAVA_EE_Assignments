package dependent;

import dependency.Coach;
import dependency.MathsTeacher;
import dependency.Teacher;

public class PublicSchool implements School {	
	private Teacher subjectTeacher;
	private Coach sptcoach;
	
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
		System.out.println("oraganize Sports event");
		System.out.println(sptcoach.getDailyWorkout());
	}

	
	
	public void setSportsCoach(Coach sportsCoach) {
		System.out.println("in setter : coach");
		this.sptcoach = sportsCoach;
	}

}

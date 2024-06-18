package dependent;

import dependency.Coach;
import dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// =new MathsTeacher();
	private Coach sportsCoach;

	private PublicSchool(Teacher teacher,Coach coach) {
		this.subjectTeacher = teacher;
		this.sportsCoach=coach;
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

	// Factory based D.I
	public static PublicSchool anyName(Teacher subTeacher, Coach coach) {
		System.out.println("in factory method");
		return new PublicSchool(subTeacher, coach);
	}

}

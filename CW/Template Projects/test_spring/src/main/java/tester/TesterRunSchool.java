package tester;

import dependency.Coach;
import dependency.CricketCoach;
import dependency.ScienceTeacher;
import dependent.PublicSchool;
import dependent.School;

public class TesterRunSchool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  PublicSchool myschool = new PublicSchool(new ScienceTeacher());
  myschool.manageAcademics();

    myschool.setSportsCoach(new CricketCoach());
	myschool.organizeSportsEvent();
}
}

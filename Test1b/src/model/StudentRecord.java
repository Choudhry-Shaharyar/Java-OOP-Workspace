package model;

public class StudentRecord {

	private String course;
	private Assessment[] assessment;
	private int noa;
	private String[] record;
	private String s = "";
	public StudentRecord(String course) {
		this.course = course;
		this.assessment = new Assessment[10];
		this.record = new String [this.noa];
		this.noa = 0;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Assessment[] getObjectsOfAssessments() {
		Assessment[] a = new Assessment[this.noa];
		for(int i = 0; i < this.noa; i++) {
			a[i] = assessment[i];
		}
		return a;
	}
	
	public String getAssessmentReport() {
		
		if (this.noa == 0) {
			return "Number of assessments in " + course +": " + this.noa + " [" +  "]";
		}
		String record[] = new String[this.noa];
		for (int i = 0; i < noa; i++ ) {
			//String s ="";
			record[i] =   getObjectsOfAssessments()[i].getName() + " (weight: " + getObjectsOfAssessments()[i].getWeight() + " percents; marks: " + getObjectsOfAssessments()[i].getMark() +")";
			
			if(i == (noa - 1)) {
				s = s  + record[i];
			 }
			else if ((i != (noa - 1))){
			s = s  + record[i] + ", ";
			}
			 
		}
		
		//return "Number of assessments in " + course +": " + this.noa + " [" + record +"]";
		
		return "Number of assessments in " + course +": " + this.noa + " [" + s +"]";
		
	}

	public void addAssessment(String name, double weight, int mark) {
		Assessment a  = new Assessment(name, weight);
		a.setMarks(mark);
		
		this.assessment[this.noa] = a;
		this.noa++;
		
	}
	

}


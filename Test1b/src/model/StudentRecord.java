package model;

public class StudentRecord {

	private String course;
	private Assessment[] assessment;
	private int noa;
	private String s = "";
	private double weight3;
	private double rawMarks;
	private String status;
	private String tempName;

	public StudentRecord(String course) {
		this.course = course;
		this.assessment = new Assessment[10];

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
			return "Number of assessments in " + course + ": " + this.noa + " [" + "]";
		}
		String record[] = new String[this.noa];
		for(int i =0 ; i < this.noa; i++) {
			record[i] = getObjectsOfAssessments()[i].getName() + " (weight: " + getObjectsOfAssessments()[i].getWeight() + " percents; marks: " + getObjectsOfAssessments()[i].getMark()+ ")";

			if (i != (noa-1)) {
				s = s + record[i] + ", ";
			}
			else if(i == (noa -1)) {
				s = s + record[i];
				//return "Number of assessments in " + course +  ": " + this.noa + " [" + s + "]";
			}

		}
		return "Number of assessments in " + course +  ": " + this.noa + " [" + s + "]";

	}


	public double getCompletionRate() {
		for(int i =0 ; i < this.noa; i++) {
			weight3 = weight3 + getObjectsOfAssessments()[i].getWeight2();
		}


		return weight3;
	}

	//
	//	public double getRawMarks() {
	//		for(int i =0 ; i < this.noa; i++) {
	//			this.rawMarks =  rawMarks + getObjectsOfAssessments()[i].getMark() * getObjectsOfAssessments()[i].getWeight2();
	//		}
	//		return this.rawMarks;
	//	}

	public double getRawMarks() {
		for(int i =0 ; i < this.noa; i++) {
			this.rawMarks =  rawMarks + this.assessment[i].getMark() * this.assessment[i].getWeight2();
		}
		return this.rawMarks;
	}


	public void addAssessment(String name, double weight, int mark) {

		Assessment a = new Assessment (name, weight);
		a.setMarks(mark);
		this.assessment[this.noa] = a;
		this.noa++;
	}


	public void addAssessment(Assessment m1) {
		this.assessment[this.noa] = m1;
		this.noa++;

	}


	public void changeMarksOf(String name, int marks) {
		int index = -1;

		for(int i = 0; i < this.noa; i++) {
			String s = this.assessment[i].getName();
			if(s.equals(name)) {
				this.assessment[i].setMarks(marks);
				this.status = "markChange";
			}


		}

		if(index == -1) {
			this.status = "markChange";
			this.tempName = name;
		}



	}


	public void removeAssessment(String name) {
		int index = -1;

		for(int i = 0; i < this.noa; i++) {
			String s = this.assessment[i].getName();
			if(s.equals(name)) {
				this.assessment[i] = null;

				this.status = "remove";
				this.noa--;
			}

		}


		if(index == -1) {
			this.status = "markChange";
			this.tempName = name;
		}

	}


}

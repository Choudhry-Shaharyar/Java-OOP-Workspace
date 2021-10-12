package model;

public class Assessment {

	private String name;
	private int tempVarScore;
	private double tempWeight;
	private String status = "";
	private int mark;
	private double weight;
	private double calculatedWeight;
	private int noa;

	public Assessment(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark() {
		return mark;
	}

	public void setMarks(int mark) {
		this.tempVarScore = this.mark;
		this.mark = mark;
		this.status = "setMarks";
	}

	public String getWeight() {
		double w = this.weight * 100;
		String weight = String.format("%.3f", w);
		return weight;
	}

	public void setWeight(double weight) {
		this.tempWeight = this.weight;
		this.weight = weight;
		this.status = "setWeight";
	}
	
	public int getNOA() {
		return noa;
	}

	
	@Override
	public String toString() {

		double w = this.weight * 100;
		String weight = String.format("%.3f", w);
		
		double w2 = this.tempWeight * 100;
		String weight2 = String.format("%.3f", w2);

		if (this.status.equals("setMarks")) {
			return "Marks of assessment " + name + " (accounting for " + weight + " percents of the course) is changed from " + this.tempVarScore + " to " + this.getMark() + ".";                       
		}
		else if (this.status.equals("setWeight")){
			return "Weight of assessment " + name + " (with marks " + mark +") is changed from " + weight2 + " percents to " + weight +" percents.";
		}
		return "Assessment created: " + name + " accounts for " + weight + " percents of the course.";
	}


}



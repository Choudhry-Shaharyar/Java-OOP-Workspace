package model;

public class Assessment {

	private String name;
	private int tempMark;
	private double tempWeight;
	private String status = "";
	private int mark;
	private double weight;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMark() {
		return mark;
	}

	public void setMarks(int mark) {
		this.tempMark = this.mark;
		this.mark = mark;
		this.status = "setMarks";
	}

	public String getWeight() {
		double w = this.weight * 100;
		String weight = String.format("%.3f", w);
		return weight;
	}
	public double getWeight2() {
		
		return weight;
	}

	public void setWeight(double weight) {
		this.tempWeight = this.weight;
		this.weight = weight;
		this.status = "setWeight";
	}

	public int getNoa() {
		return noa;
	}

	public void setNoa(int noa) {
		this.noa = noa;
	}
	
	public String toString() {
		
		double mk = this.tempWeight * 100;
		String oldWeight = String.format("%.3f", mk);
		
		if(this.status.equals("setMarks")) {
			return "Marks of assessment " + name +  " (accounting for " + this.getWeight() + " percents of the course) is changed from " + this.tempMark + " to " + this.mark + ".";
		}
		
		else if(this.status.equals("setWeight")) {
			return "Weight of assessment " + name +  " (with marks " + mark + ") is changed from " +  oldWeight +  " percents to " + this.getWeight() + " percents."; 
			}
		
	    return "Assessment created: " + name + " accounts for "  + this.getWeight() + " percents of the course.";
	}
	
	
	
}

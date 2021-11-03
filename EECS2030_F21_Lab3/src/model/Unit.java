package model;

public class Unit {
	private String function;
	private int width;
	private int length;
	private int area;
	private String toggle;
	private String output;


	public Unit(String function, int width, int length) {
		this.function = function;
		this.length = length;
		this.width = width;
		this.area = this.width*this.length;
		this.toggle = "foot";
	}

	public boolean equals (Object obj) {
		if(this == obj) { 
			return true; 
		}
		if(obj == null || this.getClass() != obj.getClass()) { 
			return false;
		}
		Unit other = (Unit) obj;
		return ( this.area == other.area && this.function.equals(other.function));

	}
	//		 return this.weight == other.weight
	//		 && this.height == other.height
	//		 && this.firstName.equals(other.firstName)
	//		 && this.lastName.equals(other.lastName);


	public String getFunction() {
		return function;
	}



	public void setFunction(String function) {
		this.function = function;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	public int getArea() {
		return area;
	}



	public void setArea(int area) {
		this.area = area;
	}




	public String getToggle() {
		return toggle;
	}



	public void setToggle(String toggle) {
		this.toggle = toggle;
	}


	public String getOutput() {
		return output;
	}



	public void setOutput(String output) {
		this.output = output;
	}






	public String toString() {
		if(this.getToggle().equals("foot")) {
			return String.format("A unit of %s square feet (%s' wide and %s' long) functioning as %s",this.getArea(), this.getWidth(), this.getLength(), this.getFunction());
		}
		else{
			return this.getOutput();
		}
	}


	//	Change the measurement from feet to meters.
	//	 * Notes:
	//	 * 	- Use this conversion formula: One foot is equal to 0.3048 meter.
	//	 * 	- Each value of meters and square meters should be displayed with 2 digits after the decimal point.
	public void toogleMeasurement() { 

		double width;
		double length;
		double area;

		if(this.getToggle().equals("foot")) {
			width = this.getWidth() * 0.3048;
			length = this.getLength() * 0.3048;
			area = length * width;
			this.setOutput(String.format("A unit of %.2f square meters (%.2f m wide and %.2f m long) functioning as %s",area, width, length, this.getFunction()));
			this.setToggle("meters");
		}

		else if(this.getToggle().equals("meters")) {
			this.setToggle("foot");
		}





	}

}
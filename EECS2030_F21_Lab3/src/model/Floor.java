package model;

public class Floor {

	private int capacity;
	private Unit[] unit;
	private int nou;
	private int remainingSpace;
	private int utilizedSpace = 0;

	public Floor(int capacity) {
		this.capacity = capacity;
		this.unit = new Unit[20];
		this.nou = 0;
	}
	public Floor(Floor floor) {
		this.capacity = floor.getCapacity();
		this.unit = floor.getUnit();
		this.nou = floor.getNou();
	}

	//	Two floors are considered equal if: 
	//		 * 	1. their maximum capacities are the same; and
	//		 * 	2. their spaces are utilized in the same way 
	//		 * 		(meaning that for each added unit in one floor, we can find its equivalent in the other floor)
	//		 *  For 2, the orders in which units are added to the two floors do not matter.   
	//	public boolean equals (Object obj) {
	//}
	//	public boolean equals(Object obj) {
	//		int count  = 0;
	//		if(this == obj) { return true; }
	//		if(obj == null || this.getClass() != obj.getClass()) { return false; }
	//		Floor other = (Floor) obj;
	//		boolean equal = false;
	//		if(this.nou == other.nou) {
	//			equal = true;
	//			for(int i = 0; equal && i < this.nou; i ++) {
	//				equal = this.unit[i].equals(other.unit[i]);
	//				if(equal == true) {
	//					count = count + 1;
	//				}
	//			}
	//		}
	//		return equal;
	//	}



	public int getNou() {
		return nou;
	}
	public void setNou(int nou) {
		this.nou = nou;
	}
	public boolean equals (Object obj) {
		boolean equals = false;
		String function;
		int area;
		int count = 0;
		boolean stop = false;


		if(this == obj) { 
			return true; 
		}
		if(obj == null || this.getClass() != obj.getClass()) { 
			return false; 
		}
		Floor other = (Floor) obj;
		Floor f = new Floor(other);
		if(this.nou == 0 && f.nou == 0) {
			return this.capacity == f.capacity;
		}
		if(this.nou != f.nou) {
			return false;
		}
		for(int i = 0; i < this.nou; i++) {
			for(int j = 0; j < f.nou; j++) {
				if (this.unit[i].equals(f.unit[j])) {
					count = count + 1;
					f.unit[j].setFunction(""); // making sure this doesnt match again.
					j = 1000000; // to get the loop
				}
			}
		}
		return count == this.nou;

	}





	public String toString() {
	
		return String.format("Floor's utilized space is %s sq ft (%s sq ft remaining): [%s]", this.getUtilizedSpace(), this.getRemainingSpace(), this.getUnitListString());
	
	}


	private Object getUnitListString() {
		String s  = "";
		for(int i = 0; i < this.nou; i++) {
			if(i == this.nou - 1) {
				s = s + this.unit[i].getFunction() + ": " + this.unit[i].getArea() + " sq ft (" + this.unit[i].getWidth() + "' by " + this.unit[i].getLength() + "')"; 
			} else {
				s = s + this.unit[i].getFunction() + ": " + this.unit[i].getArea() + " sq ft (" + this.unit[i].getWidth() + "' by " + this.unit[i].getLength() + "'), "; 
			}
		}
		return s;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Unit[] getUnit() {
		return unit;
	}

	public void setUnit(Unit[] unit) {
		this.unit = unit;
	}

	public int getRemainingSpace() {
		return this.getCapacity() - this.utilizedSpace;
	}

	public void setRemainingSpace(int remainingSpace) {
		this.remainingSpace = remainingSpace;
	}

	public int getUtilizedSpace() {
		return utilizedSpace;
	}

	public void setUtilizedSpace(int utilizedSpace) {
		this.utilizedSpace = utilizedSpace;
	}

	// dimensions are in feet
	public void addUnit(String function, int width, int length) throws InsufficientFloorSpaceException { // we are throwing the exception because it is being handled in the StarterTests class, using try catch.
		Unit u = new Unit(function, width, length);
		if((u.getArea() > this.getRemainingSpace())) {
			throw new InsufficientFloorSpaceException("Unexpected exception thrown");
		} else {
			this.unit[this.nou] = u;
			this.setUtilizedSpace(this.getUtilizedSpace() + this.unit[this.nou].getArea());
			this.nou++;
		}

	}
}

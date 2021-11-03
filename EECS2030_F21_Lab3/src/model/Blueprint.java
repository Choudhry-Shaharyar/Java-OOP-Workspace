package model;

public class Blueprint {
	private int numPlannedFloors;
	private Floor[] floor;
	//private Floor[] builtFloors;
	private int numBuiltFloors;
	private double completionRate;

		public Blueprint(int numPlannedFloors) {
			this.numPlannedFloors = numPlannedFloors;
			this.floor = new Floor[this.numPlannedFloors];
			this.numBuiltFloors = 0;
			this.completionRate = 0.0;
			//this.builtFloors = new Floor[this.numBuiltFloors]
		}
		
		public boolean equals (Object obj) {
			 if(this == obj) { 
				 return true; 
				 }
			 if(obj == null || this.getClass() != obj.getClass()) { 
				 return false;
			 }
			 Blueprint other = (Blueprint) obj;
			 return (this.floor == other.floor);
			 
			 }
		
		
		public Blueprint(Blueprint bp1) {
			this.numPlannedFloors = bp1.getNumPlannedFloors();
			this.setFloor(bp1.floor);
			this.numBuiltFloors = bp1.getNumBuiltFloors();
			this.completionRate = bp1.completionRate;
		}

		public double getCompletionRate() {
			return completionRate;
					//(this.getNumBuiltFloors() / this.numPlannedFloors * 100);
			
		}



		public void setCompletionRate(double completionRate) {
			this.completionRate = completionRate;
		}



		public int getNumPlannedFloors() {
			return numPlannedFloors;
		}



		public void setNumPlannedFloors(int numPlannedFloors) {
			this.numPlannedFloors = numPlannedFloors;
		}



//		public Floor[] getFloors() {
//			Floor[] f = new Floor[this.numBuiltFloors];
//			for(int i = 0; i < this.numBuiltFloors; i++) {
//				f[i] = this.floor[i];
//			}
//			return f;
//		}
		public Floor[] getFloors() {
			Floor[] f = new Floor[this.numBuiltFloors];
			for(int i = 0; i < this.numBuiltFloors; i++) {
				f[i] = new Floor(floor[i]);
			}
			return f;
		}
		


		public void setFloor(Floor[] floor) {
			this.floor = floor;
		}



		public int getNumBuiltFloors() {
			return numBuiltFloors;
		}



		public void setNumBuiltFloors(int numBuiltFloors) {
			this.numBuiltFloors = numBuiltFloors;
		}



		public String toString() {
			return String.format("%.1f percents of building blueprint completed (%s out of %s floors)", this.getCompletionRate(), this.getNumBuiltFloors(), this.getNumPlannedFloors());
		}



		public void addFloorPlan(Floor f1) {
			this.floor[this.numBuiltFloors] = f1;
			this.setNumBuiltFloors(this.getNumBuiltFloors() + 1);
			double num = 0.0;
			num = ((double) this.numBuiltFloors / (double) this.numPlannedFloors) * 100;
			this.setCompletionRate(num);
			
		}



}

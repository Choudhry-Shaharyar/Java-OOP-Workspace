package model;


public class Log {

	private String version;
	// private int numberOfFixes;
	private String[] fixes;
	private final int MAX_CAPACITY = 10; // a constant maximum capacity
	private int nof;
	// Default constructor
	public Log () {
		this.fixes = new String[MAX_CAPACITY];
	}

	// Overloaded constructor
	public Log (String version) {
		this.version = version;
		this.fixes = new String[MAX_CAPACITY];
	}

	// Getters and Setters
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getNumberOfFixes() {
		return this.nof;
	}

	public String[] getPrivateFixesArray() {
		return this.fixes;
	}

	public void setFixes(String[] array) {
		//this.fixes = new String[MAX_CAPACITY];
	}


	public void addFix(String fix) {
		this.fixes[this.nof] = fix;
		this.nof++; 
	}

	public String getFixes() {
		String s = "[";
		String[] fixes = new String[this.nof]; 
		if(this.nof == 0) {
			return "[]";
		}
		for (int i = 0;  i < this.nof; i++) {
			if(i == (this.nof - 1)) {
				fixes[i] = this.fixes[i];
				s = s + fixes[i] +"]";
				return s;
			}
			fixes[i] = this.fixes[i];
			s = s + fixes[i] +", ";
		}
		return s;
	}


	public String toString() {
		String s = "";
		s += "Version " + this.version + " contains " + this.nof + " fixes " + this.getFixes();
		return s;
	}
}
















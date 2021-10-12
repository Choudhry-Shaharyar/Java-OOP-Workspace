package model;

public class App {

	private String name;
	private int maxNOL = 20; // max number of update logs
	private int maxNOR;
	private Log[] updateLogs;
	private int nol;
	private int nor;
	private int averageRating;
	private int[] ratings;
	private int score1 = 0;
	private int score2 = 0;
	private int score3 = 0;
	private int score4 = 0;
	private int score5 = 0;
	// constructor
	public App() {

	}

	// constructor
	public App(String name,int maxNOR) {
		this.name = name;
		this.maxNOR = maxNOR;
		this.updateLogs = new Log[maxNOL];
		this.ratings = new int[maxNOR];
		this.nol = 0;
		this.nor = 0;
		this.averageRating = 0;
	}


	public int[] getRatings() {
		return ratings;
	}


	public void submitRating(int ratings) {

		this.ratings[this.nor] = ratings;
		this.nor++;
		if (ratings == 1) {
			score1 = score1 + 1;
			averageRating = averageRating + 1;
		}
		else if (ratings == 2) {
			score2 = score2 + 1;
			averageRating = averageRating + 2;
		}
		else if (ratings == 3) {
			score3 = score3 + 1;
			averageRating = averageRating + 3;
		}
		else if (ratings == 4) {
			score4 = score4 + 1;
			averageRating = averageRating + 4;
		}
		else if (ratings == 5) {
			score5 = score5 + 1;
			averageRating = averageRating + 5;
		}
		else {

		}
	}


	public String getRatingReport() {
		if(this.nor == 0) {
			return "No ratings submitted so far!";
		}
		return "Average of " + this.nor + " ratings: " + this.getAverageRating(ratings) +" (Score 5: " + this.score5 +", " + "Score 4: " + this.score4 +", " + "Score 3: " + this.score3 +", " + "Score 2: " + this.score2 +", "+ "Score 1: " + this.score1 +")";
	}



	public String getAverageRating(int[] ratings) {
		int denominator = 1;

		for(int i =0; i < ratings.length; i++) {
			denominator = denominator + 1;
		}
		double result;
		result = this.averageRating/(double)this.nor;
		return String.format("%.1f", result); 
	}

	public String notApplicable() {
		return "n/a";
	}


	public int getNor() {
		return nor;
	}


	public void setNor(int nor) {
		this.nor = nor;
	}


	public int getNol() {
		return nol;
	}


	public void setNol(int nol) {
		this.nol = nol;
	}


	// Getters and Setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getWhatIsNew() { // string of last log update
		String[] s = new String[this.nol];
		int index = 0;
		for (int i = 0;  i < this.nol; i++) {
			s[i] = this.updateLogs[i].toString();
			index = i;
		}
		if(index == 0) {
			return "n/a";
		}
		return s[index];
	}


	public Log[] getUpdateHistory() {
		Log[] lg = new Log[this.nol];
		for (int i = 0;  i < this.nol; i++) {
			lg[i] = this.updateLogs[i];
		}
		return lg;
	}


	public Log getVersionInfo (String version) {
		int index = -1; // 
		for(int i = 0; i < this.nol; i++) {
			Log lg = this.updateLogs[i];
			if(lg.getVersion().equals(version)) {
				index = i;
			}
		}
		if(index < 0) {
			return null;
		}
		else {
			return this.updateLogs[index];
		}
	}

	public String toString() {
		String s ="";

		if (this.nor == 0) {
			return name + " (Current Version: " + this.getWhatIsNew() + "; " + "Average Rating: " + "n/a)"; 
		}
		s+= name + " (Current Version: " + this.getWhatIsNew() + "; " + "Average Rating: " + this.getAverageRating(this.ratings) + ")"; 
		return s ;
	}

	public Log[] getUpdateLogs() {
		return updateLogs;
	}

	public void setUpdateLogs(Log[] updateLogs) {
		this.updateLogs = updateLogs;
	}

	public void releaseUpdate(String version) {
		this.updateLogs[this.nol] = new Log(version);
		nol++;
	}
}

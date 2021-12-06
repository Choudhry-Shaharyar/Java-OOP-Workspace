package model;

public class WeatherApp {
	protected String name;
	protected int maxNOS;
	protected int nos;
	protected WeatherStation[] stations;
	
	public WeatherApp(String name, int maxNOS) {
		this.name = name;
		this.maxNOS = maxNOS;
		this.nos = 0;
		this.stations= new WeatherStation[maxNOS];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxNOS() {
		return maxNOS;
	}

	public void setMaxNOS(int maxNOS) {
		this.maxNOS = maxNOS;
	}

	public int getNos() {
		return nos;
	}

	public void setNos(int nos) {
		this.nos = nos;
	}
	
	private String getStations() {
		 String s = "";
		 for(int i =0; i < this.nos; i++) {
			 if(i == this.nos-1) {
				 s = s + this.stations[i].getName();
				 continue;
			 } 
			 s = s + this.stations[i].getName() + ", ";
		 }
		 return s;
	}
	
	public String toString() {
		if(this.nos == 0) {
			return String.format("%s is connected to no stations.", this.name);
		} else {
			 return String.format("%s is connected to %s stations: <%s>.", this.name,this.nos, this.getStations());
		}
	}

	public void addStation(WeatherStation weatherStation) {
		this.stations[this.nos] = weatherStation;
		this.nos++;
		
	}
	

}

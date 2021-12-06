package model;

public class ForecastApp extends WeatherApp {
	
	protected int[] temperature;
	protected int[] airPressure;
	protected double[] avgTemperature;
	protected int[] numberOfTemperatureInputs;
	protected int[] totalTemperature;
	protected boolean[] hasStats;
	protected int[] maxTemperature;
	protected String[] rainPrediction;
	// nos is inherited
	
	public ForecastApp(String name, int maxNOS) {
		super("Weather Forecast App " + name, maxNOS);	
		this.temperature = new int[maxNOS];
		this.airPressure = new int[maxNOS];
		this.avgTemperature = new double[maxNOS];
		this.numberOfTemperatureInputs = new int[maxNOS];
		this.totalTemperature = new int[maxNOS];
		this.hasStats = new boolean[maxNOS];
		this.maxTemperature = new int[maxNOS];
		this.rainPrediction = new String[maxNOS];
	}
	
	public void updateStationStats(int indexOfStation,  int temperature,  int airPressure) {
		
		if(this.nos == 1) {
			indexOfStation = 0;
		}
		if(this.hasStats[indexOfStation] != true) {
			this.rainPrediction[indexOfStation] = "unlikely to rain";
		}
		
		this.hasStats[indexOfStation] = true;
		
		if(airPressure < this.airPressure[indexOfStation]) {
			this.rainPrediction[indexOfStation] = "likely to rain";
		}  else {
			this.rainPrediction[indexOfStation] = "unlikely to rain";
		}
		
		if(temperature > this.maxTemperature[indexOfStation]) {
			this.maxTemperature[indexOfStation] = temperature;
		}
		
		
		this.airPressure[indexOfStation] = airPressure;
		this.numberOfTemperatureInputs[indexOfStation] += 1;
		this.totalTemperature[indexOfStation] += temperature;
		this.avgTemperature[indexOfStation] = (double) this.totalTemperature[indexOfStation] / (double) this.numberOfTemperatureInputs[indexOfStation];
	
	}
	
	
	public double[] getAvgTemperature() {
		return avgTemperature;
	}

	public void setAvgTemperature(double[] avgTemperature) {
		this.avgTemperature = avgTemperature;
	}

	public int[] getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(int[] maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public String[] getRainPrediction() {
		return rainPrediction;
	}

	public void setRainPrediction(String[] rainPrediction) {
		this.rainPrediction = rainPrediction;
	}

	public String getStationsString() { // this will add the stats
		String s = "";
		for(int i = 0; i < this.nos; i++) {
			
			if(i == 0) { // first object does not need a comma

				if(this.hasStats[i] == true) {
					s = String.format("%s {max temperature: %s, avg temperature: %.1f, %s}", this.stations[i].getName(), this.getMaxTemperature()[i], this.getAvgTemperature()[i], this.getRainPrediction()[i]); 
				} else {
					s = String.format("%s", this.stations[i].getName());
				}
			} else {
			
				if(this.hasStats[i] == true) {
					s = String.format("%s, %s {max temperature: %s, avg temperature: %.1f, %s}", s, this.stations[i].getName(), this.getMaxTemperature()[i], this.getAvgTemperature()[i], this.getRainPrediction()[i]); 
				} else {
					s = String.format("%s, %s", s, this.stations[i].getName());
				}			
			}
		}
		
		return s;
		
	}
	
	public String toString() {
		if(this.nos == 0) {
			return String.format("%s is connected to no stations.", this.name);
		} else {
			 return String.format("%s is connected to %s stations: <%s>.", this.name,this.nos, this.getStationsString());
		}
	}

}

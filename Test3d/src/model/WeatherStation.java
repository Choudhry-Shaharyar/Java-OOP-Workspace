package model;

public class WeatherStation {
	
	private String name;
	private int maxNOA;
	private int noa; // number of weather apps
	private int numberOfSensorApps;
	private int numberOfForecastApps;
	private WeatherApp[] weatherApps;
	
	
	private int temperature;
	private int airPressure;
	
	public WeatherStation(String name, int maxNOA) {
		this.name = name;
		this.maxNOA = maxNOA;
		this.noa = 0;
		this.numberOfSensorApps = 0;
		this.weatherApps = new WeatherApp[maxNOA];
		this.numberOfForecastApps = 0;
	}
	
	public String toString() {
		if(this.noa == 0) {
			return String.format("%s has no connected apps.", this.name);
		} else {
		 	return String.format("%s is connected by %s apps: <%s>.", this.name, this.noa, this.getApps());
		}
	
	}
	

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(int airPressure) {
		this.airPressure = airPressure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoa() {
		return noa;
	}

	public void setNoa(int noa) {
		this.noa = noa;
	}

	public WeatherApp[] getWeatherApps() {
		return weatherApps;
	}

	public void setWeatherApps(WeatherApp[] weatherApps) {
		this.weatherApps = weatherApps;
	}

	private String getApps() {
		 String s = "";
		 for(int i =0; i < this.noa; i++) {
			 if(i == this.noa-1) {
				 s = s + this.weatherApps[i].getName();
				 continue;
			 } 
			 s = s + this.weatherApps[i].getName() + ", ";
		 }
		 return s;
	}

	public SensorApp[] getSensors() {
		SensorApp[] sensorApp = new SensorApp[this.numberOfSensorApps];
		for(int i = 0, j=0; i < this.noa; i++) {
			if(this.weatherApps[i] instanceof SensorApp) {
				sensorApp[j] = (SensorApp) this.weatherApps[i];
			}
		}
		return sensorApp;
	}

	public void connect(WeatherApp app) {
	
		this.weatherApps[this.noa] = app;
		this.noa++;
		
		if(app instanceof SensorApp) {
			app.addStation(this);
			this.numberOfSensorApps++;
		} else {
			app.addStation(this);
			this.numberOfForecastApps++;
			
		}
		
	}

}

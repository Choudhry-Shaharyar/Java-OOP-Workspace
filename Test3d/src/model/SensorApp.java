package model;

public class SensorApp extends WeatherApp {


	public SensorApp(String name, int maxNOS ) {
		super("Weather Sensor App " + name, maxNOS);	
	}

	public void updateMeasurements(String stationName, int temperature, int airPressure) {

		int indexOfStation = -1;
		for(int i = 0; i < this.nos; i++) {

			if(this.stations[i].getName().equals(stationName)) {
				indexOfStation = i;
			}
		}

		this.stations[indexOfStation].setAirPressure(airPressure);
		this.stations[indexOfStation].setTemperature(temperature);

		for(int i = 0; i < this.stations[indexOfStation].getNoa(); i++) {
			if(this.stations[indexOfStation].getWeatherApps()[i] instanceof ForecastApp) {
				((ForecastApp) this.stations[indexOfStation].getWeatherApps()[i]).updateStationStats(indexOfStation, temperature, airPressure);
			}
		}

	}

	public String[] getConnectedForcastersOf(String stationName) {

		int j  =0;
		int indexOfStation = -1;


		for(int i = 0; i < this.nos; i++) {

			if(this.stations[i].getName().equals(stationName)) {
				indexOfStation = i;
			}
		}
		if(indexOfStation >= 0) {
			for(int i = 0; i < this.stations[indexOfStation].getNoa(); i++) {
				if(this.stations[indexOfStation].getWeatherApps()[i] instanceof ForecastApp) {
					j = j +1;
				}
			}


			String[] name = new String[j];

			for(int i = 0, k = 0; i < this.stations[indexOfStation].getNoa(); i++) {
				if(this.stations[indexOfStation].getWeatherApps()[i] instanceof ForecastApp) {
					name[k] = this.stations[indexOfStation].getWeatherApps()[i].name;
					k++;
				}
			}
			
			return name;
		} 
		else {
			String[] name = new String[0];
			return name; 
		}

	//	return name;
	}

}

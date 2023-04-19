package dependency_injection;

import com.google.inject.AbstractModule;

import javax.inject.Inject;
import java.io.IOException;

public class MeteorologicalStationController extends AbstractModule {

	private IMeteorologicalStationGUI gui;
	private int currentTemperature;
	private int currentWindspeed;
	private int currentHumidity;
	@Inject private IMeteorologicalFileStorage storage;
	@Inject private IMeteorologicalSensorArray sensorArray;

	@Inject public MeteorologicalStationController(IMeteorologicalStationGUI gui) {
		this.gui = gui;
	}

	public void measure() {
		currentTemperature = sensorArray.getTemperatureData();
		currentWindspeed = sensorArray.getWindspeedData();
		currentHumidity = sensorArray.getHumidityData();
		gui.displayTemperature(currentTemperature);
		gui.displayWindspeed(currentWindspeed);
		gui.displayHumidity(currentHumidity);
	}

	public void save() throws IOException {
		storage.setTemperature(currentTemperature);
		storage.setWindspeed(currentWindspeed);
		storage.setHumidity(currentHumidity);
		storage.save();
	}
}

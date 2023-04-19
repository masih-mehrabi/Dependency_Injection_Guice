package dependency_injection;

import com.google.inject.AbstractModule;

import javax.inject.Inject;
import java.io.IOException;

// TODO 4: Make the class a Guice module
public class MeteorologicalStationController extends AbstractModule {

	private IMeteorologicalStationGUI gui;
	private int currentTemperature;
	private int currentWindspeed;
	private int currentHumidity;
	//TODO 5: Tell Guice to inject this attribute. Make sure to use the newly created interfaces.
	@Inject private IMeteorologicalFileStorage storage;
	//TODO 6: Tell Guice to inject this attribute. Make sure to use the newly created interfaces.
	@Inject private IMeteorologicalSensorArray sensorArray;

	//TODO 7: Tell Guice to inject the Gui through the constructor
	@Inject public MeteorologicalStationController(IMeteorologicalStationGUI gui) {
		this.gui = gui;
		//TODO 8: Remove explicit instantiation of the attributes. Guice inject the instances for us.
//		this.storage =
//		this.sensorArray = new MeteorologicalSensorArray();
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

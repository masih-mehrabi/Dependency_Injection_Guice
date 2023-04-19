package dependency_injection;

import java.util.concurrent.ThreadLocalRandom;

/**
 * MeteorologicalSensorArray provides us with meteorological data
 */

public class MeteorologicalSensorArray implements IMeteorologicalSensorArray {
	private static final int MAX_TEMPERATURE = 41;
	private static final int MAX_WINDSPEED = 108;
	private static final int MAX_HUMIDITY = 101;

	public int getTemperatureData() {
		return ThreadLocalRandom.current().nextInt(MAX_TEMPERATURE);
	}

	public int getWindspeedData() {
		return ThreadLocalRandom.current().nextInt(MAX_WINDSPEED);
	}

	public int getHumidityData() {
		return ThreadLocalRandom.current().nextInt(MAX_HUMIDITY);
	}
}

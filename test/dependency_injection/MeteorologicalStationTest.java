package dependency_injection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class MeteorologicalStationTest {

	private static final int TEST_HUMIDITY = 42;
	private static final int TEST_WINDSPEED = 0;
	private static final int TEST_TEMPERATURE = 13;

	private Injector injector; // Guice Injector
	private MeteorologicalStationController controller; // SUT
	
	
//	IMeteorologicalStationGUI iMeteorologicalStationGUI;

	@BeforeEach
	void setUp() {

		injector = Guice.createInjector(new TestModule());
		controller = injector.getInstance(MeteorologicalStationController.class);
		
	}



	/**
	 * Note: In this case, we are testing measure() method of the controller, which makes calls to getTemperatureData(), getWindspeedData(), getHumidityData() of IMeteorologicalSensorArray
	 * => In this test case, only the mock of IMeteorologicalSensorArray is needed
	 */
	@Test
	void testMeasure() {
		IMeteorologicalSensorArray iMeteorologicalSensorArray = injector.getInstance(IMeteorologicalSensorArray.class);
		EasyMock.expect(iMeteorologicalSensorArray.getHumidityData()).andReturn(TEST_HUMIDITY);
		EasyMock.expect(iMeteorologicalSensorArray.getTemperatureData()).andReturn(TEST_TEMPERATURE);
		EasyMock.expect(iMeteorologicalSensorArray.getWindspeedData()).andReturn(TEST_WINDSPEED);
		EasyMock.replay(iMeteorologicalSensorArray);
		controller.measure();
		EasyMock.verify(iMeteorologicalSensorArray);
	}

}

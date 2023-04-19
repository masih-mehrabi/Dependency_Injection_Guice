package dependency_injection;

import com.google.inject.AbstractModule;
import org.easymock.EasyMock;

public class TestModule extends AbstractModule {
	
	@Override
	protected void configure() {
		IMeteorologicalStationGUI iMeteorologicalStationGUIMock =
				EasyMock.createMock(IMeteorologicalStationGUI.class);
		bind(IMeteorologicalStationGUI.class).toInstance(iMeteorologicalStationGUIMock);
		
		IMeteorologicalFileStorage iMeteorologicalFileStorageMock =
				EasyMock.createMock(IMeteorologicalFileStorage.class);
		bind(IMeteorologicalFileStorage.class).toInstance(iMeteorologicalFileStorageMock);
		
		IMeteorologicalSensorArray iMeteorologicalSensorArrayMock =
				EasyMock.createMock(IMeteorologicalSensorArray.class);
		bind(IMeteorologicalSensorArray.class).toInstance(iMeteorologicalSensorArrayMock);
	}
}

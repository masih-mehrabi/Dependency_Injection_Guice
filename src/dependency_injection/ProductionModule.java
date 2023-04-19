package dependency_injection;

import com.google.inject.AbstractModule;



public class ProductionModule extends AbstractModule {
	
	
	@Override
	protected void configure() {
		bind(IMeteorologicalStationGUI.class).to(MeteorologicalStationGUI.class);
		bind(IMeteorologicalFileStorage.class).to(MeteorologicalFileStorage.class);
		bind(IMeteorologicalSensorArray.class).to(MeteorologicalSensorArray.class);
		
	}

}

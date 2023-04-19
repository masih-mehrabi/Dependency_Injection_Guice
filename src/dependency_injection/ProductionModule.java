package dependency_injection;

import com.google.inject.AbstractModule;


//TODO 1: Make it a Guice module and configure the binding for the GUI class.
// Make sure to configure the binding for interface implementations as well.
public class ProductionModule extends AbstractModule {
	
//	@Inject private IMeteorologicalStationGUI iMeteorologicalStationGUI;
	
	@Override
	protected void configure() {
		bind(IMeteorologicalStationGUI.class).to(MeteorologicalStationGUI.class);
		bind(IMeteorologicalFileStorage.class).to(MeteorologicalFileStorage.class);
		bind(IMeteorologicalSensorArray.class).to(MeteorologicalSensorArray.class);
		
	}

}

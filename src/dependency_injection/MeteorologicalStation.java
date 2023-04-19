package dependency_injection;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * MeteorologicalStation contains the main method and starts up the application
 */
public final class MeteorologicalStation {
	private MeteorologicalStation() {

	}

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new ProductionModule());
		
		IMeteorologicalStationGUI msgui = injector.getInstance(IMeteorologicalStationGUI.class);
		msgui.show();
	}
}

package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI221 STRATEGY GpsSensorContent
 * 
 * @author Thomas Brüggemann
 */
public class CI221_Strategy extends TraceBackStrategy {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.TraceBackStrategy#execute()
	 */
	public StrategyResult execute() {
		
		this.params.put("startSink", INFORMATION_COLLECTION_SINKS);
		this.params.put("searchFor",
				new LinkedList<String>(
						Arrays.asList("GPS_PROVIDER", "LocationManager", "android.location", "GPS", "geoposition")));

		return super.execute();
	}
}

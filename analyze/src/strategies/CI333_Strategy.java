package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI333 STRATEGY LocationContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI333_Strategy extends TraceBackStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.TraceBackStrategy#execute()
	 */
	@Override
	public StrategyResult execute() {
		
		// Check if there is gps location collection going on in the callgraph
		// up to an information collection sink
		this.params.put("startSink", INFORMATION_COLLECTION_SINKS);
		this.params.put("searchFor", new LinkedList<String>(
				Arrays.asList("LocationManager", "LocationListener", "getLastKnownLocation")));

		return super.execute();
	}
}

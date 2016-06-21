package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI221 STRATEGY GpsSensorContent TODO: Auf TraceBackStrategy umbauen!
 * 
 * @author Thomas Brüggemann
 */
public class CI221_Strategy extends Strategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		// check for existance of GPS_PROVIDER code
		ExistanceStrategy exS = new ExistanceStrategy();
		exS.app = this.app;
		exS.params.put("searchFor", new LinkedList<String>(Arrays.asList("LocationManager.GPS_PROVIDER")));

		StrategyResult exResult = exS.execute();

		// check if a source of data flow is the location
		DataFlowStrategy dfS = new DataFlowStrategy();
		dfS.app = this.app;
		dfS.params.put("sourceIncludes", new LinkedList<String>(Arrays.asList("android.location")));

		StrategyResult dfResult = dfS.execute();

		// run parent strategy
		return StrategyResult.all(new LinkedList<StrategyResult>(Arrays.asList(exResult, dfResult)));
	}
}

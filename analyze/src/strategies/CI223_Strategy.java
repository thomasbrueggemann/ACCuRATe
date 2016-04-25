package strategies;

import java.util.LinkedList;

/**
 * CI223 STRATEGY WiFiSensorContent
 * 
 * @author Thomas Brüggemann
 */
public class CI223_Strategy extends ExistanceStrategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		LinkedList<String> searchFor = new LinkedList<String>();
		searchFor.add("LocationManager.NETWORK_PROVIDER");

		super.params.put("searchFor", searchFor);
		
		// run parent strategy
		StrategyResult result = super.execute();
		if(result.probability > 0.0 && result.found == true) {
			result.probability /= 2;
		}
				
		return result;
	}
}

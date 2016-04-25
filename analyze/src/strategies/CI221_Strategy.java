package strategies;

import java.util.LinkedList;

/**
 * CI221 STRATEGY GpsSensorContent
 * 
 * @author Thomas Brüggemann
 */
public class CI221_Strategy extends ExistanceStrategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		LinkedList<String> searchFor = new LinkedList<String>();
		searchFor.add("LocationManager.NETWORK_PROVIDER");

		super.params.put("searchFor", searchFor);
		
		// run parent strategy
		return super.execute();
	}
}

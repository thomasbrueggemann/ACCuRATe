package strategies;

import java.util.LinkedList;

/**
 * CH33 STRATEGY SharingWithAdvertiserContent
 * 
 * @author Thomas Brüggemann
 */
public class CH33_Strategy extends ExistanceStrategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		LinkedList<String> searchFor = new LinkedList<String>();
		searchFor.add("com.google.android.gms.ads");
		searchFor.add("admob");

		super.params.put("searchFor", searchFor);
		
		// run parent strategy
		return super.execute();
	}
}

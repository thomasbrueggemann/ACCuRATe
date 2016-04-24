package strategies;

import java.util.LinkedList;

/**
 * CH35 STRATEGY SharingWithAnalystContent
 * 
 * @author Thomas Brüggemann
 */
public class CH35_Strategy extends ExistanceStrategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		LinkedList<String> searchFor = new LinkedList<String>();
		searchFor.add("com.google.android.gms.analytics.GoogleAnalytics");
		searchFor.add("org.piwik.sdk");
		searchFor.add("com.segment.analytics");
		searchFor.add(".analytics");

		super.params.put("searchFor", searchFor);
		
		// run parent strategy
		return super.execute();
	}
}

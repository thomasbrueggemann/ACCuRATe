package strategies;

import java.util.LinkedList;

/**
 * CH35 STRATEGY SharingWithAnalystContent derived from
 * https://android-arsenal.com/tag/5
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
		searchFor.add("GoogleAnalytics");
		searchFor.add("org.piwik.sdk");
		searchFor.add("com.segment.analytics");
		searchFor.add("BloodHound.track");
		searchFor.add("tracklytics");
		searchFor.add("AnalyticsManager");
		searchFor.add("TrackScreen");
		searchFor.add("streethawk");
		searchFor.add("newrelic");
		searchFor.add("piwik");
		searchFor.add("localytics");
		searchFor.add("FlurryAgent");
		searchFor.add("ParseAnalytics");
		searchFor.add("com.microsoft.azure.engagement.EngagementAgent");
		searchFor.add("eqatec.analytics.monitor");
		searchFor.add(".analytics");
		searchFor.add("Countly.sharedInstance()");
		searchFor.add("com.yandex.metrica");

		super.params.put("searchFor", searchFor);
		
		// run parent strategy
		return super.execute();
	}
}

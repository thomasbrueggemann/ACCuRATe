package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CH33 STRATEGY SharingWithAdvertiserContent
 * 
 * @author Thomas Brüggemann
 */
public class CH33_Strategy extends ExistanceStrategy {
	
	/*
	 * Ad libraries following Longitudinal Analysis of Android Ad Library
	 * Permissions Theodore Book, Adam Pridgen, Dan S. Wallach
	 * 
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		LinkedList<String> searchFor = new LinkedList<String>(
				Arrays.asList("com.google.android.gms.ads", "com.google.ads", "com.inmobi", "com.tapjoy", "com.mobclix",
						"com.chartboost", "com.adwhirl", "com.mopub", " com.greystripe", "com.jumptap",
						"com.google.analytics", "com.admob", "com.burstly", "com.sponsorpay", "com.cauly", "com.mobfox",
						"com.vpon", "com.appbrain", "net.daum", "com.admarvel", "com.applovin", "com.adfonic",
						"com.mdotm", "com.getjar", "com.nexage", "com.inneractive", "com.pontiflex", "com.zestadz",
						"com.madhouse", "com.smaato", "net.youmi", "de.madvertise", "cn.domob", "com.jirbo.adcolony",
						"com.revmob", "com.senddroid", "com.airpush", "com.tapit", "com.medialets", "mediba.ad",
						"com.papaya", "com.huntmads", "com.rhythmnewmedia", "com.tapfortap", "com.adknowledge",
						"net.metaps", "com.wiyun", "com.vdopia", "com.waps", "com.adwo", "com.mobosquare", "mobi.vserv",
						"com.wooboo", "com.everbadge", "com.mt.airad", "com.noqoush.adfalcon", "com.moolah",
						"com.kuguo", "buzzcity", "com.adsmogo", "com.sellaring", "com.startapp", "com.admoda",
						"com.mobpartner", "com.quclix", "com.ldevelop"));

		super.params.put("searchFor", searchFor);
		
		// run parent strategy
		return super.execute();
	}
}

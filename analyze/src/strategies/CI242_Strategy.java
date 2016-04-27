package strategies;

import java.util.LinkedList;

/**
 * CI242 STRATEGY CookiesContent
 * 
 * @author Thomas Brüggemann
 */
public class CI242_Strategy extends ExistanceStrategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		LinkedList<String> searchFor = new LinkedList<String>();
		searchFor.add("CookieManager");
		super.params.put("searchFor", searchFor);
				
		return super.execute();
	}
}

package strategies;

import java.util.HashMap;
import java.util.Map;

/**
 * CH35 STRATEGY
 * @author Thomas Brüggemann
 * CH35 = SharingWithAnalystContent
 */
public class CH35_Strategy extends ExistanceStrategy {

	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	double execute() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("searchFor", "GoogleAnalytics");
		
		// run parent strategy
		return super.execute(params);
	}
}

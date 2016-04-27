package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI231 STRATEGY FingerprintScannerContent
 * 
 * @author Thomas Brüggemann
 */
public class CI231_Strategy extends Strategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		// check if the permissions to use NFC are set
		PermissionsStrategy perS = new PermissionsStrategy();
		perS.app = this.app;
		perS.params.put("searchFor", new LinkedList<String>(Arrays.asList("android.permission.USE_FINGERPRINT")));

		StrategyResult perResult = perS.execute();

		// check for usage of camera constants
		ExistanceStrategy exS = new ExistanceStrategy();
		exS.app = this.app;
		exS.params.put("searchFor", new LinkedList<String>(
				Arrays.asList("FingerprintManager", "FINGERPRINT_SERVICE")));
		
		StrategyResult exResult = exS.execute();

		// combine results
		return StrategyResult.any(new LinkedList<StrategyResult>(Arrays.asList(exResult, perResult)));
	}
}

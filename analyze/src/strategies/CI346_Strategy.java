package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI346 STRATEGY UserDeviceContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI346_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	@Override
	public StrategyResult execute() {
		
		InputInformationCollectionStrategy ics = new InputInformationCollectionStrategy();
		ics.app = this.app;
		ics.params.put("identifiers", new LinkedList<String>(
				Arrays.asList("device", "system", "operating", "hardware", "ipaddress", "host", "domain", "browser")));
		
		return ics.execute();
	}
}

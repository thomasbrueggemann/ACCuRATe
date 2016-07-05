package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI322 STRATEGY GovernmentIdentifierContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI322_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.TraceBackStrategy#execute()
	 */
	@Override
	public StrategyResult execute() {
		
		InputInformationCollectionStrategy ics = new InputInformationCollectionStrategy();
		ics.app = this.app;
		ics.params.put("identifiers", new LinkedList<String>(
				Arrays.asList("socialsecurity", "insurance", "tax", "SSN", "identification", "national",
						"government")));
		
		return ics.execute();
	}
}

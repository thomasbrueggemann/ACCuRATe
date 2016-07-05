package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI325 STRATEGY PhysicalContactContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI325_Strategy extends Strategy {

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
				Arrays.asList("street", "housenumber", "zip", "town", "country", "address", "city", "phone")));
		
		return ics.execute();
	}
}

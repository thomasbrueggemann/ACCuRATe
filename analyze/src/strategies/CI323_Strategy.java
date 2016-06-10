package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI323 STRATEGY NameContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI323_Strategy extends Strategy {

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
				Arrays.asList("surname")));
		
		return ics.execute();
	}
}

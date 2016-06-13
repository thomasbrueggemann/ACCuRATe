package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI344 STRATEGY IdeologicalContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI344_Strategy extends Strategy {

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
				Arrays.asList("religion", "policical", "politics", "believe", "union", "club")));
		
		return ics.execute();
	}
}

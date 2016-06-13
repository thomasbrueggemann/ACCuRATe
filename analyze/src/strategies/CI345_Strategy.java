package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI345 STRATEGY PreferencesContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI345_Strategy extends Strategy {

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
				Arrays.asList("like", "dislike", "favourite", "favorite")));
		
		return ics.execute();
	}
}

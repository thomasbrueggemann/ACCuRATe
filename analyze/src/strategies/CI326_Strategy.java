package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI326 STRATEGY OwnUniqueIdentifierContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI326_Strategy extends Strategy {

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
				Arrays.asList("username", "mail", "uuid", "guid", "ident", "user", "password")));
		
		return ics.execute();
	}
}

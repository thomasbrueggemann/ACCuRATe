package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CH37 STRATEGY SharingWithGovernmentContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH37_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		// find .gov domains
		ExistanceStrategy exS = new ExistanceStrategy();
		exS.app = this.app;
		exS.params.put("searchFor", new LinkedList<String>(Arrays.asList(".gov")));

		StrategyResult exResult = exS.execute();
		exResult.probability = StrategyResultProbability.LOW;

		return exResult;
	}
}

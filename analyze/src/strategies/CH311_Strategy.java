package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CH311 STRATEGY SharingWithUnrelatedContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH311_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		// find sharing dialogs
		ExistanceStrategy exS = new ExistanceStrategy();
		exS.app = this.app;
		exS.params.put("searchFor",
				new LinkedList<String>(
						Arrays.asList("ACTION_SEND", "ShareDialog", "PlusShare", "TweetComposer", "action.SENDTO",
								"action.SEND", "action.SEND_MULTIPLE")));

		StrategyResult exResult = exS.execute();
		exResult.probability = StrategyResultProbability.MEDIUM;

		return exResult;
	}
}

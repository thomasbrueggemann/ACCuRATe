package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CH312 STRATEGY SharingWithUserAuthorizedContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH312_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		// find sharing dialogs
		ExistanceStrategy exS = new ExistanceStrategy();
		exS.app = this.app;
		exS.params.put("searchFor", new LinkedList<String>(Arrays.asList("Intent.ACTION_SEND")));

		StrategyResult exResult = exS.execute();
		exResult.probability = 0.5;

		return exResult;

	}
}

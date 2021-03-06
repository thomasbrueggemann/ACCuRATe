package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI243 STRATEGY SurveysContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI243_Strategy extends Strategy {

	public StrategyResult execute() {

		// find sharing dialogs
		ExistanceStrategy exS = new ExistanceStrategy();
		exS.app = this.app;
		exS.params.put("searchFor", new LinkedList<String>(Arrays.asList("survey", "audit", "syllabus")));

		StrategyResult exResult = exS.execute();
		exResult.probability = (exResult.found == false) ? StrategyResultProbability.LOW : StrategyResultProbability.MEDIUM;
		
		return exResult;
	}
}

package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI336 STRATEGY PurchasesContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI336_Strategy extends TraceBackStrategy {

	@Override
	public StrategyResult execute() {

		// Check if there is contacts collection going on in the callgraph up
		// to an information collection sink
		this.params.put("startSink", INFORMATION_COLLECTION_SINKS);
		this.params.put("searchFor",
				new LinkedList<String>(Arrays.asList("purchase", "shoppingcart")));

		StrategyResult result = super.execute();

		if (result.found == false) {
			result.probability = StrategyResultProbability.LOW;
		}

		return result;
	}
}

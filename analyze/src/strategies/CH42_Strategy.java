package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CH42 STRATEGY CloudStorageContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH42_Strategy extends TraceBackStrategy {

	@Override
	public StrategyResult execute() {

		// Check if there is some "cloud" stuff going on in the callgraph up to
		// an internet connection
		this.params.put("startSink", INTERNET_COLLECTION_SINKS);
		this.params.put("searchFor", new LinkedList<String>(Arrays.asList("cloud")));

		StrategyResult result = super.execute();
		result.probability = StrategyResultProbability.LOW;

		return result;
	}
}

package strategies;

import java.util.Arrays;
import java.util.LinkedList;

public class CH45_Strategy extends Strategy {

	@Override
	public StrategyResult execute() {

		// find provider url
		ProviderUrlStrategy pus = new ProviderUrlStrategy();
		pus.app = this.app;

		StrategyResult pusResult = pus.execute();

		// a provider url seems to be available
		if (pusResult.found == true) {

			String host = (String) pusResult.snippets.get(0).extra.get("host");

			TraceBackStrategy tbs = new TraceBackStrategy();
			tbs.app = this.app;

			tbs.params.put("startSink", TraceBackStrategy.INTERNET_COLLECTION_SINKS);
			tbs.params.put("searchFor", new LinkedList<String>(Arrays.asList(host)));

			return tbs.execute();
		}

		return new StrategyResult(StrategyResultProbability.MEDIUM, false);
	}
}

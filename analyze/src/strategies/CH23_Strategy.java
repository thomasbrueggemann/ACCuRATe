package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CH23 STRATEGY SecurityDuringTransferContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH23_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		ExistanceStrategy exNonSSL = new ExistanceStrategy();
		exNonSSL.app = this.app;
		exNonSSL.params.put("searchFor", new LinkedList<String>(Arrays.asList("HttpURLConnection")));
		StrategyResult exNonSSLResult = exNonSSL.execute();

		ExistanceStrategy exSSL = new ExistanceStrategy();
		exSSL.app = this.app;
		exSSL.params.put("searchFor", new LinkedList<String>(Arrays.asList("HttpsURLConnection")));
		StrategyResult exSSLResult = exSSL.execute();

		// combine new result object from the existance and non-existance of HTTPS connections
		StrategyResult result = new StrategyResult();
		result.found = exSSLResult.found;
		result.probability = 1.0;

		if (exSSLResult.snippets.size() > 0) {
			result.probability = (double) exNonSSLResult.snippets.size() / (double) exSSLResult.snippets.size();
			result.snippets = exSSLResult.snippets;
		}

		return result;
	}
}

package strategies;

import soot.jimple.infoflow.results.ResultSinkInfo;
import soot.jimple.infoflow.results.ResultSourceInfo;
import soot.util.MultiMap;

/**
 * NETWORK TARGET STRATEGY
 * 
 * @author Thomas Brüggemann
 *
 */
public class NetworkTargetStrategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		// does a data-flow analysis exist?
		if (this.app.dataflow != null) {
			
			// extract all sinks that leave the phone via the network
			MultiMap<ResultSinkInfo, ResultSourceInfo> results = this.app.dataflow.getResults();

			// loop sinks
			for (ResultSinkInfo sink : results.keySet()) {

				String sinkStr = sink.toString().toLowerCase();

				// bullseye! found a sink
				if (sinkStr.contains("http") || sinkStr.contains("url")) {
					System.out.println(sinkStr);
					return new StrategyResult(1.0, true);
				}
			}
		}

		return new StrategyResult(1.0, false);
	}
}

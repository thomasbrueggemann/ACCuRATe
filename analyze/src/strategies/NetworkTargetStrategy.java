package strategies;

import java.util.HashMap;
import java.util.LinkedList;

import dataflow.Sink;
import dataflow.Source;

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
			HashMap<Sink, LinkedList<Source>> results = this.app.dataflow.getResults();

			// loop sinks
			for (Sink sink : results.keySet()) {

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

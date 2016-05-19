package strategies;

import java.util.HashMap;
import java.util.LinkedList;

import dataflow.Sink;
import dataflow.Source;

/**
 * DATA FLOW STRATEGY
 * 
 * @author Thomas Brüggemann
 * 
 *         Scans the data flows of an app for specific patterns
 *
 */
public class DataFlowStrategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	@SuppressWarnings("unchecked")
	public StrategyResult execute() {

		// does a data-flow analysis exist?
		if (this.app.dataflow != null) {

			HashMap<Sink, LinkedList<Source>> results = this.app.dataflow.getResults();

			// loop sinks
			for (Sink sink : results.keySet()) {
				
				// check if one of the "sinkIncludes" is within the sinks
				if (this.params.containsKey("sinkIncludes")) {

					for (String searchTermSink : (LinkedList<String>) this.params.get("sinkIncludes")) {

						// bullseye! found a sink
						if (sink.toString().contains(searchTermSink)) {
							return new StrategyResult(1.0, true);
						}
					}
				}

				// loop sources
				for (Source source : results.get(sink)) {

					// check if one of the "sourceIncludes" is within the sources
					if (this.params.containsKey("sourceIncludes")) {

						for (String searchTermSource : (LinkedList<String>) this.params.get("sourceIncludes")) {

							// bullseye! found a source
							if (source.toString().contains(searchTermSource)) {
								return new StrategyResult(1.0, true);
							}
						}
					}
				}
			}
		}

		return new StrategyResult(1.0, false);
	}
}

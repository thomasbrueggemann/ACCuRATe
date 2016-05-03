package strategies;

import soot.jimple.infoflow.results.ResultSinkInfo;
import soot.jimple.infoflow.results.ResultSourceInfo;
import soot.util.MultiMap;

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
	public StrategyResult execute() {

		// does a data-flow analysis exist?
		if (this.app.dataflow != null) {

			MultiMap<ResultSinkInfo, ResultSourceInfo> results = this.app.dataflow.getResults();

			// check for any specific sink or source
			for (ResultSinkInfo sink : results.keySet()) {
				System.out.println("Found a flow to sink " + sink + ", from the following sources:\n");

				for (ResultSourceInfo source : results.get(sink)) {
					System.out.println("\t- " + source.getSource() + "\n");

					if (source.getPath() != null && source.getPath().length > 0) {

						System.out.println("\t\ton Path " + source.getPath() + "\n");
					}
				}
			}
		}

		return new StrategyResult(1.0, false);
	}
}

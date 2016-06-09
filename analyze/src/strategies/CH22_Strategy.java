package strategies;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import analysis.Snippet;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;

public class CH22_Strategy extends Strategy {

	@Override
	public StrategyResult execute() {

		// check if a FileOutputStream is available
		ExistanceStrategy es = new ExistanceStrategy();
		es.app = this.app;
		es.params.put("searchFor", new LinkedList<String>(Arrays.asList("FileOutputStream(")));
		
		StrategyResult esResult = es.execute();
		
		// check if callgraph is available
		boolean callGraphAvailable = this.app.callgraph != null && this.app.callgraph.size() > 0;
		boolean storageAvailable = esResult.found == true;
		
		// is anything stored at all?
		if (storageAvailable) {

			// is a call graph available?
			if (callGraphAvailable) {

				int fileOutputStreamsFound = 0;
				int encryptionFound = 0;
				LinkedList<Snippet> snippets = new LinkedList<Snippet>();

				// check for FileOutputStream sinks by iterating over the
				// callgraph
				Iterator<Edge> edges = this.app.callgraph.iterator();

				while (edges.hasNext()) {
					Edge edge = (Edge) edges.next();

					// is there a FileOutputStream in the edge?
					if (edge.toString().contains("FileOutputStream")) {

						fileOutputStreamsFound++;
						boolean cryptFoundInCallstack = false;

						// trace back all callers
						SootMethod tgt = edge.tgt();

						// and recursively trace back all of their callers, till
						// the end!
						LinkedList<SootMethod> callers = this.traceBack(tgt);

						// do we have a crypto method in the call stack?
						for (SootMethod method : callers) {
							String mth = method.toString().toLowerCase();

							// is there anything encryption related in the call
							// stack?
							if (mth.contains("crypt") || mth.contains("cipher")) {

								if (cryptFoundInCallstack == false) {
									encryptionFound++;
									cryptFoundInCallstack = true;
								}
								
								// store the snippet
								Snippet snippet = new Snippet(method.getDeclaringClass().getName() + ".java",
										method.toString(), method.getJavaSourceStartLineNumber());
								snippets.add(snippet);
							}
						}
					}
				}

				// prepare results
				StrategyResult result = new StrategyResult();
				result.found = (encryptionFound > 0);
				result.probability = StrategyResultProbability.HIGH;
				result.snippets = snippets;

				if (fileOutputStreamsFound > 0) {
					result.extra.put("encryptionRatio", encryptionFound / fileOutputStreamsFound);
				}

				return result;
			}
			else {

				// no call graph available, so we could not actually check
				// anything, but assume that we found nothing with a low
				// probability
				return new StrategyResult(StrategyResultProbability.LOW, false);
			}
		}
		else {

			// nothing is ever stored
			return new StrategyResult(StrategyResultProbability.HIGH, false);
		}
	}
}

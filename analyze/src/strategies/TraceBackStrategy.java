package strategies;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import analysis.Snippet;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.Sources;

/**
 * TRACE BACK STRATEGY traces back from a sink up the callgraph and tries to
 * find features on the way up
 * 
 * @author Thomas Brüggemann
 *
 */
public class TraceBackStrategy extends Strategy {

	// INFORMATION COLLECTION SINKS
	public static LinkedList<String> INFORMATION_COLLECTION_SINKS = new LinkedList<String>(
			Arrays.asList("FileOutputStream", "URLConnection", "HttpResponse", "URL", "HttpClient", "HttpEntity",
					"database.Cursor", "SQLiteDatabase", "SharedPreferences"));

	// INTERNET COLLECTION SINKS
	public static LinkedList<String> INTERNET_COLLECTION_SINKS = new LinkedList<String>(
			Arrays.asList("URLConnection", "HttpResponse", "URL", "HttpClient", "HttpEntity"));
	
	// LOCAL STORAGE COLLECTION SINKS
	public static LinkedList<String> LOCAL_STORAGE_COLLECTION_SINKS = new LinkedList<String>(
			Arrays.asList("FileOutputStream", "database.Cursor", "SQLiteDatabase", "SharedPreferences"));

	private LinkedList<String> visitedSootMethods = new LinkedList<String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public StrategyResult execute() {

		// check params
		if ((!this.params.containsKey("startSink") || !this.params.containsKey("startSinkInverted"))
				&& !this.params.containsKey("searchFor")) {

			return null;
		}

		LinkedList<String> startSinks = new LinkedList<String>();
		LinkedList<String> startSinksInverted = new LinkedList<String>();

		// any start sinks available?
		if(this.params.containsKey("startSink")) {
			startSinks = (LinkedList<String>) this.params.get("startSink");
		}
		
		// any inverted search string of start sinks available?
		if (this.params.containsKey("startSinkInverted")) {
			startSinksInverted = (LinkedList<String>) this.params.get("startSinkInverted");
		}

		// check if a FileOutputStream is available
		ExistanceStrategy es = new ExistanceStrategy();
		es.app = this.app;
		es.params.put("searchFor", startSinks);

		StrategyResult esResult = es.execute();

		// is anything stored at all?
		boolean sinkFeaturesAvailable = esResult.found == true;
		if (sinkFeaturesAvailable) {

			// check if callgraph is available
			boolean callGraphAvailable = this.app.callgraph != null && this.app.callgraph.size() > 0;

			// is a call graph available?
			if (callGraphAvailable) {

				int sinksFound = 0;
				int featureFound = 0;
				LinkedList<Snippet> snippets = new LinkedList<Snippet>();

				// check for relavant sinks by iterating over the
				// callgraph
				Iterator<Edge> edges = this.app.callgraph.iterator();

				while (edges.hasNext()) {
					Edge edge = (Edge) edges.next();

					// is there a startSink in the edge?
					boolean isStartEdge = false;
					for (String startSink : startSinks) {
						if (edge.toString().contains(startSink)) {
							isStartEdge = true;
							break;
						}
					}
					
					// or check if a not-start sink is available, basically the
					// inversion of the existance of a sink
					for (String startSinkInverted : startSinksInverted) {
						if (!edge.toString().contains(startSinkInverted)) {
							isStartEdge = true;
							break;
						}
					}

					// start traversing the callgraph from the start edge
					if (isStartEdge) {

						sinksFound++;
						boolean foundInCallstack = false;

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
							for (String test : (LinkedList<String>) this.params.get("searchFor")) {

								if (mth == null || test == null)
									continue;

								if (mth.contains(test.toLowerCase())) {

									if (foundInCallstack == false) {
										featureFound++;
										foundInCallstack = true;
									}

									// store the snippet
									Snippet snippet = new Snippet(method.getDeclaringClass().getName() + ".java",
											method.toString(), method.getJavaSourceStartLineNumber());

									snippets.add(snippet);
								}
							}
						}
					}
				}

				// prepare results
				StrategyResult result = new StrategyResult();
				result.found = (featureFound > 0);
				result.probability = (featureFound > 0) ? StrategyResultProbability.HIGH
						: StrategyResultProbability.MEDIUM;
				result.snippets = snippets;

				if (sinksFound > 0) {
					result.extra.put("featureRatio", featureFound / sinksFound);
				}

				return result;
			} else {

				// no call graph available, so we could not actually check
				// anything, but assume that we found nothing with a low
				// probability
				return new StrategyResult(StrategyResultProbability.LOW, false);
			}

		} else {

			// nothing is ever stored
			return new StrategyResult(StrategyResultProbability.HIGH, false);
		}
	}

	/**
	 * TRACE BACK helps to iterate the callgraph up to a caller
	 * 
	 * @param target
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected LinkedList<SootMethod> traceBack(SootMethod target) {

		LinkedList<SootMethod> results = new LinkedList<SootMethod>();

		// is an analysis even feasble?
		if (this.app != null && this.app.callgraph != null && this.app.callgraph.size() > 0) {

			// found all callers
			Iterator sources = new Sources(this.app.callgraph.edgesInto(target));

			while (sources.hasNext()) {
				SootMethod src = (SootMethod) sources.next();

				// only traverse sootmethods we have not inspected yet
				if (!this.visitedSootMethods.contains(src.getSignature())) {

					results.add(src);
					this.visitedSootMethods.add(src.getSignature());

					results.addAll(this.traceBack(src));
				}
			}
		}

		return results;
	}
}

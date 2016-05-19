package dataflow;

import java.util.HashMap;
import java.util.LinkedList;

public class Results {
	private HashMap<Sink, LinkedList<Source>> results;

	public Results() {
		this.results = new HashMap<Sink, LinkedList<Source>>();
	}

	/**
	 * ADD RESULT adds a results set to the hashmap
	 * 
	 * @param sink
	 * @param source
	 */
	public void addResult(Sink sink, Source source) {
		
		if(!results.containsKey(sink)) {
			results.put(sink, new LinkedList<Source>());
		}
		
		results.get(sink).add(source);
	}

	/**
	 * GET RESULTS returns the results map
	 * 
	 * @return
	 */
	public HashMap<Sink, LinkedList<Source>> getResults() {
		return this.results;
	}
}

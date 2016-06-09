package strategies;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import analysis.App;
import config.StrategyConfigItem;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.Sources;

/**
 * @author Thomas Brüggemann
 * Abstract class that every Strategy class
 * can inherit from
 */
abstract public class Strategy {
	
	public Map<String, Object> params;
	protected StrategyConfigItem config;
	public App app;
	
	public Strategy() {
		this.params = new HashMap<String, Object>();
	}
	
	public void setConfig(StrategyConfigItem config) {
		this.config = config;
	}

	/*
	 * EXECUTE
	 * Execute the strategy and return a  
	 * probability value back
	 */
	public abstract StrategyResult execute();

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
				results.add(src);
				results.addAll(this.traceBack(src));
			}
		}

		return results;
	}
}

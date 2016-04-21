package strategies;

import java.util.HashMap;
import java.util.Map;

import analysis.App;
import config.StrategyConfigItem;

/**
 * @author Thomas Brüggemann
 * Abstract class that every Strategy class
 * can inherit from
 */
abstract public class Strategy {
	
	protected Map<String, Object> params;
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
	public abstract double execute();
}

package strategies;

import java.util.Map;

/**
 * @author Thomas Brüggemann
 * Abstract class that every Strategy class
 * can inherit from
 */
abstract public class Strategy {
	
	/*
	 * EXECUTE
	 * Execute the strategy and return a  
	 * probability value back
	 */
	abstract double execute(Map<String, Object> params);
}

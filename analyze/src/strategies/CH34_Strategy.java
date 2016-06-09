package strategies;

/**
 * CH34 STRATEGY SharingWithAggregatorContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH34_Strategy extends UrlCategoryStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		super.params.put("searchFor", "aggregator");
		
		// run parent strategy
		return super.execute();
	}
}

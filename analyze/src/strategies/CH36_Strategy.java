package strategies;

/**
 * CH36 STRATEGY SharingWithDeliveryContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH36_Strategy extends UrlCategoryStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		super.params.put("searchFor", "delivery");
		
		// run parent strategy
		return super.execute();
	}
}
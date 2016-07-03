package strategies;

/**
 * CH37 STRATEGY SharingWithGovernmentContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH37_Strategy extends UrlCategoryStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		this.params.put("searchFor", "government");
		return super.execute();
	}
}

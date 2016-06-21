package strategies;

/**
 * CH46 STRATEGY ThirdPartyStorageContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH46_Strategy extends UrlCategoryStrategy {

	@Override
	public StrategyResult execute() {

		super.params.put("searchFor", "storage");

		// run parent strategy
		return super.execute();
	}
}

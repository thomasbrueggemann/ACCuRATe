package strategies;

/**
 * CH35 STRATEGY
 * @author Thomas Brüggemann
 * CH35 = SharingWithAnalystContent
 */
public class CH35_Strategy extends ExistanceStrategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public double execute() {
		
		super.params.put("searchFor", "for");
		
		// run parent strategy
		return super.execute();
	}
}

package strategies;

/**
 * CH39 STRATEGY SharingWithProviderAgentsContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH39_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		NetworkTargetStrategy ntS = new NetworkTargetStrategy();
		ntS.app = this.app;
		StrategyResult result = ntS.execute();

		return result;
	}
}

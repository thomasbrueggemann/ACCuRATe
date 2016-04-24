package strategies;

import java.util.LinkedList;

/**
 * CI211 STRATEGY BluetoothSensorContent
 * 
 * @author Thomas Brüggemann
 */
public class CI211_Strategy extends PermissionsStrategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		LinkedList<String> searchFor = new LinkedList<String>();
		searchFor.add("android.permission.BLUETOOTH");

		super.params.put("searchFor", searchFor);
		
		// run parent strategy
		return super.execute();
	}
}

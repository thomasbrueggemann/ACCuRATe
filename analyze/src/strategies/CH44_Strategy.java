package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CS44 STRATEGY OtherUserDeviceStorageContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH44_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		// check permissions
		PermissionsStrategy ps = new PermissionsStrategy();
		ps.app = this.app;
		ps.params.put("searchFor",
				new LinkedList<String>(Arrays.asList("WRITE_EXTERNAL_STORAGE")));

		StrategyResult psResult = ps.execute();

		// check for code usage of storage
		ExistanceStrategy es = new ExistanceStrategy();
		es.app = this.app;
		es.params.put("searchFor", new LinkedList<String>(
				Arrays.asList("getSharedPreferences(", "createTempFile(", "openFileOutput(", "FileOutputStream(",
						"getWritableDatabase(", "SQLiteDatabase")));
		
		StrategyResult esResult = es.execute();

		// combine results
		return StrategyResult.all(new LinkedList<StrategyResult>(Arrays.asList(psResult, esResult)));
	}
}

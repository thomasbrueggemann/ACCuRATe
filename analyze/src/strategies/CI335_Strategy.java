package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI335 STRATEGY OnlineContactsContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI335_Strategy extends Strategy {

	@Override
	public StrategyResult execute() {

		// check for contacts permissions
		PermissionsStrategy ps = new PermissionsStrategy();
		ps.app = this.app;
		ps.params.put("searchFor", new LinkedList<String>(Arrays.asList("android.permission.READ_CONTACTS")));
		StrategyResult psResult = ps.execute();

		// check for the ContactsContract appearance
		ExistanceStrategy es = new ExistanceStrategy();
		es.app = this.app;
		es.params.put("searchFor", new LinkedList<String>(Arrays.asList("ContactsContract")));
		StrategyResult esResult = es.execute();

		// combine
		return StrategyResult.any(new LinkedList<StrategyResult>(Arrays.asList(psResult, esResult)));
	}
}

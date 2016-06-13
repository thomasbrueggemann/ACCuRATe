package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI335 STRATEGY OnlineContactsContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI335_Strategy extends TraceBackStrategy {

	@Override
	public StrategyResult execute() {

		// Check if there is contacts collection going on in the callgraph up
		// to an information collection sink
		this.params.put("startSink", INFORMATION_COLLECTION_SINKS);
		this.params.put("searchFor",
				new LinkedList<String>(Arrays.asList("ContactsContract", "contacts")));

		return super.execute();
	}
}

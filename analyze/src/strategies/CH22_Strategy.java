package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CH22 STRATEGY SecurityDuringStorageContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH22_Strategy extends TraceBackStrategy {

	@Override
	public StrategyResult execute() {

		// Check if there is crypting or ciphering going on in the callgraph up
		// to a File Storage
		this.params.put("startSink", LOCAL_STORAGE_COLLECTION_SINKS);
		this.params.put("searchFor", new LinkedList<String>(Arrays.asList("crypt", "cipher")));

		return super.execute();
	}
}

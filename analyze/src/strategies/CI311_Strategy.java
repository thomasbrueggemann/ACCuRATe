package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI311 STRATEGY AudioInformationContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI311_Strategy extends TraceBackStrategy {

	@Override
	public StrategyResult execute() {
		
		// Check if there is audio collection going on in the callgraph up
		// to an information collection sink
		this.params.put("startSink", INFORMATION_COLLECTION_SINKS);
		this.params.put("searchFor", new LinkedList<String>(
				Arrays.asList("microphone", "audio", "recorder", "mediarecorder", "music", "sound")));

		return super.execute();
	}

}

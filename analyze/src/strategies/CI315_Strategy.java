package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI315 STRATEGY VideoInformationContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI315_Strategy extends TraceBackStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.TraceBackStrategy#execute()
	 */
	@Override
	public StrategyResult execute() {
		
		// Check if there is video collection going on in the callgraph up
		// to an information collection sink
		this.params.put("startSink", INFORMATION_COLLECTION_SINKS);
		this.params.put("searchFor", new LinkedList<String>(
				Arrays.asList("video", "MEDIA_TYPE_VIDEO", "ACTION_VIDEO_CAPTURE", "CAPTURE_VIDEO")));

		return super.execute();
	}
}

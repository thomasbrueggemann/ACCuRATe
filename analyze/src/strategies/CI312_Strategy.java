package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI312 STRATEGY ImageInformationContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI312_Strategy extends TraceBackStrategy {

	@Override
	public StrategyResult execute() {
		
		// Check if there is image collection going on in the callgraph up
		// to an information collection sink
		this.params.put("startSink", INFORMATION_COLLECTION_SINKS);
		this.params.put("searchFor", new LinkedList<String>(
				Arrays.asList("picture", "ACTION_IMAGE_CAPTURE", "MEDIA_TYPE_IMAGE", "CAPTURE_IMAGE", "image",
						"setImageDrawable", "Bitmap")));

		return super.execute();
	}
}

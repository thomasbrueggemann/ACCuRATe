package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI213 STRATEGY MicrophoneContent
 * 
 * @author Thomas Brüggemann
 */
public class CI213_Strategy extends ExistanceStrategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		this.params.put("searchFor", new LinkedList<String>(
				Arrays.asList("MediaRecorder.setAudioSource(", "MediaRecorder.AudioSource.MIC")));
		
		return super.execute();
	}
}

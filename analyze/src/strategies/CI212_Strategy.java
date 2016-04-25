package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI212 STRATEGY CameraContent
 * 
 * @author Thomas Brüggemann
 */
public class CI212_Strategy extends Strategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.ExistanceStrategy#execute(java.util.Map)
	 */
	public StrategyResult execute() {
		
		// check for camera permissions
		PermissionsStrategy perS = new PermissionsStrategy();
		perS.app = this.app;
		perS.params.put("searchFor",
				new LinkedList<String>(Arrays.asList("android.permission.CAMERA", "android.hardware.camera")));

		StrategyResult perResult = perS.execute();

		// check for usage of camera constants
		ExistanceStrategy exS = new ExistanceStrategy();
		exS.app = this.app;
		exS.params.put("searchFor", new LinkedList<String>(
				Arrays.asList("ACTION_IMAGE_CAPTURE", "ACTION_VIDEO_CAPTURE", "FEATURE_CAMERA")));
		
		StrategyResult exResult = exS.execute();

		// combine results
		return StrategyResult.any(new LinkedList<StrategyResult>(Arrays.asList(perResult, exResult)));
	}
}

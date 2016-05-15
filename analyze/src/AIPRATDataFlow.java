import analysis.App;

public class AIPRATDataFlow {

	/**
	 * MAIN
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage: java -jar AIRPRATDataFlow.jar ./pathToAndroidSDKPlatforms ./pathToAPKFile/");
			System.exit(1);
		}

		App app = new App(args[1]);
		app.getDataFlows(args[0]);
	}
}

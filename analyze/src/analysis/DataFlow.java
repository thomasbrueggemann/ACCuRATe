package analysis;

import soot.jimple.infoflow.android.SetupApplication;
/**
 * DATA FLOW ANALYSIS using FlowDroid
 * (https://blogs.uni-paderborn.de/sse/tools/flowdroid/)
 * 
 * @author Thomas Brüggemann
 *
 */
public class DataFlow {

	private SetupApplication setupApp;

	public DataFlow(App app) {
		this.setupApp = new SetupApplication("/Volumes/Macintosh/Users/thomasbruggemann/Library/Android/sdk/platforms",
				app.path);

		this.setupApp.setMatrixFileLocation("SourcesAndSinks.txt");
		this.setupApp.setEntryPointsFile("entrypoints-someLines.txt");
		this.setupApp.setTaintWrapperFile("../../soot-infoflow/trunk/EasyTaintWrapperSource.txt");

		app.calculateSourcesSinksEntrypoints();
	}

	public void analyze() {

	}
}

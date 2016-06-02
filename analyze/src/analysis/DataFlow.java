package analysis;

import java.io.IOException;
import java.util.Collections;

import javax.xml.stream.XMLStreamException;

import org.xmlpull.v1.XmlPullParserException;

import soot.PackManager;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration.CallbackAnalyzer;
import soot.jimple.infoflow.android.SetupApplication;
import soot.jimple.infoflow.android.source.AndroidSourceSinkManager.LayoutMatchingMode;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.results.xml.InfoflowResultsReader;
import soot.jimple.infoflow.results.xml.SerializedInfoflowResults;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.jimple.infoflow.taintWrappers.ITaintPropagationWrapper;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.options.Options;
/**
 * DATA FLOW ANALYSIS using FlowDroid
 * (https://blogs.uni-paderborn.de/sse/tools/flowdroid/)
 * 
 * @author Thomas Brüggemann
 *
 */
public class DataFlow {

	private App app;
	private static InfoflowAndroidConfiguration config = new InfoflowAndroidConfiguration();
	private String sdkPlatformsPath = "/Volumes/Macintosh/Users/thomasbruggemann/Library/Android/sdk/platforms";

	/**
	 * DATA FLOW
	 * 
	 * @param app
	 */
	public DataFlow(App app) {
		this.app = app;
	}

	/**
	 * ANALYZE
	 * 
	 * @return
	 */
	public InfoflowResults analyze() {

		// flowdroid config
		config.setEnableStaticFieldTracking(false);
		config.setFlowSensitiveAliasing(false);
		config.setComputeResultPaths(false);
		config.setLayoutMatchingMode(LayoutMatchingMode.NoMatch);
		config.setCallbackAnalyzer(CallbackAnalyzer.Fast);

		InfoflowAndroidConfiguration.setAccessPathLength(1);

		final SetupApplication app = new SetupApplication(this.sdkPlatformsPath, this.app.path + ".apk");

		app.setConfig(config);
		app.setCallbackFile("tools/flowdroid/AndroidCallbacks.txt");

		// taint wrapper
		final ITaintPropagationWrapper taintWrapper;
		EasyTaintWrapper easyTaintWrapper = null;
		try {
			easyTaintWrapper = new EasyTaintWrapper("tools/flowdroid/EasyTaintWrapperSource.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (easyTaintWrapper != null) {

			easyTaintWrapper.setAggressiveMode(false);
			taintWrapper = easyTaintWrapper;

			app.setTaintWrapper(taintWrapper);
		}

		try {
			app.calculateSourcesSinksEntrypoints("tools/flowdroid/SourcesAndSinks.txt");
		} catch (IOException | XmlPullParserException e) {
			e.printStackTrace();
		}

		return app.runInfoflow();
	}

	/**
	 * PARSE an FlowDroid xml file
	 * 
	 * @return InfoflowResults
	 */
	public SerializedInfoflowResults parse() {

		// parse the serialized flowdroid xml
		try {
			return new InfoflowResultsReader().readResults(this.app.path + ".xml");
		} catch (XMLStreamException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * GET CALL GRAPH analyzes and return the callgraph of the app
	 * 
	 * @return
	 */
	public CallGraph getCallGraph() {

		SetupApplication app = new SetupApplication(this.sdkPlatformsPath, this.app.path + ".apk");
		try {
			app.setCallbackFile("tools/flowdroid/AndroidCallbacks.txt");
			app.calculateSourcesSinksEntrypoints("tools/flowdroid/SourcesAndSinks.txt");
		} catch (IOException | XmlPullParserException e) {
			e.printStackTrace();
			return null;
		}

		soot.G.reset();

		Options.v().set_src_prec(Options.src_prec_apk);
		Options.v().set_process_dir(Collections.singletonList(this.app.path + ".apk"));
		Options.v().set_android_jars(this.sdkPlatformsPath);
		Options.v().set_whole_program(true);
		Options.v().set_allow_phantom_refs(true);
		Options.v().setPhaseOption("cg.spark", "on");

		Scene.v().loadNecessaryClasses();

		SootMethod entryPoint = app.getEntryPointCreator().createDummyMain();
		Options.v().set_main_class(entryPoint.getSignature());
		Scene.v().setEntryPoints(Collections.singletonList(entryPoint));
		System.out.println(entryPoint.getActiveBody());

		PackManager.v().runPacks();

		CallGraph appCallGraph = Scene.v().getCallGraph();
		this.app.callgraph = appCallGraph;
		return appCallGraph;
	}
}

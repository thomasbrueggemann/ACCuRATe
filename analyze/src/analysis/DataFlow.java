package analysis;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.android.SetupApplication;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.options.Options;
/**
 * DATA FLOW ANALYSIS using FlowDroid
 * (https://blogs.uni-paderborn.de/sse/tools/flowdroid/)
 * 
 * @author Thomas Brüggemann
 *
 */
public class DataFlow {

	private SetupApplication appSetup;

	public DataFlow(App app) {

		// init new flowdroid setup
		this.appSetup = new SetupApplication("/Volumes/Macintosh/Users/thomasbruggemann/Library/Android/sdk/platforms",
				app.path + ".apk");

		// set the SOOT config
		this.appSetup.setSootConfig(new IInfoflowConfig() {

			@Override
			public void setSootOptions(Options opt) {
				opt.set_include_all(true);
				opt.set_debug(false);
				opt.set_allow_phantom_refs(true);
				opt.set_verbose(false);
				opt.keep_line_number();
			}
		});

		InfoflowAndroidConfiguration.setAccessPathLength(1);

		this.appSetup.setConfig(new InfoflowAndroidConfiguration());

		// set android callbacks
		this.appSetup.setCallbackFile("tools/flowdroid/AndroidCallbacks.txt");

		// try to set the taint wrapper
		try {
			this.appSetup.setTaintWrapper(new EasyTaintWrapper("tools/flowdroid/EasyTaintWrapperSource.txt"));
		} catch (IOException e) {

			e.printStackTrace();
			this.appSetup.setTaintWrapper(null);
		}

		// try to set and calculate the source/sink entry points
		try {
			this.appSetup.calculateSourcesSinksEntrypoints("tools/flowdroid/SourcesAndSinks.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ANALYZE
	 */
	public InfoflowResults analyze() {

		// run the data flow analysis
		final InfoflowResults res = this.appSetup.runInfoflow();
		return res;
	}
}

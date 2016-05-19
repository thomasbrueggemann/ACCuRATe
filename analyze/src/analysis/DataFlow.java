package analysis;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParserException;

import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.android.SetupApplication;
import soot.jimple.infoflow.android.source.AndroidSourceSinkManager.LayoutMatchingMode;
import soot.jimple.infoflow.config.IInfoflowConfig;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.results.ResultSinkInfo;
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
	private App app;
	private String sdkPlatformsPath = "/Volumes/Macintosh/Users/thomasbruggemann/Library/Android/sdk/platforms";

	/*
	 * DATAFLOW
	 */
	public DataFlow(String sdkPlatformsPath, App app) {
		this.sdkPlatformsPath = sdkPlatformsPath;
		this.setup(app);
	}

	/*
	 * DATAFLOW
	 */
	public DataFlow(App app) {
		this.setup(app);
	}

	/*
	 * SETUP
	 */
	private void setup(App app) {
		this.app = app;

		// init new flowdroid setup
		this.appSetup = new SetupApplication(this.sdkPlatformsPath, app.path + ".apk");

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

		InfoflowAndroidConfiguration iac = new InfoflowAndroidConfiguration();
		iac.setFlowSensitiveAliasing(false);
		iac.setEnableStaticFieldTracking(false);
		iac.setComputeResultPaths(false);
		iac.setLayoutMatchingMode(LayoutMatchingMode.NoMatch);

		InfoflowAndroidConfiguration.setAccessPathLength(1);
		
		this.appSetup.setConfig(iac);

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
		final InfoflowResults res = this.appSetup.runInfoflow(new DataFlowResultsAvailableHandler(this.app));
		return res;
	}

	public InfoflowResults parse() {
		
		InfoflowResults infoResults = new InfoflowResults();

		try {

			// get new xml factory to parse xml file
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// create xml stream
			InputStream is = new FileInputStream(this.app.path + ".xml");
			Document doc = builder.parse(is);

			// doc.getDocumentElement().normalize();
			NodeList resultsList = doc.getElementsByTagName("Result");
			for (int i = 0; i <= resultsList.getLength(); i++) {

				// <Result>
				Node resultNode = resultsList.item(i);

				Node sinkNode = resultNode.getFirstChild();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private ResultSinkInfo parseSink(Node sinkNode) {

	}
}

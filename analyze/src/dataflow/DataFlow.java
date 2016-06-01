package dataflow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParserException;

import analysis.App;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration;
import soot.jimple.infoflow.android.InfoflowAndroidConfiguration.CallbackAnalyzer;
import soot.jimple.infoflow.android.SetupApplication;
import soot.jimple.infoflow.android.source.AndroidSourceSinkManager.LayoutMatchingMode;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.taintWrappers.EasyTaintWrapper;
import soot.jimple.infoflow.taintWrappers.ITaintPropagationWrapper;
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
	public Results parse() {
		
		Results infoResults = new Results();

		try {

			// get new xml factory to parse xml file
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// create xml stream
			InputStream is = new FileInputStream(this.app.path + ".xml");
			Document doc = builder.parse(is);

			// doc.getDocumentElement().normalize();
			NodeList resultsList = doc.getElementsByTagName("Result");
			for (int i = 0; i < resultsList.getLength(); i++) {

				// <Result>
				Node resultNode = resultsList.item(i);
				if (resultNode.getNodeType() == Node.ELEMENT_NODE) {
					Element resultElement = (Element) resultNode;

					// <Sink />
					NodeList sinkList = resultElement.getElementsByTagName("Sink");
					if (sinkList.getLength() == 1) {

						if (sinkList.item(0).getNodeType() == Node.ELEMENT_NODE) {
							Element sinkElement = (Element) sinkList.item(0);

							Sink sink = this.parseSink(sinkElement);

							// <Sources />
							NodeList sourcesList = resultElement.getElementsByTagName("Source");
							for (int j = 0; j < sourcesList.getLength(); j++) {

								Node sourceNode = sourcesList.item(j);
								if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {

									// <Source />
									Element sourceElement = (Element) sourceNode;
									Source source = this.parseSource(sourceElement);

									// add this sink/source pair to the final
									// infoflow results object
									infoResults.addResult(sink, source);
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return infoResults;
	}

	/**
	 * PARSE SINK parses a single Sink Element into its class represenatation
	 * 
	 * @param sinkElement
	 * @return ResultSinkInfo
	 */
	private Sink parseSink(Element sinkElement) {

		NodeList accessPathNodes = sinkElement.getElementsByTagName("AccessPath");
		if(accessPathNodes.getLength() > 0 && accessPathNodes.item(0).getNodeType() == Node.ELEMENT_NODE) {
			
			// <AccessPath />
			Element accessPathElement = (Element) accessPathNodes.item(0);
			AccessPath accessPath = new AccessPath();
			accessPath.Value = accessPathElement.getAttribute("Value");
			accessPath.Type = accessPathElement.getAttribute("Type");
			accessPath.TaintSubFields = (accessPathElement.getAttribute("TaintSubFields") == "true");
			
			Statement statement = new Statement();
			statement.Method = sinkElement.getAttribute("Method");
			statement.Statement = sinkElement.getAttribute("Statement");
			
			return new Sink(statement, accessPath);
		}
		else {
			return null;
		}
	}

	/**
	 * PARSE SOURCE parses the source element into its class representation
	 * 
	 * @param sourceElement
	 * @return ResultSourceInfo
	 */
	private Source parseSource(Element sourceElement) {

		NodeList accessPathNodes = sourceElement.getElementsByTagName("AccessPath");
		if (accessPathNodes.getLength() > 0 && accessPathNodes.item(0).getNodeType() == Node.ELEMENT_NODE) {

			// <AccessPath />
			Element accessPathElement = (Element) accessPathNodes.item(0);
			AccessPath accessPath = new AccessPath();
			accessPath.Value = accessPathElement.getAttribute("Value");
			accessPath.Type = accessPathElement.getAttribute("Type");
			accessPath.TaintSubFields = (accessPathElement.getAttribute("TaintSubFields") == "true");

			Statement statement = new Statement();
			statement.Method = sourceElement.getAttribute("Method");
			statement.Statement = sourceElement.getAttribute("Statement");

			return new Source(statement, accessPath);
		} else {
			return null;
		}
	}
}

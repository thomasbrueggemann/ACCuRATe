package analysis;
import java.io.File;
import java.util.LinkedList;

import dataflow.DataFlow;
import dataflow.Results;

/**
 * Represents an app directory
 * 
 * @author Thomas Brüggemann
 */
public class App {
	public String path;
	public Results dataflow;

	public App(String path) {

		this.path = path;
	}

	/**
	 * GET ALL SOURCE FILES
	 * 
	 * @return Returns a list of all file paths that are included in this app
	 *         directory
	 */
	public LinkedList<String> getAllSourceFiles() {

		// walk down the path
		return walkFiles(this.path, ".java");
	}

	/**
	 * GET MANIFEST FILE
	 * 
	 * @return the path to the manifest file
	 */
	public String getManifestFile() {

		String p = this.path;
		if (!p.endsWith("/")) {
			p += "/";
		}

		// check if manifest exists
		File f = new File(p + "AndroidManifest.xml");
		if (f.exists() && !f.isDirectory()) {
			return f.getAbsolutePath();
		}

		return null;
	}

	/**
	 * GET PACKAGE NAME
	 * 
	 * @return
	 */
	public String getPackageName() {

		String[] parts = this.path.split("/");
		return parts[parts.length - 1];
	}

	/**
	 * GET DATA FLOWS
	 * 
	 * @return The data flow info result
	 */
	/*
	 * public InfoflowResults getDataFlows() {
	 * 
	 * DataFlow flow = new DataFlow(this); this.dataflow = flow.analyze();
	 * 
	 * return this.dataflow; }
	 * 
	 * public InfoflowResults getDataFlows(String sdkPlatformsPath) {
	 * 
	 * DataFlow flow = new DataFlow(sdkPlatformsPath, this); this.dataflow =
	 * flow.analyze();
	 * 
	 * return this.dataflow; }
	 */

	/**
	 * PARSE DATA FLOWS tries to parse the stored data flows from an xml file
	 * 
	 * @return
	 */
	public Results parseDataFlows() {

		DataFlow flow = new DataFlow(this);
		this.dataflow = flow.parse();
		return this.dataflow;
	}

	/**
	 * WALK FILES
	 * 
	 * @param path
	 * @param filter
	 * @return List of all files in that direcory given the applied filter
	 */
	private LinkedList<String> walkFiles(String path, String filter) {

		LinkedList<String> results = new LinkedList<String>();

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return results;

		for (File f : list) {
			if (f.isDirectory()) {

				// recursively walk down the directories and append
				// to top level results list
				results.addAll(this.walkFiles(f.getAbsolutePath(), filter));
			} else {

				// only include file if it meets filter criteria
				if (f.getName().contains(filter)) {

					results.add(f.getAbsolutePath());
				}
			}
		}

		return results;
	}
}

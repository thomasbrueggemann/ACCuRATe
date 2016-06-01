package analysis;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

import analysis.urls.AppUrl;
import analysis.urls.ClassifyUrls;
import dataflow.DataFlow;
import dataflow.Results;
import de.daslaboratorium.machinelearning.classifier.Classification;
import soot.jimple.infoflow.results.InfoflowResults;

/**
 * Represents an app directory
 * 
 * @author Thomas Brüggemann
 */
public class App {
	public String path;
	public Results dataflow;
	public LinkedList<AppUrl> urls = new LinkedList<AppUrl>();
	public LinkedList<AppUrl> categorizedUrls = new LinkedList<AppUrl>();

	public InfoflowResults infoflowResults;

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
	 * EXTRACT APP URLS from the android source code
	 * 
	 * @return
	 */
	public LinkedList<AppUrl> extractAppUrls() {

		LinkedList<String> files = this.getAllSourceFiles();
		LinkedList<Snippet> snippets = new LinkedList<Snippet>();
		LinkedList<AppUrl> results = new LinkedList<AppUrl>();

		ClassifyUrls classifyUrls = new ClassifyUrls();

		for (String file : files) {

			FileScanner scanner = new FileScanner(file);

			try {
				// scan files for a search word
				snippets.addAll(scanner.scan("\"http://"));
				snippets.addAll(scanner.scan("\"https://"));

			} catch (FileNotFoundException e) {
			}
		}

		LinkedList<String> blacklistUrls = new LinkedList<String>(Arrays.asList("android.com", "schema.org"));

		// loop all snippets
		for (Snippet s : snippets) {

			boolean retainSnippet = true;

			// try to parse the url out of the snippet line
			String url = s.extractURL();
			if (url.length() <= 8) {
				retainSnippet = false;
			}

			// check if url is blacklisted
			for (String blacklistUrl : blacklistUrls) {

				if (s.toString().contains(blacklistUrl)) {
					retainSnippet = false;
				}
			}

			if (retainSnippet == true) {

				// add to list of all urls
				AppUrl appUrl = new AppUrl();
				appUrl.category = null;
				appUrl.probability = -1;
				appUrl.url = url;
				appUrl.snippet = s;
				this.urls.add(appUrl);

				// try to classify the url
				Classification<String, String> classification = classifyUrls.classify(url);
				if (classification != null) {

					String category = classification.getCategory();
					if (category != null) {

						AppUrl classifiedAppUrl = new AppUrl();
						classifiedAppUrl.category = category;
						classifiedAppUrl.probability = classification.getProbability();
						classifiedAppUrl.url = url;
						classifiedAppUrl.snippet = s;

						results.add(classifiedAppUrl);
					}
				}
			}
		}

		// store the results in a local variable
		this.categorizedUrls = results;

		return results;
	}

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

	public InfoflowResults analyzeDataFlows() {

		DataFlow flow = new DataFlow(this);
		this.infoflowResults = flow.analyze();
		return this.infoflowResults;
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

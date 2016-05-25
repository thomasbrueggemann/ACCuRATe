package analysis.urls;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import de.daslaboratorium.machinelearning.classifier.Classification;
import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

public class ClassifyUrls {

	private final Classifier<String, String> bayes;
	private final boolean DEBUG = false;

	public ClassifyUrls() {
		this.bayes = new BayesClassifier<String, String>();
		this.bayes.setMemoryCapacity(25000);
	}

	/**
	 * CLASSIFY attempts to classify a given input url into the available
	 * categories
	 * 
	 * @param url
	 * @return
	 */
	public Classification<String, String> classify(String url) {
		return this.bayes.classify(this.sanitizeUrl(url));
	}

	/**
	 * TRAIN trains the classifier with urls
	 */
	public void train() {
		File root = new File("src/analysis/urls/training/");
		File[] list = root.listFiles();
		int learnIterations = 0;
		LinkedList<String> alreadyLearned = new LinkedList<String>();
		
		if (list != null) {
			for (File f : list) {
				if (f.isFile() && !f.getName().startsWith(".|-")) {

					String category = f.getName();
					Scanner scanner = null;
					
					// open file and loop lines
					try {
						scanner = new Scanner(f);

						// loop lines of training file
						while (scanner.hasNextLine()) {
							String line = scanner.nextLine();
							
							// train bayes with this domain
							List<String> urlParts = this.sanitizeUrl(line);
							String description = this.downloadDescription(line);

							if (!urlParts.isEmpty() && !alreadyLearned.contains(category + "_" + urlParts.toString())) {

								this.bayes.learn(category, urlParts);
								alreadyLearned.add(category + "_" + urlParts.toString());
								if (this.DEBUG)
									System.out.println("learn: " + category + " -> " + urlParts.toString());
								learnIterations++;
							}
						}

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally {
						// close scanner if open
						if (scanner != null) {
							scanner.close();
						}

						if (this.DEBUG)
							System.out.println("Learning iteations: " + learnIterations);
					}
				}
			}
		}
	}

	/**
	 * SANITIZE URL splits a given url in its pieces to analyze by the
	 * classifier
	 * 
	 * @param url
	 * @return
	 */
	private List<String> sanitizeUrl(String url) {

		List<String> results = new LinkedList<String>();

		String[] dotSep = url.split("\\.");
		String[] noDomainEnding = Arrays.copyOf(dotSep, dotSep.length - 1);

		for (String domainPart : noDomainEnding) {
			String[] dashSep = domainPart.split("-");

			for (String dashPart : dashSep) {
				if (dashPart.length() > 3) {
					results.add(dashPart.replace("www", ""));
				}
			}
		}

		return results;
	}

	private String downloadDescription(String url) {

		// prepend http if necessary
		if (!url.startsWith("http")) {
			url = "http://" + url;
		}

		try {
			// extract description meta tag
			Document doc = Jsoup.connect(url).get();
			String desc = this.getMetaTag(doc, "description");
			if (desc == null || desc.length() <= 2) {
				return null;
			}

			return desc;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * GET META TAG http://stackoverflow.com/a/9958448/874508
	 * 
	 * @param document
	 * @param attr
	 * @return
	 */
	private String getMetaTag(Document document, String attr) {
		Elements elements = document.select("meta[name=" + attr + "]");
		for (Element element : elements) {
			final String s = element.attr("content");
			if (s != null)
				return s;
		}
		elements = document.select("meta[property=" + attr + "]");
		for (Element element : elements) {
			final String s = element.attr("content");
			if (s != null)
				return s;
		}
		return null;
	}
}

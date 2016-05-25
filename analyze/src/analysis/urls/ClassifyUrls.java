package analysis.urls;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import de.daslaboratorium.machinelearning.classifier.Classification;
import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

public class ClassifyUrls {

	private final Classifier<String, String> bayes;
	private final boolean DEBUG = true;

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

		String description = this.downloadDescription(url);
		if(description != null) {

			return this.bayes.classify(Arrays.asList(description.split("\\s")));
		}
		
		return null;
	}

	/**
	 * TRAIN trains the classifier with urls
	 */
	public void train() {
		File root = new File("src/analysis/urls/training/");
		File[] list = root.listFiles();
		
		if (list != null) {
			for (File f : list) {
				if (f.isFile() && !f.getName().startsWith(".|-")) {

					String category = f.getName();
					Scanner scanner = null;
					Set<String> lines = new HashSet<String>();
					
					// open url file and loop lines
					try {
						scanner = new Scanner(f);

						// loop lines of training file
						while (scanner.hasNextLine()) {
							lines.add(scanner.nextLine());
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
					}

					// download descriptions of url lines file in parallel
					Map<String, String> descriptions = new ConcurrentHashMap<>();
					lines.parallelStream().forEach((line) -> {

						String description = this.downloadDescription(line);
						if (description != null && description.length() > 5) {
							descriptions.put(line, description);
						}
					});

					// train bayes with descriptions of urls
					LinkedList<String> alreadyLearned = new LinkedList<String>();
					int learnIterations = 0;

					for (Map.Entry<String, String> entry : descriptions.entrySet()) {

						if (!alreadyLearned.contains(entry.getKey())) {

							this.bayes.learn(category, Arrays.asList(entry.getValue().split("\\s")));
							alreadyLearned.add(entry.getKey());

							if (this.DEBUG)
								System.out.println("learn: " + category + " -> " + entry.getValue().split("\\s"));

							learnIterations++;
						}
					}

					if (this.DEBUG)
						System.out.println("Learn iterations: " + learnIterations);
				}
			}
		}
	}

	/**
	 * DOWNLOAD DESCRIPTION tries to download the description meta tag of a url
	 * to be used in training of the url classifier
	 * 
	 * @param url
	 * @return
	 */
	private String downloadDescription(String url) {

		// prepend http if necessary
		if (!url.startsWith("http")) {
			url = "http://" + url;
		}

		if (this.DEBUG)
			System.out.println(url);

		try {
			// extract description meta tag
			Document doc = Jsoup.connect(url).get();
			String desc = this.getMetaTag(doc, "description");
			if (desc == null || desc.length() <= 2) {
				return null;
			}

			return desc;

		} catch (Exception e) {
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

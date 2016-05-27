package analysis.urls;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
	private final boolean DEBUG = true;

	public ClassifyUrls() {

		this.bayes = new BayesClassifier<String, String>();
		this.bayes.setMemoryCapacity(9999999);
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
		int learnIterations = 0;
		
		if (list != null) {
			for (File f : list) {
				if (f.isFile() && !f.getName().startsWith(".")) {

					String category = f.getName();
					if (category.contains(".")) {
						category = category.split("\\.")[0];
					}

					Scanner scanner = null;
					
					// open url file and loop lines
					try {
						scanner = new Scanner(f);

						// loop lines of training file
						while (scanner.hasNextLine()) {
							this.bayes.learn(category, Arrays.asList(scanner.nextLine().split("\\s")));
							learnIterations++;
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

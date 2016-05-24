package analysis.urls;

import java.io.File;

import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

public class ClassifyUrls {

	private final Classifier<String, String> bayes;

	public ClassifyUrls() {
		this.bayes = new BayesClassifier<String, String>();
	}

	/**
	 * TRAIN trains the classifier with urls
	 */
	public void train() {
		File root = new File("../analysis/urls/training/");
		File[] list = root.listFiles();
		
		if (list != null) {
			for (File f : list) {
				if (f.isDirectory()) {

					String trainingFile = f.getAbsolutePath();
					String category = f.getName();
					System.out.println(category);
				}
			}
		}
	}
}

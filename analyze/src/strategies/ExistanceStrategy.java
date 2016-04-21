package strategies;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import analysis.FileScanner;
import analysis.Snippet;

/**
 * @author Thomas Brüggemann
 *
 */
public class ExistanceStrategy extends Strategy {
	
	/*
	 * (non-Javadoc)
	 * @see strategies.Strategy#execute()
	 */
	public double execute() {

		LinkedList<String> files = this.app.getAllSourceFiles();

		for (String file : files) {

			FileScanner scanner = new FileScanner(file);

			try {

				// scan files for a search word
				LinkedList<Snippet> snippets = scanner.scan((String) this.params.get("searchFor"));

				// return 1 if the search word was found
				// return 0 otherwise
				if (snippets.size() > 0) {
					return 1.0;
				}

			} catch (FileNotFoundException e) {
				return 0.0;
			}
		}

		return 0.0;
	}
}

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

		FileScanner scanner = new FileScanner(this.pathToApp);

		try {

			// scan files for a search word
			LinkedList<Snippet> files = scanner.scan((String) this.params.get("searchFor"));
			
			// return 1 if the search word was found
			// return 0 otherwise
			return (files.size() > 0) ? 1.0 : 0.0;
			
		} catch (FileNotFoundException e) {
			return 0.0;
		}
	}
}

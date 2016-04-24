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
	@SuppressWarnings("unchecked")
	public StrategyResult execute() {

		LinkedList<String> files = this.app.getAllSourceFiles();

		for (String file : files) {

			FileScanner scanner = new FileScanner(file);

			try {

				LinkedList<Snippet> snippets = new LinkedList<Snippet>();
				
				// scan files for a search word
				for (String searchTerm : (LinkedList<String>) this.params.get("searchFor")) {
					snippets.addAll(scanner.scan(searchTerm));
				}

				// return 1 if the search word was found
				// return 0 otherwise
				if (snippets.size() > 0) {
					return new StrategyResult(1.0, snippets);
				}

			} catch (FileNotFoundException e) {
			}
		}

		return new StrategyResult(0.0);
	}
}

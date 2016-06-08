package strategies;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import analysis.FileScanner;
import analysis.Snippet;

public class InputStrategy extends Strategy {

	@Override
	public StrategyResult execute() {

		// first, check all layout files
		LinkedList<String> files = this.app.getAllLayoutXMLFiles();
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
					return new StrategyResult(StrategyResultProbability.HIGH, true, snippets);
				}

			} catch (FileNotFoundException e) {
			}
		}

		return new StrategyResult(StrategyResultProbability.HIGH, false);
	}

}

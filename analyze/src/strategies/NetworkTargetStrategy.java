package strategies;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

import analysis.FileScanner;
import analysis.Snippet;

/**
 * NETWORK TARGET STRATEGY
 * 
 * @author Thomas Brüggemann
 *
 */
public class NetworkTargetStrategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		LinkedList<String> files = this.app.getAllSourceFiles();
		LinkedList<Snippet> snippets = new LinkedList<Snippet>();

		for (String file : files) {

			FileScanner scanner = new FileScanner(file);

			try {
				// scan files for a search word
				snippets.addAll(scanner.scan("\"http://"));
				snippets.addAll(scanner.scan("\"https://"));

			} catch (FileNotFoundException e) {
			}
		}

		LinkedList<Snippet> filteredSnippets = new LinkedList<Snippet>();
		LinkedList<String> blacklistUrls = new LinkedList<String>(Arrays.asList("android.com", "schema.org"));

		// loop all snippets
		for(Snippet s : snippets) {

			boolean isWhite = true;

			// try to parse the url out of the snippet line

			// check if url is blacklisted
			for(String blacklistUrl : blacklistUrls) {
				if (s.toString().contains(blacklistUrl)) {
					isWhite = false;
				}
			}

			if (isWhite == true) {
				filteredSnippets.add(s);
				System.out.println(s.toString());
			}
		}

		// return 1 if the search word was found
		// return 0 otherwise
		if (filteredSnippets.size() > 0) {
			return new StrategyResult(1.0, true, filteredSnippets);
		}
		else {
			return new StrategyResult(1.0, false);
		}
	}
}

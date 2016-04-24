package strategies;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import analysis.FileScanner;
import analysis.Snippet;

/**
 * Checks for a permission flag in the Android manifest file
 * 
 * @author Thomas Brüggemann
 *
 */
public class PermissionsStrategy extends Strategy {

	public StrategyResult execute() {

		// find manifest file for app
		String manifest = this.app.getManifestFile();
		if (manifest != null) {

			FileScanner scanner = new FileScanner(manifest);

			LinkedList<Snippet> snippets = new LinkedList<Snippet>();

			// scan files for a search word
			for (String searchTerm : (LinkedList<String>) this.params.get("searchFor")) {
				try {
					snippets.addAll(scanner.scan(searchTerm));
				} catch (FileNotFoundException e) {
				}
			}

			// return 1 if the search word was found
			// return 0 otherwise
			if (snippets.size() > 0) {
				return new StrategyResult(1.0, snippets);
			}
		}
		
		return new StrategyResult(0.0);
	}
}

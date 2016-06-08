package strategies;

import java.util.LinkedList;

import analysis.Snippet;
import analysis.urls.AppUrl;

/**
 * Checks if a url with a specific category is available
 * 
 * @author Thomas Brüggemann
 *
 */
public class UrlCategoryStrategy extends Strategy {

	public StrategyResult execute() {

		double probs = 0.0;
		int probCount = 0;
		LinkedList<Snippet> snippets = new LinkedList<Snippet>();

		// no parameter to search for available?
		if (!this.params.containsKey("searchFor")) {
			return new StrategyResult(StrategyResultProbability.HIGH, false);
		}

		// loop all categorized urls
		for (AppUrl appUrl : this.app.categorizedUrls) {

			// cound a category match
			if (appUrl.category == (String) this.params.get("searchFor")) {

				// add to temporary hit list
				probs += appUrl.probability;
				probCount++;
				snippets.add(appUrl.snippet);
			}
		}

		if (probCount > 0) {
			return new StrategyResult(StrategyResultProbability.fromDouble(probs / (double) probCount), true, snippets);
		}

		return new StrategyResult(StrategyResultProbability.LOW, false);
	}
}

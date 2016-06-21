package strategies;

import analysis.StringAnalyzer;
import analysis.urls.AppUrl;

public class ProviderUrlStrategy extends Strategy {

	@Override
	public StrategyResult execute() {

		StrategyResult result = new StrategyResult();

		String packageName = this.app.getPackageName();
		String[] packageNameParts = packageName.split("\\.");

		// loop the urls of the app and try to identify the provider name
		for (AppUrl url : this.app.urls) {

			// loop the parts of the package name
			for (String packageNamePart : packageNameParts) {

				// if it is longer than 3 characters, check if a similar url
				// host exists
				if (packageNamePart.length() > 3) {

					String[] urlParts = url.url.split("/");
					for (String urlPart : urlParts) {

						int similarity = StringAnalyzer.isSimilar(urlPart, packageNamePart);
						double similarityScore = 1.0
								- (double) similarity / (double) Math.max(url.url.length(), packageNamePart.length());

						// URL hit, this is similar to package name
						if (similarityScore > 0.9) {
							
							
							result.extra.put("url", url.url);
							result.found = true;
							result.probability = StrategyResultProbability.fromDouble(similarityScore);
							result.snippets.add(url.snippet);

							return result;
						}
					}
				}
			}
		}

		// if no similar URL was found, there is still a chance, that the app
		// somehow sends data to an app provider server, via IP or other
		// obfuscation methods
		return new StrategyResult(StrategyResultProbability.LOW, false);
	}

}

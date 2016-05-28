package strategies;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import analysis.StringAnalyzer;
import analysis.urls.AppUrl;

/**
 * CH39 STRATEGY SharingWithProviderAgentsContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH39_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	public StrategyResult execute() {

		StrategyResult result = new StrategyResult();

		String packageName = this.app.getPackageName();
		String[] packageNameParts = packageName.split("\\.");
		
		// loop the urls of the app and try to identify the provider name
		for (AppUrl url : this.app.urls) {
			
			try {
				URI uri = new URI(url.url);

				// loop the parts of the package name
				for (String packageNamePart : packageNameParts) {
					
					// if it is longer than 3 characters, check if a similar url
					// host exists
					if (packageNamePart.length() > 3) {

						String[] host = uri.getHost().split("\\.");
						String[] domain = Arrays.copyOf(host, host.length - 1);
						
						int similarity = StringAnalyzer.isSimilar(String.join(".", domain), packageNamePart);
						double similarityScore = 1.0
								- (double) similarity / (double) Math.max(url.url.length(), packageNamePart.length());

						// URL hit, this is similar to package name
						if (similarityScore > 0.9) {

							result.found = true;
							result.probability = similarityScore;
							result.snippets.add(url.snippet);

							return result;
						}
					}
				}

			} catch (URISyntaxException e) {
			}
		}

		// if no similar URL was found, there is still a chance, that the app
		// somehow sends data to an app provider server, via IP or other
		// obfuscation methods
		return new StrategyResult(0.2, false);
	}
}

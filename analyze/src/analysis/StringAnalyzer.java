package analysis;

public class StringAnalyzer {

	/**
	 * Checks if a string is similar to another string by first checking if the
	 * find parameter is within the origin string, or how similar the two
	 * strings are, the smaller the returning integer, the more simular the two
	 * strings are
	 * 
	 * @param origin
	 * @param find
	 * @return
	 */
	public static int isSimilar(String origin, String find) {

		if (origin.toLowerCase().contains(find.toLowerCase())) {
			return 0;
		}

		return StringAnalyzer.levenshteinDistance(origin, find);
	}

	/**
	 * Calculates the Levenshtein distance between two strings Returns the
	 * number of permutations necessary to transform string 1 into string 2
	 * http://stackoverflow.com/a/26440076/874508
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static int levenshteinDistance(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		int[] costs = new int[s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {

			int lastValue = i;
			for (int j = 0; j <= s2.length(); j++) {

				if (i == 0) {
					costs[j] = j;
				} else {

					if (j > 0) {
						int newValue = costs[j - 1];
						if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
							newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
						}
						costs[j - 1] = lastValue;
						lastValue = newValue;
					}
				}
			}

			if (i > 0) {
				costs[s2.length()] = lastValue;
			}
		}

		return costs[s2.length()];
	}
}

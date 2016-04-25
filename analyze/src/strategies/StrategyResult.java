package strategies;

import java.util.LinkedList;

import analysis.Snippet;

/**
 * The result that a strategy can return
 * @author Thomas Brüggemann
 *
 */
public class StrategyResult {
	public double probability = 0.0;
	public boolean found = false;
	public LinkedList<Snippet> snippets = new LinkedList<Snippet>();

	public StrategyResult(double confidence, boolean found, LinkedList<Snippet> snippets) {
		this.probability = confidence;
		this.found = found;
		this.snippets = snippets;
	}

	public StrategyResult(double confidence, boolean found) {
		this.probability = confidence;
		this.found = found;
		this.snippets = null;
	}

	public StrategyResult() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String result = "Found: " + this.found + "\n";
		result += "Probability: " + this.probability + "\n\n";

		if (this.snippets != null) {
			for (Snippet snippet : this.snippets) {
				result += snippet.toString() + "\n\n";
			}
		}

		return result;
	}

	/*
	 * Combines multiple instances of StrategyResult together to one
	 */
	public static StrategyResult any(LinkedList<StrategyResult> inputs) {
		StrategyResult result = new StrategyResult();

		int takenInputs = 0;
		double takenProbabilities = 0.0;
		for (StrategyResult r : inputs) {

			// only add results where the probability is
			// higher than nothing
			if (r.probability > 0.0) {

				if (r.snippets != null) {
					result.snippets.addAll(r.snippets);
				}

				takenInputs++;
				takenProbabilities += r.probability;
			}

			if (r.found == true) {
				result.found = true;
			}
		}

		// calculate the average probability for this result
		// if at least one of them was combined
		if (takenInputs > 0) {
			result.probability = takenProbabilities / takenInputs;
		}

		return result;
	}
}

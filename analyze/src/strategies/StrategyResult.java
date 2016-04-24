package strategies;

import java.util.LinkedList;

import analysis.Snippet;

/**
 * The result that a strategy can return
 * @author Thomas Brüggemann
 *
 */
public class StrategyResult {
	public double confidence;
	public LinkedList<Snippet> snippets;

	public StrategyResult(double confidence, LinkedList<Snippet> snippets) {
		this.confidence = confidence;
		this.snippets = snippets;
	}

	public StrategyResult(double confidence) {
		this.confidence = confidence;
		this.snippets = null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String result = "Propability: " + this.confidence + "\n\n";

		if (this.snippets != null) {
			for (Snippet snippet : this.snippets) {
				result += snippet.toString() + "\n\n";
			}
		}

		return result;
	}
}

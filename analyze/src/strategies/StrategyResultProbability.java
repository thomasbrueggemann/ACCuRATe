package strategies;

public enum StrategyResultProbability {
	LOW(0.0), MEDIUM(0.5),
	HIGH(1.0);
	
	private final double probabilityCode;
	
	/**
	 * Privately init the enum with a value
	 * 
	 * @param probabilityCode
	 */
	StrategyResultProbability(double probabilityCode) {
		this.probabilityCode = probabilityCode;
	}
	
	/**
	 * Return the probability of the enum value
	 * 
	 * @return
	 */
	public double getProbability() {
		return this.probabilityCode;
	}

	/**
	 * Return the StrategyResultProbability from a double value between 0 and 1
	 * 
	 * @param input
	 * @return
	 */
	static StrategyResultProbability fromDouble(double input) {
		double regulatedInput = 0.5 * Math.round(input / 0.5);
		if (regulatedInput == 0.0)
			return StrategyResultProbability.LOW;
		else if (regulatedInput == 0.5)
			return StrategyResultProbability.MEDIUM;
		else
			return StrategyResultProbability.HIGH;
	}
}
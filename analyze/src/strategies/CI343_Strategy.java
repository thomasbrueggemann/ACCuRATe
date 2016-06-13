package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI343 STRATEGY HealthContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI343_Strategy extends Strategy {

	/*
	 * Following the health input categories by Brüggemann, T., Hansen, J.,
	 * Dehling, T., & Sunyaev, A. (2016). An Information Privacy Risk Index for
	 * mHealth Apps.
	 * 
	 * @see strategies.Strategy#execute()
	 */
	@Override
	public StrategyResult execute() {
		
		InputInformationCollectionStrategy ics = new InputInformationCollectionStrategy();
		ics.app = this.app;
		ics.params.put("identifiers", new LinkedList<String>(
				Arrays.asList("dosage", "pill", "blood", "heart", "bloodpressure", "bloodsugar", "heartrate", "disease",
						"symptom", "weight", "height", "body", "bmi", "temperature", "medical", "doctor", "calories",
						"diet", "sleep", "carbon", "hydrate", "intake")));
		
		return ics.execute();
	}
}

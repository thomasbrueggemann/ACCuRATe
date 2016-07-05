package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI341 STRATEGY DemographicsContentDerived from
 * https://www.destatis.de/DE/Methoden/DemografischeRegionaleStandards/
 * Fragebogen_schriftlich.pdf?__blob=publicationFile
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI341_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.Strategy#execute()
	 */
	@Override
	public StrategyResult execute() {
		
		InputInformationCollectionStrategy ics = new InputInformationCollectionStrategy();
		ics.app = this.app;
		ics.params.put("identifiers", new LinkedList<String>(
				Arrays.asList("sex", "male", "female", "birth", "born", "citizen", "familiy", "marital", "education",
						"employed", "employee", "job", "occupation", "income", "citizenship", "age", "year")));
		
		return ics.execute();
	}
}

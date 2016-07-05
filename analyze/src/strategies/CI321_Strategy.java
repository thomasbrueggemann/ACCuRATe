package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI321 STRATEGY FinancialIdentifierContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI321_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.TraceBackStrategy#execute()
	 */
	@Override
	public StrategyResult execute() {
		
		InputInformationCollectionStrategy ics = new InputInformationCollectionStrategy();
		ics.app = this.app;
		ics.params.put("identifiers", new LinkedList<String>(
				Arrays.asList("creditcard", "cvc", "iban", "bic", "bankaccount", "bank", "mastercard", "paypal",
						"visa")));
		
		return ics.execute();
	}
}

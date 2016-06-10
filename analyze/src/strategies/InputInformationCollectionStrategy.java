package strategies;

import java.util.Arrays;
import java.util.LinkedList;

import analysis.EditTextMeta;

/**
 * INPUT INFORMATION COLLECTION STRATEGY is the acquisition and storage/sending
 * out of information inputted by the user into text fields
 * 
 * @author Thomas Brüggemann
 *
 */
public class InputInformationCollectionStrategy extends Strategy {

	@SuppressWarnings("unchecked")
	@Override
	public StrategyResult execute() {

		if (!this.params.containsKey("identifiers")) {
			return null;
		}

		LinkedList<String> identifiers = (LinkedList<String>) this.params.get("identifiers");
		// trace back creditcard etc identifier throughout the source code
		TraceBackStrategy tbs = new TraceBackStrategy();
		tbs.app = this.app;

		// Check if there is video collection going on in the callgraph up
		// to an information collection sink
		tbs.params.put("startSink", TraceBackStrategy.INFORMATION_COLLECTION_SINKS);
		tbs.params.put("searchFor", identifiers);

		StrategyResult tbsResult = tbs.execute();

		// check if there are identifiers that look like financial identifiers
		InputStrategy is = new InputStrategy();
		is.app = this.app;

		StrategyResult isResult = is.execute();

		// find all input tags whose meta content contains some financial
		// identifier
		LinkedList<EditTextMeta> metaTexts = InputStrategy.searchMetaFor(isResult, identifiers);
		LinkedList<String> financialMetaIdTargets = new LinkedList<String>();

		for (EditTextMeta metaText : metaTexts) {
			financialMetaIdTargets.add(metaText.Id);
		}

		// now check if these text identifiers are part of a information
		// collection process by backtracing them
		TraceBackStrategy tbsFinancialMeta = new TraceBackStrategy();
		tbsFinancialMeta.app = this.app;
		tbsFinancialMeta.params.put("startSink", TraceBackStrategy.INFORMATION_COLLECTION_SINKS);
		tbsFinancialMeta.params.put("searchFor", financialMetaIdTargets);

		StrategyResult tbsFinancialMetaResult = new StrategyResult();

		// combine results
		return StrategyResult.any(new LinkedList<StrategyResult>(Arrays.asList(tbsResult, tbsFinancialMetaResult)));
	}
}

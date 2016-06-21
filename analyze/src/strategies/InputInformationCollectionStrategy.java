package strategies;

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

		// check if there are identifiers that look like the parameter
		// identifiers
		InputStrategy is = new InputStrategy();
		is.app = this.app;

		StrategyResult isResult = is.execute();

		// find all input tags whose meta content contains an identifier
		LinkedList<EditTextMeta> metaTexts = InputStrategy.searchMetaFor(isResult, identifiers);
		LinkedList<String> metaIdTargets = new LinkedList<String>();

		for (EditTextMeta metaText : metaTexts) {
			metaIdTargets.add(metaText.Id);
		}

		// now check if these text identifiers are part of a information
		// collection process by backtracing them
		TraceBackStrategy tbsMeta = new TraceBackStrategy();
		tbsMeta.app = this.app;
		tbsMeta.params.put("startSink", TraceBackStrategy.INFORMATION_COLLECTION_SINKS);
		tbsMeta.params.put("searchFor", metaIdTargets);

		return tbsMeta.execute();
	}
}

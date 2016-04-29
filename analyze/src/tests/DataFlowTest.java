package tests;

import static com.google.common.truth.Truth.assertThat;

import analysis.App;
import analysis.DataFlow;
import soot.jimple.infoflow.results.InfoflowResults;

public class DataFlowTest {

	public DataFlowTest() {

		App app = new App("tests/allfine");
		DataFlow flow = new DataFlow(app);

		InfoflowResults result = flow.analyze();
		assertThat(result).isNotNull();
	}
}

package tests;

import static com.google.common.truth.Truth.assertThat;

import analysis.App;
import soot.jimple.infoflow.results.InfoflowResults;

public class DataFlowTest {

	public DataFlowTest() {

		App app = new App("tests/allfine");
		InfoflowResults result = app.getDataFlows();

		assertThat(result).isNotNull();
		System.out.println(result.toString());
	}
}

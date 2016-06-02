package tests;

import static com.google.common.truth.Truth.assertThat;

import analysis.App;
import soot.jimple.infoflow.results.xml.SerializedInfoflowResults;

public class DataFlowTest {

	public DataFlowTest() {

		App app = new App("data/com.goodrx");
		SerializedInfoflowResults result = app.parseDataFlows();

		assertThat(result).isNotNull();
		assertThat(result.getResultCount() > 0).isTrue();

		System.out.println(result.getResults().toString());
	}
}

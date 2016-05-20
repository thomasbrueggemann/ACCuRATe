package tests;

import static com.google.common.truth.Truth.assertThat;

import analysis.App;
import dataflow.Results;

public class DataFlowTest {

	public DataFlowTest() {

		App app = new App("data/com.goodrx");
		Results result = app.parseDataFlows();

		assertThat(result).isNotNull();
		System.out.println(result.toString());
	}
}

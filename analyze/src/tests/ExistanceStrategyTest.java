package tests;

import static com.google.common.truth.Truth.assertThat;

import java.util.LinkedList;

import analysis.App;
import strategies.ExistanceStrategy;
import strategies.StrategyResult;

public class ExistanceStrategyTest extends ExistanceStrategy {

	@SuppressWarnings("deprecation")
	public ExistanceStrategyTest() {

		this.app = new App("data/com.goodrx");

		LinkedList<String> searchFor = new LinkedList<String>();
		searchFor.add("for");

		this.params.put("searchFor", searchFor);
		StrategyResult result = this.execute();

		assertThat(result).isNotNull();
		assertThat(result.probability).isEqualTo(1.0);
	}
}

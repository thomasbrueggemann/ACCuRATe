package tests;

import static com.google.common.truth.Truth.assertThat;

import analysis.App;
import strategies.ExistanceStrategy;

public class ExistanceStrategyTest extends ExistanceStrategy {

	public ExistanceStrategyTest() {

		this.app = new App("tests/allfine");
		this.params.put("searchFor", "for");
		double result = this.execute();

		assertThat(result).isEqualTo(1.0);
	}
}

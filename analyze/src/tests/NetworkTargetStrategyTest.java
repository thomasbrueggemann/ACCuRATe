package tests;

import static com.google.common.truth.Truth.assertThat;

import analysis.App;
import strategies.NetworkTargetStrategy;
import strategies.StrategyResult;

public class NetworkTargetStrategyTest {

	@SuppressWarnings("deprecation")
	public NetworkTargetStrategyTest() {

		App app = new App("data/com.goodrx");
		app.parseDataFlows();

		NetworkTargetStrategy nts = new NetworkTargetStrategy();
		nts.app = app;
		StrategyResult result = nts.execute();

		assertThat(result).isNotNull();
		assertThat(result.probability).isEqualTo(1.0);
	}
}

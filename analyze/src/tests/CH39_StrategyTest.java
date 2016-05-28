package tests;

import analysis.App;
import strategies.CH39_Strategy;
import strategies.StrategyResult;

public class CH39_StrategyTest {
	public CH39_StrategyTest() {

		App a = new App("data/com.goodrx");
		a.extractAppUrls();

		CH39_Strategy s = new CH39_Strategy();
		s.app = a;

		StrategyResult r = s.execute();
	}
}

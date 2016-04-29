import tests.AppTest;
import tests.DataFlowTest;
import tests.ExistanceStrategyTest;
import tests.FileScannerTest;

public class Tests {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("=== AIPRAT: Tests ===");

		AppTest at = new AppTest();
		FileScannerTest fst = new FileScannerTest();
		ExistanceStrategyTest est = new ExistanceStrategyTest();
		DataFlowTest dft = new DataFlowTest();

		System.out.println("Done.");
	}
}

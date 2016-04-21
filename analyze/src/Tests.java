import tests.AppTest;
import tests.ExistanceStrategyTest;
import tests.FileScannerTest;

public class Tests {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== AIPRAT: Tests ===");

		AppTest at = new AppTest();
		FileScannerTest fst = new FileScannerTest();
		ExistanceStrategyTest est = new ExistanceStrategyTest();

		System.out.println("Done.");
	}
}

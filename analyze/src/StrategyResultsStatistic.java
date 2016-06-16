import java.io.File;

public class StrategyResultsStatistic {

	public static void main(String[] args) {

		// loop files in input directory
		String inputPath = args[0];
		File root = new File(inputPath);
		File[] list = root.listFiles();

		if (list == null) {
			System.out.println("ERROR: No files in input path");
			System.exit(1);
		}

		// loop entries in input path
		for (File f : list) {

			// is a json file?
			if (f.isFile() && f.getName().endsWith(".json")) {

			}
		}
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.LinkedList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import analysis.APKResult;

public class StrategyResultsStatistic {

	public static void main(String[] args) {

		// loop files in input directory
		String inputPath = args[0];
		File root = new File(inputPath);
		File[] list = root.listFiles();
		
		LinkedList<String> hierarchies = new LinkedList<String>();
		LinkedList<APKResult> apkResults = new LinkedList<APKResult>();

		if (list == null) {
			System.out.println("ERROR: No files in input path");
			System.exit(1);
		}

		// loop entries in input path
		for (File f : list) {

			// is a json file?
			if (f.isFile() && f.getName().endsWith(".json")) {

				APKResult apk = new APKResult();
				apk.name = f.getName().replace(".json", "");

				// read file to string
				byte[] bytes;
				try {
					bytes = Files.readAllBytes(f.toPath());

					JsonElement jelement = new JsonParser().parse(new String(bytes, "UTF-8"));
					JsonArray jarray = jelement.getAsJsonArray();

					// loop all entries of the array
					for (int i = 0; i < jarray.size(); i++) {
						JsonElement strategyElement = jarray.get(i);
						JsonObject strategyObject = strategyElement.getAsJsonObject();

						String hierarchy = strategyObject.get("hierarchy").getAsString();
						
						// store the results
						apk.strategyResults.put(hierarchy,
								strategyObject.get("found").getAsBoolean());
						
						if (!hierarchies.contains(hierarchy)) {
							hierarchies.add(hierarchy);
						}
					}
					
					apkResults.add(apk);

				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}

		String csv = ";";

		// loop all apks
		for (APKResult result : apkResults) {

			csv += result.name + ";";
		}

		csv += "\n";

		// print out csv file with statistics
		for (String hierarchy : hierarchies) {

			String line = hierarchy + ";";
			
			// loop all apks
			for (APKResult result : apkResults) {

				boolean found = result.strategyResults.get(hierarchy);
				if(found == true) line += "1;";
				else
					line += "0;";
			}

			csv += line + "\n";
		}

		// write the csv results
		try (PrintWriter out = new PrintWriter("results_statistics.csv")) {
			out.println(csv);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Done.");
	}
}

import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import analysis.App;
import config.LoadStrategyConfig;
import config.StrategyConfig;
import config.StrategyConfigItem;
import strategies.Strategy;
import strategies.StrategyResult;

public class AIPRAT {
	
	private static String VERSION = "1.0";
	
	/* AIPRAT MAIN */
	public static void main(String[] args) {
		
		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "ERROR");

		if (args.length != 1) {
			System.out.println("Usage: java -jar AIRPRAT.jar inputPath/");
			System.exit(1);
		}

		System.out.println("AIPRAT v" + VERSION);
		System.out.println("===========\n");
		
		// load strategies from config file
		LoadStrategyConfig configLoader = new LoadStrategyConfig();
		StrategyConfig strategyConfig = configLoader.load("strategies.json");
		
		if(strategyConfig != null) {
			
			System.out.println(strategyConfig.strategies.size() + " Strategies loaded!\n");

			// load directories of the input path
			String inputPath = args[0];
			File root = new File(inputPath);
			File[] list = root.listFiles();

			if (list == null) {
				System.out.println("ERROR: No directories in input path");
				System.exit(1);
			}

			// loop entries in input path
			for (File f : list) {

				if (f.isDirectory()) {

					LinkedList<StrategyResult> results = new LinkedList<StrategyResult>();

					App app = new App(f.getAbsolutePath());

					// check if results json already exists
					String resultsFileName = app.path + ".json";
					if (new File(resultsFileName).exists()) {
						continue;
					}

					System.out.println("APP: " + app.path);
					System.out.println("==========");

					// app.parseDataFlows();
					app.extractAppUrls();
					
					try {
						app.getCallGraph();
					}
					catch(RuntimeException re) {
						
						boolean continueWithExec = false;
						LinkedList<String> unsupportedPlatforms = new LinkedList<String>(Arrays.asList("android-1/", "android-2/", "android-3/", "android-4/", "android-5/", "android-6/"));
						for (String unsupportedPlatform : unsupportedPlatforms) {

							if (re.toString().contains(unsupportedPlatform)) {
								continueWithExec = true;
							}
						}

						if (continueWithExec == true) {
							continue;
						} else {
							throw re;
						}
					}

					System.out.println("\n\nApply strategies:");
					System.out.println("====================");

					// this is an app path
					for (StrategyConfigItem strategy : strategyConfig.strategies) {

						System.out.println("Execute: '" + strategy.name + "' Strategy");

						// try to parse and load the class dynamically
						Class<?> dynClass;
						Constructor<?> dynConstructor;

						try {

							// load class dynamically via reflection
							String strategyClassName = "strategies." + strategy.classPrefix + "_Strategy";
							System.out.println(" -> Load '" + strategyClassName + "'");

							dynClass = Class.forName(strategyClassName);
							dynConstructor = dynClass.getConstructor();
							Strategy dynStrategy = (Strategy) dynConstructor.newInstance();

							// store the strategy configuration inside the class
							dynStrategy.setConfig(strategy);

							// set and calculate app data flows
							dynStrategy.app = app;

							// execute strategy
							StrategyResult result = dynStrategy.execute();
							result.name = strategy.name;
							result.hierarchy = strategy.classPrefix;

							results.add(result);
							System.out.println(result.toString());


						} catch (ClassNotFoundException | NoSuchMethodException | SecurityException
								| InstantiationException | IllegalAccessException | IllegalArgumentException
								| InvocationTargetException e) {

							// System.out.println("ERROR: Could not load
							// strategy class dynamically by its name");
							e.printStackTrace();
							System.exit(1);
						}
					}

					// write results to file
					try {
						Gson gson = new GsonBuilder().setPrettyPrinting().create();
						String json = gson.toJson(results);

						PrintWriter out = new PrintWriter(resultsFileName);
						out.println(json);
						out.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		System.out.println("DONE!");
		System.exit(0);
	}
}

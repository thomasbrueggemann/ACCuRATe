import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

					App app = new App(f.getAbsolutePath());
					app.parseDataFlows();
					// too slow: app.analyzeDataFlows();
					app.extractAppUrls();

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
				}
			}
		}
		
		System.out.println("Done!");
		System.exit(0);
	}
}

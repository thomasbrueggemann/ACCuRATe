import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import config.LoadStrategyConfig;
import config.StrategyConfig;
import config.StrategyConfigItem;
import strategies.Strategy;

public class AIPRAT {
	
	private static String VERSION = "1.0";
	
	/* AIPRAT MAIN */
	public static void main(String[] args) {
		
		System.out.println("AIPRAT v" + VERSION);
		System.out.println("===========\n");
		
		// load strategies from config file
		LoadStrategyConfig configLoader = new LoadStrategyConfig();
		StrategyConfig strategyConfig = configLoader.load("strategies.json");
		
		if(strategyConfig != null) {
			
			System.out.println("Strategies loaded!\n");
			for(StrategyConfigItem strategy : strategyConfig.strategies) {
				
				System.out.println("Execute: '" + strategy.name + "' Strategy");
				
				// try to parse and load the class dynamically
				Class<?> dynClass;
				Constructor<?> dynConstructor;
				
				try {
					
					// load class dynamically via reflection
					String strategyClassName = "strategies." + strategy.classPrefix + "_Strategy";
					System.out.println("Load '" + strategyClassName + "'");
					
					dynClass = Class.forName(strategyClassName);
					dynConstructor = dynClass.getConstructor();
					Strategy dynStrategy = (Strategy)dynConstructor.newInstance();
					
					// store the strategy configuration inside the class
					dynStrategy.setConfig(strategy);
					
					// execute strategy
					double result = dynStrategy.execute();
					System.out.println(result);
					
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					
					//System.out.println("ERROR: Could not load strategy class dynamically by its name");
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
		
		System.exit(0);
	}
}

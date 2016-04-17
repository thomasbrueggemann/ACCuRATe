package config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

/**
 * LOAD STRATEGY CONFIG
 * @author Thomas Brüggemann
 * 
 * Loads the strategies config from a JSON
 * file and return the config object
 */
public class LoadStrategyConfig {

	/**
	 * @param path
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	private String readFile(String path, Charset encoding) 
			  throws IOException {
		
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
	
	/**
	 * @param path
	 * @return
	 */
	public StrategyConfig load(String path) {
		
		// read config file to string
		String configJson = "";
		try {
			configJson = this.readFile(path, Charset.defaultCharset());
		} catch (IOException e) {
			System.out.println("ERROR: Config file path '" + path + "' could not be found.");
			System.exit(1);
		}
		
		// the config file has content
		if(configJson.length() > 0) {

			Gson gson = new Gson();
			
			// parse content from json string
			StrategyConfig conf = gson.fromJson(configJson, StrategyConfig.class);
			if(conf != null) {
				return conf;
			}
		}
		
		return null;
	}
}

package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CH21 STRATEGY SecurityDuringProcessingContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CH21_Strategy extends ExistanceStrategy {

	@Override
	public StrategyResult execute() {

		// Check if there is crypting or ciphering within the source code
		this.params.put("searchFor", new LinkedList<String>(Arrays.asList("crypt", "cipher")));

		return super.execute();
	}
}

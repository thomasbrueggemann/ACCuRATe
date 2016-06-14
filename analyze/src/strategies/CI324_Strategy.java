package strategies;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * CI324 STRATEGY OnlineContactContent
 * 
 * @author Thomas Brüggemann
 *
 */
public class CI324_Strategy extends Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategies.TraceBackStrategy#execute()
	 */
	@Override
	public StrategyResult execute() {
		
		InputInformationCollectionStrategy ics = new InputInformationCollectionStrategy();
		ics.app = this.app;
		ics.params.put("identifiers", new LinkedList<String>(
				Arrays.asList("email", "mail", "icq", "skype", "irc", "whatsapp", "facebook", "twitter", "google",
						"phone", "chat", "jabber")));
		
		return ics.execute();
	}
}

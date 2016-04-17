import java.util.LinkedList;

import strategies.*;

public class AIPRAT {
	
	private static String VERSION = "1.0";
	
	/* AIPRAT MAIN */
	public static void main(String[] args) {
		System.out.println("AIPRAT v" + VERSION);
		
		// Strategies to run
		LinkedList<Strategy> strategies = new LinkedList<Strategy>();
		strategies.add(new CH35_Strategy());
	}
}

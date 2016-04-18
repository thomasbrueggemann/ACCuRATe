package analysis;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileScanner {

	private String path;
	
	/**
	 * FILE SCANNER
	 * @param path
	 */
	public FileScanner(String path) {
		this.path = path;
	}
	
	/**
	 * SCAN
	 * @param forText
	 */
	public LinkedList<Snippet> scan(String forText) throws FileNotFoundException {
		
		// init return snippets
		LinkedList<Snippet> snippets = new LinkedList<Snippet>();
		
		Scanner scanner = new Scanner(this.path);

		// now read the file line by line...
		int lineNum = 0;
		while (scanner.hasNextLine()) {
			
		    String line = scanner.nextLine();
		    lineNum++;
		    
		    if(line.contains(forText)) { 
		        Snippet snippet = new Snippet(line, lineNum);
		        snippets.add(snippet);
		    }
		}
		
		scanner.close();
		
		return snippets;
	}
}

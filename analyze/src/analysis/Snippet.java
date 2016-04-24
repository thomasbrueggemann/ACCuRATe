package analysis;

/**
 * Represents a code snippet from a file
 * 
 * @author Thomas Brüggemann
 *
 */
public class Snippet {
	private int lineNumber;
	private String file;
	private String line;
	
	/*
	 * Constructor
	 */
	public Snippet(String file, String line, int lineNumber) {
		this.lineNumber = lineNumber;
		this.line = line;
		this.file = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + this.file + ":" + this.lineNumber + "]\n\t" + this.line;
	}
}

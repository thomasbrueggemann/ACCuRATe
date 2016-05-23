package analysis;

import java.util.HashMap;

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
	public HashMap<String, Object> extra = new HashMap<String, Object>();
	
	/*
	 * Constructor
	 */
	public Snippet(String file, String line, int lineNumber) {
		this.lineNumber = lineNumber;
		this.line = line.replaceAll("\t", "");
		this.file = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String val = "[" + this.file + ":" + this.lineNumber + "]\n\t" + this.line;

		if (!this.extra.isEmpty()) {
			val += "\n\tExtra: " + this.extra.toString();
		}

		val += "\n";

		return val;
	}

	/**
	 * EXTRACT URL
	 */
	public String extractURL() {

		// first split by equal sign
		String[] assignmentParts = this.line.split("=");
		String rightSideAssignment = assignmentParts[assignmentParts.length - 1];

		this.extra.put("url", rightSideAssignment);
		return rightSideAssignment;
	}
}

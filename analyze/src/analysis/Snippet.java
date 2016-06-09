package analysis;

import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a code snippet from a file
 * 
 * @author Thomas Brüggemann
 *
 */
public class Snippet {
	private int lineNumber = -1;
	private String file;
	private String line;
	public HashMap<String, Object> extra = new HashMap<String, Object>();
	
	// Pattern for recognizing a URL, based off RFC 3986
	// (http://stackoverflow.com/a/5713866/874508)
	private static final Pattern urlPattern = Pattern.compile(
			"(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)" + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
					+ "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
			Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

	/*
	 * Constructor
	 */
	public Snippet(String file, String line, int lineNumber) {
		this.lineNumber = lineNumber;
		this.line = line.replaceAll("\t", "");
		this.file = file;
	}
	public Snippet(String line) {
		this.line = line.replaceAll("\t", "");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		String val = "";
		if (this.file != null) {
			val += "[" + this.file + ":" + this.lineNumber + "]\n\t";
		}

		val += this.line.replace("\t\t", "\t");

		if (!this.extra.isEmpty()) {
			val += "\n\tExtra: " + this.extra.toString();
		}

		val += "\n";

		return val;
	}

	/**
	 * EXTRACT URL attempts to extract an url from a snippet line
	 * 
	 * @return the potential url
	 */
	public String extractURL() {

		String url = "";
		boolean foundMatch = false;
		
		// try the regex matcher first
		Matcher matcher = urlPattern.matcher(this.line);
		while (matcher.find()) {
		    int matchStart = matcher.start(1);
		    int matchEnd = matcher.end();
		    
			url = this.line.substring(matchStart, matchEnd);

			foundMatch = true;
			break;
		}

		// no direct match found? approximate one!
		if (!foundMatch) {
			int httpPos = this.line.indexOf("http");

			// try to extract a more precise part of the url
			if (httpPos >= 0) {
				url = this.line.substring(httpPos, this.line.length() - 2);
			} else {
				url = this.line;
			}
		}

		// is there an url? store and return it
		if (url.length() > 0) {

			// store url
			this.extra.put("url", url);
			this.extractHostFromURL();
			return url;
		}

		return null;
	}
	
	/**
	 * EXTRACT HOST FROM URL tries to extract the host part of the url if one
	 * exists
	 */
	private void extractHostFromURL() {
		try {
			if (this.extra.containsKey("url")) {

				// try to parse the url into the url object of java
				URL url = new URL((String) this.extra.get("url"));
				if (url.getHost().length() != 0) {

					// store the host in this snippet
					this.extra.put("host", url.getHost());
				}
			}
		} catch (Exception e) {

		}
	}
}

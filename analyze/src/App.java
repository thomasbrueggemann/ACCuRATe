import java.io.File;
import java.util.LinkedList;

/**
 * APP
 * 
 * @author Thomas Brüggemann Represents an app directory
 */
public class App {
	public String path;

	public App(String path) {
		this.path = path;
	}

	/**
	 * GET ALL SOURCE FILES
	 * 
	 * @return Returns a list of all file paths that are included in this app
	 *         directory
	 */
	public LinkedList<String> getAllSourceFiles() {

		// walk down the path
		return walkFiles(this.path, ".java");
	}

	private LinkedList<String> walkFiles(String path, String filter) {

		LinkedList<String> results = new LinkedList<String>();

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return results;

		for (File f : list) {
			if (f.isDirectory()) {

				// recursively walk down the directories and append
				// to top level results list
				results.addAll(this.walkFiles(f.getAbsolutePath(), filter));
			} else {

				// only include file if it meets filter criteria
				if (f.getName().contains(filter)) {

					results.add(f.getAbsolutePath());
				}
			}
		}

		return results;
	}
}

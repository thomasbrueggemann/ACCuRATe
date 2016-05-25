import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PrepareURLFiles {

	public static void main(String[] args) {

		File root = new File("src/analysis/urls/training/");
		File[] list = root.listFiles();

		if (list != null) {
			for (File f : list) {
				if (f.isFile() && !f.getName().startsWith(".|-")) {

					String category = f.getName();
					System.out.println("Category: " + category);
					Scanner scanner = null;
					Set<String> lines = new HashSet<String>();

					// open url file and loop lines
					try {
						scanner = new Scanner(f);

						// loop lines of training file
						while (scanner.hasNextLine()) {
							lines.add(scanner.nextLine());
						}

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} finally {

						// close scanner if open
						if (scanner != null) {
							scanner.close();
						}
					}

					// download descriptions of url lines file in parallel
					Map<String, String> descriptions = new ConcurrentHashMap<>();
					lines.parallelStream().forEach((line) -> {

						String description = downloadDescription(line);
						if (description != null && description.length() > 5) {
							descriptions.put(line, description);
						}
					});

					// try to write results into file
					try (Writer writer = new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream("src/analysis/urls/training/" + category + ".csv"),
									"utf-8"))) {
						
						// write descriptions to csv file
						for (Map.Entry<String, String> entry : descriptions.entrySet()) {
							writer.write(entry.getValue() + "\n");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static String downloadDescription(String url) {

		// prepend http if necessary
		if (!url.startsWith("http")) {
			url = "http://" + url;
		}

		try {
			// extract description meta tag
			Document doc = Jsoup.connect(url).get();
			String desc = getMetaTag(doc, "description");
			if (desc == null || desc.length() <= 2) {
				return null;
			}

			return desc;

		} catch (Exception e) {
		}

		return null;
	}

	private static String getMetaTag(Document document, String attr) {
		Elements elements = document.select("meta[name=" + attr + "]");
		for (Element element : elements) {
			final String s = element.attr("content");
			if (s != null)
				return s;
		}
		elements = document.select("meta[property=" + attr + "]");
		for (Element element : elements) {
			final String s = element.attr("content");
			if (s != null)
				return s;
		}
		return null;
	}
}

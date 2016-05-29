import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PrepareURLFiles {

	public static void main(String[] args) throws IOException {

		downloadAPIs("aggregation", "aggregation");
		downloadAPIs("shipping", "delivery");
		train();
	}

	private static void downloadAPIs(String category, String storeAs) throws IOException {

		boolean pageHasContent = true;
		int page = 1;
		LinkedList<String> apiUrls = new LinkedList<String>();

		// download pages as long as there is content
		do {

			String url = "http://www.programmableweb.com/category/" + category
					+ "/api?pw_view_display_id=apis_all&page="
					+ page;

			Document doc = Jsoup.connect(url).get();

			// check if page is empty
			Elements emptyView = doc.select(".view-empty");
			if (!emptyView.isEmpty()) {
				pageHasContent = false;
			} else {

				// loop api titles
				Elements titles = doc.select(".views-field-title");
				for (Element title : titles) {
					Elements apiAnchors = title.select("a");
					if (apiAnchors.size() > 0 && apiAnchors.get(0).attr("href").startsWith("/api")) {

						// save api url
						apiUrls.add("http://www.programmableweb.com" + apiAnchors.get(0).attr("href"));
					}
				}

				// increment to next page
				page++;
			}

		} while (pageHasContent == true);

		// download api urls in parallel
		Queue<String> apiUrlNames = new ConcurrentLinkedQueue<String>();
		apiUrls.parallelStream().forEach((url) -> {

			try {
				String name = downloadAPI(url);
				if(name != null) {
					apiUrlNames.add(name);
				}

			} catch (Exception e) {
			}
		});

		LinkedList<String> alreadyAdded = new LinkedList<String>();
		
		// try to write results into file
		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("src/analysis/urls/training/" + storeAs), "utf-8"))) {

			// write descriptions to csv file
			for (String apiName : apiUrlNames) {
				String n = apiName.replace("http://", "").replace("https://", "").replace("www.", "");
				if (n.endsWith("/")) {
					n = n.substring(0, n.length() - 1);
				}

				if (n.contains("/")) {
					n = n.split("/")[0];
				}

				if (!alreadyAdded.contains(n)) {
					System.out.println(n);
					writer.write(n + "\n");
					alreadyAdded.add(n);
				}
			}

			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done.");
	}

	/**
	 * Downloads the information of a single API url
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	private static String downloadAPI(String url) throws IOException {

		Document doc = Jsoup.connect(url).get();

		// loop all field classes
		for (Element field : doc.select(".field")) {
			if (field.html().contains("API Provider")) {

				// select the first anchor
				Elements anchors = field.select("a");
				if (anchors.size() > 0) {
					return anchors.get(0).attr("href");
				}
			}
		}

		return null;
	}


	private static void train() {
		File root = new File("src/analysis/urls/training/");
		File[] list = root.listFiles();

		if (list != null) {
			for (File f : list) {
				if (f.isFile() && !f.getName().startsWith(".")) {

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
									new FileOutputStream("src/analysis/urls/training/" + category + ".train"),
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

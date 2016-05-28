import java.io.IOException;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PrepareMLFiles {

	/**
	 * Prepares all machine learning files necessary to process the static code
	 * analysis
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// Download "Aggregation" APIs
		downloadAggregationAPIs();
	}

	private static void downloadAggregationAPIs() throws IOException {
		
		boolean pageHasContent = true;
		int page = 1;
		LinkedList<String> apiUrls = new LinkedList<String>();
		
		// download pages as long as there is content
		do {

			String url = "http://www.programmableweb.com/category/aggregation/api?pw_view_display_id=apis_all&page="
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
	}

	/**
	 * Downloads the information of a single API url
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	private static LinkedList<String> downloadAPI(String url) throws IOException {

		Document doc = Jsoup.connect(url).get();
		return null;

	}
}

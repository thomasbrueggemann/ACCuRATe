package strategies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import analysis.EditTextMeta;
import analysis.FileScanner;
import analysis.Snippet;

public class InputStrategy extends Strategy {

	@Override
	public StrategyResult execute() {

		// first, check all layout files
		LinkedList<String> files = this.app.getAllLayoutXMLFiles();
		LinkedList<EditTextMeta> metaInfos = new LinkedList<EditTextMeta>();
		LinkedList<Snippet> snippets = new LinkedList<Snippet>();
		
		for (String file : files) {

			FileScanner scanner = new FileScanner(file);

			try {

				// scan files for a input textboxes of any kind
				snippets.addAll(scanner.scan("EditText"));
				snippets.addAll(scanner.scan("AutoCompleteTextView"));

				// EditText is in this file! Let's step into it further
				if (snippets.size() > 0) {

					// extract more information
					metaInfos.addAll(this.extractInputMeta(file));
				}

			} catch (FileNotFoundException e) {
			}
		}

		// did we find anything?
		if (metaInfos.size() > 0) {
			StrategyResult result = new StrategyResult(StrategyResultProbability.HIGH, true, snippets);
			result.extra.put("meta", metaInfos);

			return result;
		} else {
			return new StrategyResult(StrategyResultProbability.HIGH, false);
		}
	}

	/*
	 * EXTRACT INPUT META data tries to gather the id and type of a
	 */
	private LinkedList<EditTextMeta> extractInputMeta(String fileName) {

		LinkedList<EditTextMeta> results = new LinkedList<EditTextMeta>();

		try {

			// open and parse xml file
	        File fXmlFile = new File(fileName);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory
	                .newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(fXmlFile);
	        doc.getDocumentElement().normalize();

			// loop all EditText elements
			LinkedList<String> tagNames = new LinkedList<String>(Arrays.asList("EditText", "AutoCompleteTextView"));
			for (String tagName : tagNames) {
				results.addAll(this.extractInputMetaAttributes(doc, tagName));
			}


	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return results;
	}

	/**
	 * EXTRACT INPUT META ATTRIBUTES
	 * 
	 * @param doc
	 * @param tagName
	 */
	private LinkedList<EditTextMeta> extractInputMetaAttributes(Document doc, String tagName) {

		LinkedList<EditTextMeta> results = new LinkedList<EditTextMeta>();
		NodeList textInputs = doc.getElementsByTagName(tagName);

		for (int i = 0; i < textInputs.getLength(); i++) {

			Node nNode = textInputs.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				EditTextMeta etm = new EditTextMeta();

				// hint
				if (eElement.hasAttribute("android:hint")) {
					String[] hint = eElement.getAttribute("android:hint").split("/");
					etm.Hint = hint[hint.length - 1];
				}

				// id
				if (eElement.hasAttribute("android:id")) {
					String[] id = eElement.getAttribute("android:id").split("/");
					etm.Id = id[id.length - 1];
				}

				// type
				if (eElement.hasAttribute("android:inputType")) {
					String[] type = eElement.getAttribute("android:inputType").split("/");
					etm.Type = type[type.length - 1];
				}

				results.add(etm);
			}
		}

		return results;
	}
}

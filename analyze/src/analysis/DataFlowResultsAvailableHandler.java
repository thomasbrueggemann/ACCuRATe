package analysis;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import soot.jimple.infoflow.handlers.ResultsAvailableHandler;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.results.xml.InfoflowResultsSerializer;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

final class DataFlowResultsAvailableHandler implements ResultsAvailableHandler {

	private App app;

	DataFlowResultsAvailableHandler(App app) {
		this.app = app;
	}

	@Override
	public void onResultsAvailable(IInfoflowCFG cfg, InfoflowResults results) {

		// dump the results
		if (results == null) {
			System.out.println("No results found.");
		} else {

			// write results to file
			String resultFilePath = this.app.path + ".dataflow";

			// serialize the results
			// write the results into a file
			if (resultFilePath != null && !resultFilePath.isEmpty()) {

				InfoflowResultsSerializer serializer = new InfoflowResultsSerializer(cfg);
				try {
					serializer.serialize(results, resultFilePath);
				} catch (FileNotFoundException ex) {
					System.err.println("Could not write data flow results to file: " + ex.getMessage());
					ex.printStackTrace();
					throw new RuntimeException(ex);
				} catch (XMLStreamException ex) {
					System.err.println("Could not write data flow results to file: " + ex.getMessage());
					ex.printStackTrace();
					throw new RuntimeException(ex);
				}
			}
		}

	}
}

package analysis;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.stream.XMLStreamException;

import soot.jimple.infoflow.handlers.ResultsAvailableHandler;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.results.ResultSinkInfo;
import soot.jimple.infoflow.results.ResultSourceInfo;
import soot.jimple.infoflow.results.xml.InfoflowResultsSerializer;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

final class DataFlowResultsAvailableHandler implements ResultsAvailableHandler {
	private final BufferedWriter wr;

	DataFlowResultsAvailableHandler() {
		this.wr = null;
	}

	DataFlowResultsAvailableHandler(BufferedWriter wr) {
		this.wr = wr;
	}

	@Override
	public void onResultsAvailable(IInfoflowCFG cfg, InfoflowResults results) {
		// Dump the results
		if (results == null) {
			print("No results found.");
		} else {
			// Report the results
			for (ResultSinkInfo sink : results.getResults().keySet()) {
				print("Found a flow to sink " + sink + ", from the following sources:");
				for (ResultSourceInfo source : results.getResults().get(sink)) {

					print("\t- " + source.getSource() + " (in " + cfg.getMethodOf(source.getSource()).getSignature()
							+ ")");
					if (source.getPath() != null)
						print("\t\ton Path " + Arrays.toString(source.getPath()));
				}
			}

			String resultFilePath = "/dataflow_results.xml";

			// Serialize the results if requested
			// Write the results into a file if requested
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

	private void print(String string) {
		try {
			System.out.println(string);
			if (wr != null) {
				wr.write(string + "\n");
			}
		} catch (IOException ex) {
			// ignore
		}
	}
}

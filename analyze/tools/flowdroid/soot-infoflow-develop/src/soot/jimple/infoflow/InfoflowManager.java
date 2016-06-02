package soot.jimple.infoflow;

import soot.jimple.infoflow.solver.IInfoflowSolver;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.infoflow.source.ISourceSinkManager;
import soot.jimple.infoflow.taintWrappers.ITaintPropagationWrapper;
import soot.jimple.infoflow.util.TypeUtils;

/**
 * Manager class for passing internal data flow objects to interface
 * implementors
 * 
 * @author Steven Arzt
 *
 */
public class InfoflowManager {
	
	private final InfoflowConfiguration config;
	private IInfoflowSolver forwardSolver;
	private final IInfoflowCFG icfg;
	private final ISourceSinkManager sourceSinkManager;
	private final ITaintPropagationWrapper taintWrapper;
	private final TypeUtils typeUtils;
	
	InfoflowManager(InfoflowConfiguration config,
			IInfoflowSolver forwardSolver,
			IInfoflowCFG icfg,
			ISourceSinkManager sourceSinkManager,
			ITaintPropagationWrapper taintWrapper) {
		this.config = config;
		this.forwardSolver = forwardSolver;
		this.icfg = icfg;
		this.sourceSinkManager = sourceSinkManager;
		this.taintWrapper = taintWrapper;
		this.typeUtils = new TypeUtils(this);
	}
	
	/**
	 * Gets the configuration for this data flow analysis
	 * @return The configuration for this data flow analysis
	 */
	public InfoflowConfiguration getConfig() {
		return this.config;
	}
	
	/**
	 * Sets the IFDS solver that propagates edges forward
	 * @param solver The IFDS solver that propagates edges forward
	 */
	public void setForwardSolver(IInfoflowSolver solver) {
		this.forwardSolver = solver;
	}
	
	/**
	 * Gets the IFDS solver that propagates edges forward
	 * @return The IFDS solver that propagates edges forward
	 */
	public IInfoflowSolver getForwardSolver() {
		return this.forwardSolver;
	}
	
	/**
	 * Gets the interprocedural control flow graph
	 * @return The interprocedural control flow graph
	 */
	public IInfoflowCFG getICFG() {
		return this.icfg;
	}
	
	/**
	 * Gets the SourceSinkManager implementation
	 * @return The SourceSinkManager implementation
	 */
	public ISourceSinkManager getSourceSinkManager() {
		return this.sourceSinkManager;
	}
	
	/**
	 * Gets the taint wrapper to be used for handling library calls
	 * @return The taint wrapper to be used for handling library calls
	 */
	public ITaintPropagationWrapper getTaintWrapper() { 
		return this.taintWrapper;
	}
	
	/**
	 * Gets the utility class for type checks
	 * @return The utility class for type checks
	 */
	public TypeUtils getTypeUtils() {
		return this.typeUtils;
	}
	
}

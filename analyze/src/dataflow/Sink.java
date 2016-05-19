package dataflow;

public class Sink {
	public Statement Statement;
	public AccessPath AccessPath;

	public Sink(Statement statement, AccessPath accessPath) {
		this.Statement = statement;
		this.AccessPath = accessPath;
	}

	/**
	 * TO STRING
	 */
	public String toString() {
		return "Statement: " + this.Statement.toString() + ", AccessPath: " + this.AccessPath.toString();
	}
}

package dataflow;

public class Source {
	public Statement Statement;
	public AccessPath AccessPath;

	public Source(Statement statement, AccessPath accessPath) {
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

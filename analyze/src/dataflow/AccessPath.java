package dataflow;

public class AccessPath {
	public String Value;
	public String Type;
	public Boolean TaintSubFields;

	/**
	 * TO STRING returns the accesspath as a string
	 */
	public String toString() {
		return "(Value: " + this.Value + ", Type: " + this.Type + ", TainSubFields: " + this.TaintSubFields.toString()
				+ ")";
	}
}

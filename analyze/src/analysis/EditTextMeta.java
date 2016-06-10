package analysis;

public class EditTextMeta {
	public String Id;
	public String Hint;
	public String Type;

	/**
	 * CONTAINS checks if one of the meta info fields contains the input string
	 * 
	 * @param input
	 * @return
	 */
	public boolean contains(String input) {
		input = input.toLowerCase();

		return (this.Id.toLowerCase().contains(input) || this.Hint.toLowerCase().contains(input)
				|| this.Type.contains(input));
	}

	/**
	 * TO STRING
	 */
	public String toString() {
		return "Id: " + this.Id + ", Hint: " + this.Hint + ", Type: " + this.Type;
	}
}

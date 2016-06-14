package analysis;

public class EditTextMeta {
	public String Id;
	public String Hint;
	public String Type;
	public String Text;

	/**
	 * CONTAINS checks if one of the meta info fields contains the input string
	 * 
	 * @param input
	 * @return
	 */
	public boolean contains(String input) {
		input = input.toLowerCase();

		boolean idContains = false;
		boolean hintContains = false;
		boolean typeContains = false;
		boolean textContains = false;
		
		// check Id
		if(this.Id != null) {
			idContains = this.Id.toLowerCase().contains(input);
		}
		
		// check Hint
		if(this.Hint != null) {
			hintContains = this.Hint.toLowerCase().contains(input);
		}
		
		// check Type
		if(this.Type != null) {
			typeContains = this.Type.toLowerCase().contains(input);
		}

		// check Text
		if (this.Text != null) {
			textContains = this.Text.toLowerCase().contains(input);
		}

		return (idContains || hintContains || typeContains || textContains);
	}

	/**
	 * TO STRING
	 */
	public String toString() {
		return "Id: " + this.Id + ", Hint: " + this.Hint + ", Type: " + this.Type + ", Text: " + this.Text;
	}
}

package trabalhinho1;

public class InvalidIException extends Exception {

	public InvalidIException(int id) {
		super("ID '" + id + "' not found in list.");
	}
	
}

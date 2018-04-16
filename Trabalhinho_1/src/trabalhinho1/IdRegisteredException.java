package trabalhinho1;

public class IdRegisteredException extends Exception {
	
	public IdRegisteredException(int id) {
		super("ID '" + id + "' already registered.");
	}

}

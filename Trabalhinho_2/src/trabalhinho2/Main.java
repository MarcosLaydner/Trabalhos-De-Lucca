package trabalhinho2;

public class Main {
	
	public static void main(String[] args) {
		Hash hash = new Hash(3, 16);
		hash.insert(4);
		hash.insert(5);
		System.out.println(hash.search(5));
		hash.delete(5);
		System.out.println(hash.search(5));
		
		
		
	}

}

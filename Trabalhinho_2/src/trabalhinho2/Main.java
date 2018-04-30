package trabalhinho2;

public class Main {

	public static void main(String[] args) {
		Hash hash = new Hash(3, 16);
		hash.insert(4);
		hash.insert(5);
		System.out.println(hash.search(5));
		hash.delete(5);
		System.out.println(hash.search(5));
		hash.insert(1);
		hash.insert(5);
		hash.insert(8);
		hash.insert(92);
		hash.insert(2);
		hash.insert(6);
		hash.insert(11);
		hash.insert(93);
		hash.insert(1);
		hash.insert(5);
		hash.insert(10);
		hash.insert(92);
		hash.insert(4);
		hash.insert(7);
		hash.insert(12);
		hash.insert(94);
		
		hash.insert(33);



	}

}

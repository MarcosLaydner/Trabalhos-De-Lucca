package trabalhinho1;

public class Main {
	/*
	 * Autores:
	 * Lucas Varella - 17100914
	 * Marcos Laydner - 17100916
	 */
	public static void main(String[] args) throws Exception {
		OrderedList oList = new OrderedList();
		Person gerso = new Person(1, "gerso");
		CakeClass aCake = new CakeClass(2, true);
		
		oList.orderdInsert(gerso);
		oList.orderdInsert(aCake);
		System.out.println(oList.search(2).getId());
		
		

	}

}

package trabalhinho1;

public class Main {
    /*
     * Autores:
     * Lucas Varella - 17100914
     * Marcos Laydner - 17100916
     */
    public static void main(String[] args) throws Exception {
       
    	OrderedList List1 = new OrderedList();
        OrderedList List2 = new OrderedList();

        Person gerso = new Person(1, "gerso");
        Person ignatciuos = new Person( 3, "Ignatcious");
        CakeClass aCake = new CakeClass(2, true);
           CakeClass cigaretteDayDream = new CakeClass(4, true);

        List1.orderdInsert(gerso);
        List1.orderdInsert(aCake);
        List2.orderdInsert(ignatciuos);
        List2.orderdInsert(cigaretteDayDream);
       
        System.out.println(List1.search(2).getId());
        System.out.println(List2.search(3).getId());
        
        List1.delete(2);
        List2.delete(3);
          
        
    }

}

package trabalhinho1;

public class Main {
    /*
     * Autores:
     * Lucas Varella - 17100914
     * Marcos Laydner - 17100916
     */
    public static void main(String[] args) throws Exception {
       
    	OrderedList list1 = new OrderedList();
        OrderedList list2 = new OrderedList();
        OrderedList list3 = new OrderedList();
        

        Person gerso = new Person(1, "gerso");
        Person ignatciuos = new Person( 3, "Ignatcious");
        CakeClass aCake = new CakeClass(2, true);
        CakeClass cigaretteDayDream = new CakeClass(4, true);

        list1.orderdInsert(gerso);
        list1.orderdInsert(aCake);
        list2.orderdInsert(ignatciuos);
        list2.orderdInsert(cigaretteDayDream);
        list1.orderdInsert(ignatciuos);
        list1.orderdInsert(aCake);
        list1.orderdInsert(cigaretteDayDream);
        list3.orderdInsert(aCake);
        
        System.out.println(list1.search(2).getId());
        System.out.println(list2.search(3).getId());
        
        list1.delete(2);
        list2.delete(3);
        list1.search(2);
        list2.search(3);
        list3.delete(2);
        list1.delete(2);
          
        
    }

}

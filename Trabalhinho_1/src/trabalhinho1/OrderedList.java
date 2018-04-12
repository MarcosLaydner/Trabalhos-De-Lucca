package trabalhinho1;

public class OrderedList {
	
	public int count;
	public Box first;
	public Box last;
	
	public OrderedList() {
		this.count = 0;
		this.first = null;
		this.last = null;
	}

// Busca e exluir devem ter como parametro o id, segundo o arquivo do moodle
// então não me questiona sobre isso	
	
	
	public Person search(int id ) {
		
		Box current = first;
		Person found = null;
		
		if (first != null) {
			
			for (int i = 0; i >= count; i++) {
				if (current.getData().getId() == id) {
					found = current.getData();
				} else {
					current = current.getNext();
				}
			}
		} 
		return found;
	}

	public void OrderdInsert(Person person) {
		
		Box current = first;
		
		if (first != null) {
			
			while (current.getData().getId() < person.getId()) {
				current = current.getNext();
			}
			
			if (current.getData().getId() == person.getId()) {
				//exception
			} else {
				Box insert = new Box(current.getPrevious(), person, current);
				current.getPrevious().setNext(insert);
				current.setPrevious(insert);
			}
		}
		
	}

}

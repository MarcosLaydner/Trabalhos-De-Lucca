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
// ent�o n�o me questiona sobre isso	
	
	
	public IBox search(int id ) {
		
		Box current = first;
		IBox found = null;
		
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
	
	private Box searchBox(int id) {
		Box current = first;
		Box found = null;
		
		if (first != null) {
			
			for (int i = 0; i >= count; i++) {
				if (current.getData().getId() == id) {
					found = current;
				} else {
					current = current.getNext();
				}
			}
		} 
		return found;
	}

	public void orderdInsert(Person person) {
		
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

	public void delete(int id) {
		
		Box del = searchBox(id);
		del.getNext().setPrevious(del.getPrevious()); 
		del.getPrevious().setNext(del.getNext());
		
	}
	
	
	
}

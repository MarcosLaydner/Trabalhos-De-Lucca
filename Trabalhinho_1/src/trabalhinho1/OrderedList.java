package trabalhinho1;

public class OrderedList {
	
	private LinkedList list;
	
	public OrderedList() {
		this.list = new LinkedList();
	}
	
	public datatype search(int id ) {
		datatype found = list.searchData(id);
		if(found == null) {
			System.out.println("ID '"+id+"' not found in list.");
		}
		return found;
	}
	
	private Box<datatype> searchBox(int id) {
		return list.searchBox(id);
	}

	public void orderdInsert(datatype data) {
		if(list.getCount() != 0) {
			Box<datatype> current = list.getFirst();
			
			while (!current.nextNull() && current.getData().getId() < data.getId()) {
				current = current.getNext();
			}
			if(current.nextNull()) {
				try {
					list.insertAfter(data, current.getData());
				} catch (IdRegisteredException e) {
					System.out.println(e.getMessage());
				}
			}else {
				try {
					list.insertBefore(data, current.getData());
				} catch (IdRegisteredException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			list.insertFirst(data);
		}
		
	}

	public void delete(int id) {
		try {
			list.delete(id);
		} catch (InvalidIException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}

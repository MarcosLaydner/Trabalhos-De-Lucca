package trabalhinho1;

public class OrderedList {
	
	private LinkedList list;
	
	public OrderedList() {
		this.list = new LinkedList();
	}
	
	public datatype search(int id ) {
		return list.searchData(id);
	}
	
	private Box<datatype> searchBox(int id) {
		return list.searchBox(id);
	}

	public void orderdInsert(datatype data) throws IdRegisteredException {
		if(list.getCount() != 0) {
			Box<datatype> current = list.getFirst();
			
			while (!current.nextNull() && current.getData().getId() < data.getId()) {
				current = current.getNext();
			}
			if(current.nextNull()) {
				list.insertAfter(data, current.getData());
			}else {
				list.insertBefore(data, current.getData());
			}
		}
		else {
			list.insertFirst(data);
		}
		
	}

	public void delete(int id) throws Exception {
		list.delete(id);
	}
	
	
	
}

package trabalhinho1;

import java.util.ArrayList;

public class LinkedList {
	private int count;
	private Box<datatype> first;
	
	public LinkedList() {
		this.count = 0;
		this.first = null;
	}

	public datatype searchData(int id) {
		
		datatype found = null;
		
		if (first != null) {
			Box<datatype> current = first;
			for (int i = 0; i < count; i++) {
				if (current.getData().getId() == id) {
					found = current.getData();
				} else {
					current = current.getNext();
				}
			}
		} 
		return found;
	}

	public Box<datatype> searchBox(int id) {
		Box<datatype> current = first;
		Box<datatype> found = null;
		
		if (first != null) {
			
			for (int i = 0; i < count; i++) {
				if (current.getData().getId() == id) {
					found = current;
				} else {
					current = current.getNext();
				}
			}
		} 
		return found;
	}

	public Box<datatype> getFirst() {
		return this.first;
	}

	public void insertBefore(datatype dataIns, datatype dataAft) throws IdRegisteredException {
		if (dataIns.getId() == dataAft.getId()) {
			throw new IdRegisteredException();
		} else if(!this.first.equals(searchBox(dataAft.getId()))) {
			
			Box<datatype> current = searchBox(dataAft.getId());
			Box<datatype> insert = new Box<datatype>(current.getPrevious(), dataIns, current);
			current.getPrevious().setNext(insert);
			current.setPrevious(insert);
			count++;
			
		} else {
			Box<datatype> insert = new Box<datatype>(null, dataIns, this.first);
			this.first.setPrevious(insert);
			this.first = insert;
			count++;
		}
		
	}

	public int getCount() {
		return this.count;
	}

	public void insertFirst(datatype data) {
		Box<datatype> insert = new Box<datatype>(null, data, null);
		this.first = insert;
		count++;
	}

	public void delete(int id) throws Exception {
		
		if(!searchBox(id).equals(null)) {
			Box<datatype> del = searchBox(id);
			
			if(!this.first.equals(del)) {
				del.getPrevious().setNext(del.getNext());
				count--;
			}else {
				del.getNext().setPrevious(null); 
				this.first = del.getNext();
				count--;
			}
			
		} else {
			throw new Exception("ID not found in list;");
		}
		
	}

	public void insertAfter(datatype dataIns, datatype dataBef) throws IdRegisteredException {
		if (dataIns.getId() == dataBef.getId()) {
			throw new IdRegisteredException();
		} else {
			Box<datatype> current = searchBox(dataBef.getId());
			if(current.getNext() != null) {
				Box<datatype> insert = new Box<datatype>(current, dataIns, current.getNext());
				current.getNext().setPrevious(insert);
				current.setNext(insert);
				count++;
			} else {
				Box<datatype> insert = new Box<datatype>(current, dataIns, null);
				current.setNext(insert);
				count++;
			}
		}
		
		
	}
	
	
}

package trabalhinho1;

public class Box {
	
	private Box next;
	private Person data;
	private Box previous;
	
	public Box(Box previous, Person data, Box next) {
		
		this.next = next;
		this.data = data;
		this.previous = previous;
	}

	public Box getNext() {
		return next;
	}

	public void setNext(Box next) {
		this.next = next;
	}

	public Person getData() {
		return data;
	}

	public void setData(Person data) {
		this.data = data;
	}

	public Box getPrevious() {
		return previous;
	}

	public void setPrevious(Box previous) {
		this.previous = previous;
	}
}

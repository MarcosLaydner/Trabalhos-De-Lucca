package trabalhinho1;

public class Box {
	
	private Box next;
	private IBox data;
	private Box previous;
	
	public Box(Box previous, IBox data, Box next) {
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

	public IBox getData() {
		return data;
	}

	public void setData(IBox data) {
		this.data = data;
	}

	public Box getPrevious() {
		return previous;
	}

	public void setPrevious(Box previous) {
		this.previous = previous;
	}

}

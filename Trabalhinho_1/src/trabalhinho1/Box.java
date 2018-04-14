package trabalhinho1;

public class Box<dt> {
	
	private Box<datatype> next;
	private datatype data;
	private Box<datatype> previous;
	
	public Box(Box<datatype> previous, datatype data, Box<datatype> next) {
		this.next = next;
		this.data = data;
		this.previous = previous;
	}

	public Box<datatype> getNext() {
		
		return next;
	}

	public void setNext(Box<datatype> next) {
		this.next = next;
	}

	public datatype getData() {
		return data;
	}

	public void setData(datatype data) {
		this.data = data;
	}

	public Box<datatype> getPrevious() {
		return previous;
	}

	public void setPrevious(Box<datatype> previous) {
		this.previous = previous;
	}

	public boolean nextNull() {
		if(next == null) {
			return true;
		}
		return false;
	}
	public boolean prevNull() {
		if(previous.equals(null)) {
			return true;
		}
		return false;
	}

}

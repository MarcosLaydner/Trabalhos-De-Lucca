package trabalho;

public class Node {
	
	private int data;
	private Node parent;
	private Node lSon;
	private Node rSon;
	private int balance;
	
	public Node(int data, Node parent) {
		this.parent = parent;
		this.lSon = null;
		this.rSon = null;
		this.setBalance(0);
	}
	
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getrSon() {
		return rSon;
	}
	public void setrSon(Node rSon) {
		this.rSon = rSon;
	}
	public Node getlSon() {
		return lSon;
	}
	public void setlSon(Node lSon) {
		this.lSon = lSon;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}

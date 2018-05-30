package trabalho;

public class Node {
	
	private Node parent;
	private Node lSon;
	private Node rSon;
	
	public Node(Node parent) {
		this.parent = parent;
		this.lSon = null;
		this.rSon = null;
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
	
}

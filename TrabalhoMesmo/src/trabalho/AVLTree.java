package trabalho;

public class AVLTree {
	
	private Node root;
	
	public AVLTree(Node root) {
		this.root = root;
	}
	
	
	public void insert(int data) {
		try {
			insert(this.root, data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void insert(Node root, int data) throws Exception {
        
        if (root == null) {
            root = new Node(data, null);

        } else {
            
            if(data < root.getData()) {
                if(root.getlSon() == null) {
                    root.setlSon(new Node(data, root));
                    checkBalance(root);
                    
                    
                } else {
                    insert(root.getlSon(), data);
                }
                
            } else if(data > root.getData()){
                
                if(root.getrSon() == null) {
                    root.setrSon(new Node(data, root));
                    checkBalance(root);
                    
                } else {
                    insert(root.getrSon(), data);
                }
                
                
            } else {
                throw new Exception("Tree items mus be unique");
            }
        }
    }

	public void checkBalance( Node current) {
		setBalance(current);
		int balance = current.getBalance();
		
		// se desbalanceado para esquerda
		if(balance == -2) {
			
			// checar a altura dos filhos do filho a esquerda da raiz desbalanceada, 
			// para saber se sera uma rotatcao simple para a direita
			if (height(current.getlSon().getlSon()) >= height(current.getlSon().getrSon())) {
				current = rightRotation(current);
			
			} else {
				current = doubleRotationLeftRight(current);
			}
		
			// se desbalanceado para direita	
		} else if(balance == 2) {
			
			if (height(current.getrSon().getrSon()) >= height(current.getrSon().getlSon())) {
				current = leftRotation(current);
			} else {
				current = doubleRightLeftRotation(current);
			}
		}
		
		if (current.getParent() != null) {
			checkBalance(current.getParent());
		} else {
			this.root = current;
		}
	}

	private Node leftRotation(Node current) {
		// TODO Auto-generated method stub
		return null;
	}


	private Node doubleRightLeftRotation(Node current) {
		// TODO Auto-generated method stub
		return null;
	}


	private Node doubleRotationLeftRight(Node current) {
		// TODO Auto-generated method stub
		return null;
	}


	private Node rightRotation(Node current) {
		// TODO Auto-generated method stub
		return null;
	}


	private int height(Node current) {
		if(current == null) {
			return -1;
		}
		
		if (current.getlSon() == null && current.getrSon() == null) {
			return 0;
		} else if (current.getlSon() == null) {
			return 1 + height(current.getrSon());
		} else if (current.getrSon() == null) {
			return 1 + height(current.getlSon());
		} else {
			return 1 + Math.max(height(current.getrSon()), height(current.getlSon()));
		}
	}
	
	private void setBalance(Node node) {
		node.setBalance(height(node.getrSon()) - height(node.getlSon()));
	}
	
	
}

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
	
	public void delete(int data) {
		try {
			findToDelete(this.root,data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void findToDelete(Node current, int data) throws Exception{
		if (current == null) {
			throw new Exception("The item doesn't exist");
		} else {
			
			if (data < current.getData()) {
				findToDelete(current.getlSon(), data);
			
			} else if(data > current.getData()) {
				findToDelete(current.getrSon(), data);
			
			} else if(data == current.getData()) {
				remove(current);
			}
		}
	}
	
	private void remove(Node toRemove) {
		Node r;
		
		if (toRemove.getlSon() == null || toRemove.getrSon() == null) {
			
			if (toRemove.getParent() == null) {
				this.root = null;
				toRemove = null;
				return;
			}
			r = toRemove;
		} else {
			r = replacer(toRemove);
			toRemove.setData(r.getData());
		}
		
		Node p;
		if (r.getlSon() != null) {
			p = r.getlSon();
		} else {
			p = r.getrSon();
		}
		
		if (r.getParent() == null) {
			this.root = p;
		} else {
			
			if (r == r.getParent().getlSon()) {
				r.getParent().setlSon(p);
			
			} else {
				r.getParent().setrSon(p);
			}
			
			checkBalance(r.getParent());
		}
		r = null;
	}
	
	private Node replacer(Node node) {
		
		if (node.getrSon() != null) {
			Node r = node.getrSon();
			while (r.getlSon() != null) {
				r = r.getlSon();
			}
			return r;
		} else {
			Node p = node.getParent();
			while(p != null && node == p.getrSon()) {
				node = p;
				p = node.getParent();
			}
			return p;
		}
	}
	
	private void checkBalance( Node current) {
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
		
		Node right = current.getrSon();
		right.setParent(current.getParent());
		current.setrSon(right.getlSon());
		
		if (current.getrSon() != null) {
			current.getrSon().setParent(current);
		}
		right.setlSon(current);
		current.setParent(right);
		
		if(right.getParent() != null) {
			
			if (right.getParent().getrSon() == current) {
				right.getParent().setrSon(right);
			
			} else if(right.getParent().getlSon() == current) {
				right.getParent().setlSon(right);
			}
		}
		
		setBalance(current);
		setBalance(right);
		
		return right;
	}


	private Node doubleRightLeftRotation(Node current) {
		current.setrSon(rightRotation(current.getrSon()));
		return leftRotation(current);
	}


	private Node doubleRotationLeftRight(Node current) {
		current.setlSon(leftRotation(current.getlSon()));
		return rightRotation(current);
	}


	private Node rightRotation(Node current) {
		Node left = current.getlSon();
		left.setParent(current.getParent());
		current.setlSon(left.getrSon());
		
		if (current.getlSon() != null) {
			current.getlSon().setParent(current);
		}
		
		left.setrSon(current);
		current.setParent(left);
		
		if(left.getParent() != null) {
			
			if(left.getParent().getrSon() == current) {
				left.getParent().setrSon(left);
			
			}else if(left.getParent().getlSon() == current) {
				left.getParent().setlSon(left);
			}
		}
		
		setBalance(current);
		setBalance(left);
		
		return left;
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

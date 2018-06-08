package trabalho;

import java.util.ArrayList;

public class AVLTree {
	
	private Node root;
	/**
	*Construtor da classe árvore, recebe raíz, e inicializa o atributo root com este valor.
	*@param root
	**/
	public AVLTree(Node root) {
		this.root = root;
	}
	
	/**
	*Insere Folha com o dado fornecido, caso não haja duplicatas. Caso haja, manda para o console a mensagem.
	*passa parâmetro data para o método recursivo insert(Node, int)
	*
	*@param data //dado a ser adicionado
	*
	**/
	public void insert(int data) {
		try {
			insert(this.root, data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	*método interno de inserção, fazendo comparações com recursão, até chegar ao destino para inserir a folha.
	*Finalmente, confere o balanceamento da árvore.
	*
	*@param root, data //Éfornecido então o nó, e o dado a ser adicionado, nó é avançado a cada camada de recursão.
	**/
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
                throw new Exception("Tree items must be unique");
            }
        }
    }
	/**
	*método público de deleção, invoca o método interno recursivo, passando o dado
	*Caso não exista dado solicitado na árvore, passa exceção condizente.
	*
	*@param data //dado a ser removido da árvore
	*
	**/
	public void delete(int data) {
		try {
			findToDelete(this.root,data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	*Método interno de deleção, achar para deletar. É recursivo, percorre a árvore até achar o item a ser deletado,
	*invocando então o método remove(Node). Caso o item não exista, transmite exceção
	*
	*
	*@param current, data //atual nó e dado a ser removido.
	**/
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
	/**
	*Avalia os critérios de remoção, consultando o estado do nó a ser removido, resolvendo as pendências caso
	*o mesmo tenha filhos. Também checa o balanceamento da árvore.
	*
	*
	*@param toRemove //nó a ser removido
	**/
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
		
		Node son;
		if (r.getlSon() != null) {
			son = r.getlSon();
		} else {
			son = r.getrSon();
		}
		if(son != null) {
			son.setParent(r.getParent());
		}
		
		if (r.getParent() == null) {
			this.root = son;
		} else {
			
			if (r == r.getParent().getlSon()) {
				r.getParent().setlSon(son);
			
			} else {
				r.getParent().setrSon(son);
			}
			
			checkBalance(r.getParent());
		}
		r = null;
	}
	/**
	*Método de substituição de nós para fins de remoção, caso o nó a ser removido tenha mais de um filho.
	*faz as comparações e retorna o filho ótimo a se tornar raíz.
	*
	*@param node
	*@return Node 
	**/
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
	/**
	*Método de checagem do balanceamento da árvore, recebe como parâmetro o nó atual
	*faz conferimento do status da árvore, avaliando também ações necessárias para a correção, caso haja desbalanceamento
	*invoca os métodos rightRotation(current), doubleRightRotationLeftRight(current) leftRotation(current) doubleRightLeftRotation(current)
	*conforme necessário 
	*@param current //nó atual
	**/
	private void checkBalance( Node current) {
		setBalance(current);
		int balance = current.getBalance();
		
		// se desbalanceado para esquerda
		if(balance <= -2) {
			
			// checar a altura dos filhos do filho a esquerda da raiz desbalanceada, 
			// para saber se sera uma rotatcao simple para a direita
			if (height(current.getlSon().getlSon()) >= height(current.getlSon().getrSon())) {
				current = rightRotation(current);
			
			} else {
				current = doubleRotationLeftRight(current);
			}
		
		// se desbalanceado para direita	
		} else if(balance >= 2) {
			
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
	/**
	*Um dos movimentos para balanceamento da árvore, rotação para a esquerda
	*Estes métodos invocam o método setBalance(Node), que determina o nível de balanço.
	*@param current //nó atual
	**/
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

	/**
	*Um dos movimentos para balanceamento da árvore, rotação dupla, direita e esquerda
	*Estes métodos invocam o método setBalance(Node), que determina o nível de balanço.
	*@param current //nó atual
	**/
	private Node doubleRightLeftRotation(Node current) {
		current.setrSon(rightRotation(current.getrSon()));
		return leftRotation(current);
	}

	/**
	*Um dos movimentos para balanceamento da árvore, rotação dupla, esquerda e direita
	*Estes métodos invocam o método setBalance(Node), que determina o nível de balanço.
	*@param current //nó atual
	**/
	private Node doubleRotationLeftRight(Node current) {
		current.setlSon(leftRotation(current.getlSon()));
		return rightRotation(current);
	}


	/**
	*Um dos movimentos para balanceamento da árvore, rotação para a direita
	*Estes métodos invocam o método setBalance(Node), que determina o nível de balanço.
	*@param current //nó atual
	**/
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
	/**
	*Método de busca, percorre a árvore para encontrar o nó com dado requisitado
	*retorna verdadeiro caso encontre, e falso caso não
	*@param data //dado a ser buscado
	*@return boolean
	**/
	public boolean search(int data){
		Node current = root;
		while(current!=null){
			if(current.getData() == data){
				return true;
			}else if(current.getData()> data){
				current = current.getlSon();
			}else{
				current = current.getrSon();
			}
		}
		return false;
	}
	/**
	*Método recursivo de determinação de altura, ou profundidade da árvore a partir de um nó fornecido.
	*A cada camada de recursão, avança-se um nó, e adiciona-se 1 à altura total
	*@param current //nó atual
	*@return int
	**/
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
	/**
	*Método que deremina o nível de balanço de um determinado nó, invocando método de cálculo de altura.
	*
	*@param node //nó a ser calculado
	**/
	private void setBalance(Node node) {
		node.setBalance(height(node.getrSon()) - height(node.getlSon()));
	}
	
	/**
	*Métodos para teste, criando um ArrayList de nós com a árvore.
	*
	*
	*@return ArrayList<Node>
	**/
	public int[] show(ArrayList<Node> list) {
		int[] toPrint = new int[list.size()];
		
		for (int i = 0; i > list.size(); i++) {
			toPrint[i] = list.get(i).getData();
		}
		
		return toPrint;
	}
	
	public ArrayList<Node> inOrder() {
		ArrayList<Node> show = new ArrayList<Node>();
		inOrder(this.root,show);
		return show;
	}
	/**
	*Métodos para teste, criando um ArrayList de nós com a árvore.
	*
	*@param node, show
	*
	**/
	private void inOrder(Node node, ArrayList<Node> show) {
		if (node == null) {
			return;
		}
		inOrder(node.getlSon(), show);
		show.add(node);
		inOrder(node.getrSon(), show);
	}
	
}

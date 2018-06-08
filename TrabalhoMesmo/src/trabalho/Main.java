package trabalho;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree(new Node(23, null));
		
		tree.insert(203);
		tree.insert(100);
		tree.insert(50);
		tree.insert(12);
		System.out.println(tree.search(100));
		
		System.out.println(Arrays.toString(tree.toInt()));
		
		tree.delete(100);
		tree.delete(203);
		tree.delete(23);
		tree.insert(25);
		
		System.out.println(tree.search(100));
		System.out.println(Arrays.toString(tree.toInt()));


	}

}

package trabalho;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree(new Node(23, null));
		
		tree.insert(203);
		tree.insert(100);
		tree.insert(50);
		tree.insert(12);
		
		System.out.println(Arrays.toString(tree.toInt()));

	}

}

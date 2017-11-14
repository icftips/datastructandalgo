package sm.coding.ds.tree.bst;

public class BSTHelper {

	public static Node createSampleBST() {
		Node root = new Node();
		root.value = 4;
		
		root.left = new Node();
		root.left.value = 2;
		root.right = new Node();
		root.right.value = 5;
		
		root.left.left = new Node();
		root.left.left.value = 1;
		root.left.right = new Node();
		root.left.right.value = 3;

		root.right.left = new Node();
		root.right.left.value = 6;
		root.right.right = new Node();
		root.right.right.value = 7;

		return root;
	}
}

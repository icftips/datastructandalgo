/**
 * 
 */
package sm.coding.ds.tree.bst;

/**
 * @author smughal
 *
 */
public class BstOperations {
	/**
	 * 
	 * @param n - root node
	 * @param data - data to insert in bst
	 * @return Intact input Node object its its not null, New node object with value set to data is its null
	 */
	public static Node insert(Node n, int data) {
		// basic validation
		if(null==n) {
			n = new Node();
			n.value = data;
			return n;
		}
		// check if value needs to be inserted in left sub tree
		if(data < n.value) {
			//base condition
			if(n.left==null) {
				n.left = new Node();
				n.left.value = data;
				return n;
			}else {
				return insert(n.left, data);
			}
		}else if(data > n.value){// value needs to be inserted in right sub tree
			// base condition
			if(n.right==null) {
				n.right = new Node();
				n.right.value = data;
				return n;
			}else {
				return insert(n.right, data);
			}
		}else {
			// duplicate node data==n.
			return n;
		}
	}
	
	public static void main(String[] args) {
		testInsertInExistingTree();
		testInsertNullRoot();
		testInsertDuplicateNode();
	}
	
	public static void testInsertInExistingTree() {
		Node root = BSTHelper.createSampleBST();
		System.out.println("Before insertion=");
		BinaryTreeTraversal.inOrder(root);
		
		insert(root, 13);
		insert(root, -2);
		insert(root, 9);
		
		System.out.println();
		System.out.println("After insertion=");
		BinaryTreeTraversal.inOrder(root);
	}
	
	public static void testInsertNullRoot() {
		Node root = null;
		System.out.println();
		System.out.println("Before insertion=");
		BinaryTreeTraversal.inOrder(root);
		
		root = insert(root, 13);
		insert(root, -2);
		insert(root, 9);
		
		System.out.println();
		System.out.println("After insertion=");
		BinaryTreeTraversal.inOrder(root);
	}

	public static void testInsertDuplicateNode() {
		Node root = BSTHelper.createSampleBST();
		System.out.println();
		System.out.println("Before insertion=");
		BinaryTreeTraversal.inOrder(root);
		
		insert(root, 1);
		insert(root, -2);
		insert(root, -2);
		
		System.out.println();
		System.out.println("After insertion=");
		BinaryTreeTraversal.inOrder(root);
	}

}

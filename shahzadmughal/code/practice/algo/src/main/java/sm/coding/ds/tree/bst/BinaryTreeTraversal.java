package sm.coding.ds.tree.bst;

public class BinaryTreeTraversal {

	/**
	 * Visiting order for inOrder is Left, Current, Right i.e. LCR
	 * @param n
	 */
	public static void inOrder(Node n) {
		if(n!=null) {
			inOrder(n.left);
			visit(n);
			inOrder(n.right);
		}
	}

	/**
	 * Visiting order for preOrder is Current, Left, Right i.e. CLR
	 * @param n
	 */
	public static void preOrder(Node n) {
		if(n!=null) {
			visit(n);
			inOrder(n.left);
			inOrder(n.right);
		}
	}

	/**
	 * Visiting order for preOrder is Left, Right, Current i.e. LRC
	 * @param n
	 */
	public static void postOrder(Node n) {
		if(n!=null) {
			inOrder(n.left);
			inOrder(n.right);
			visit(n);
		}
	}

	public static void visit(Node n) {
		System.out.print(n.value+",");
	}
	
	public static void main(String[] args) {
		System.out.print("In Order  =");
		inOrder(BSTHelper.createSampleBST());
		System.out.println();
		System.out.print("Pre Order =");
		preOrder(BSTHelper.createSampleBST());
		System.out.println();
		System.out.print("Post Order=");
		postOrder(BSTHelper.createSampleBST());
	}
}

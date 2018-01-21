package trees;

public class DistanceBetweenNodes {

	public int findDistance(Node root, Node n1, Node n2) {
		
		//find LCA
		Node lca = findLCA(root, n1, n2);
		//find distance of n1 from LCA
		int d1 = distance(lca, n1, 0);
		int d2 = distance(lca, n2, 0);
		
		//find distance of n2 from LCA
		return d1 + d2;
	}
	
	public int distance(Node root, Node n, int level) {
		if(root == null)
			return 0;
		
		if(root.value == n.value)
			return level;
		
		int l = distance(root.left, n, level + 1);
		if(l == 0)
			return distance(root.right, n, level + 1);
		
		return l;
	}
	
	public Node findLCA(Node root, Node n1, Node n2) {
		if(root == null) return null;
		
		if(root.value == n1.value || root.value == n2.value)
			return root;
		
		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1, n2);
		
		if(left != null && right != null)
			return root;
		
		if(left == null)
			return right;
		
		return left;
	}
	
	class Node{
		Node left;
		Node right;
		int value;
	}
}

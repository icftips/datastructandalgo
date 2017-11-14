package sm.coding.ds.tree.bst;

public class Node {
	public int value;
	public Node left;
	public Node right;
}

class GenericNode<T> {
	T data;
	GenericNode<T> left;
	GenericNode<T> right;
}

/**
 * Generic node easy implementation
 * @author shahzad-mughal
 *
 */
class GenericNodeEasy<T> {
	int value;
	T data;
	GenericNode<T> left;
	GenericNode<T> right;
}

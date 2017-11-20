package linkedlist;

public class Node {
	public int data;
	public Node next;
	
	public Node() {
		
	}
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	@Override
	public String toString() {
		String string = "";
		Node a = this;
		while(a != null) {
			string += a.data + " ";
			a = a.next;
		}
		return string;
	}
	
//	public void print() {
//		Node a = this;
//		while(a != null) {
//			System.out.print(a);
//			a = a.next;
//		}
//		System.out.println();
//	}
}

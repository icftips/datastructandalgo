package linkedlist;

public class Zip {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		
		zip(head);
	}
	
	public static Node zip(Node head) {
		if(head == null) return null;
		
		Node h1 = head;
		Node middle = partition(head);
		Node h2 = middle.next;
		middle.next = null;
		h2 = reverse(h2);
		
		Node z = zip(h1, h2);
		System.out.println(z);
		return h1;
	}
	
	public static Node zip(Node list1, Node list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		Node c1 = list1;
		Node c2 = list2;
		
		while(c1 != null && c2 != null) {
			Node t1 = c1.next;
			c1.next = c2;
			Node t2 = c2.next;
			c2.next = t1;
			c1 = t1;
			c2 = t2;
		}
		if(c1 == null)
			c1 = c2;
		
		return list1;
	}

	public static Node partition(Node head) {
		if(head == null) return null;
		Node p = head;
		Node q = head.next;
		
		while(q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}
		
		return p;
	}
	
	public static Node reverse(Node head) {
		if(head == null) return null;
		Node current  = head;
		Node previous = null;
		Node next = null;
		
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		return previous;
	}
}

package linkedlist;
/*
 * 	Intersection of two linked lists
	Write a function that returns the intersection of two integer singly linked lists. (Intersection of
	two lists starts at a common node i.e. the node with the same address).
	Input: Two lists which may or may not intersect
	Output: Data in the first node where intersection begins
	Assume that data is all positive integers or zero.
	You are not allowed to modify the input lists.
	e.g:
	1. L1 of length 4, L2 of length 4, they intersect at 3rd node. Output should be data in the 3rd
	node.
	2. L1 of length 4, L2 of length 4, they don’t intersect. Output should be -1.
	3. L1 of length 10, L2 of length 6, they intersect on 4th node of L2. Output should be data in
	the 4th node.
	e.g.
	List 1: 4 ==> 5 ==> 0 ==> 6 ==> 1
	List 2: 7 ==> 9 ==> 0 ==> 6 ==> 1
	Expected solution: Linear, with constant extra space.
	* They intersect at node with value 0. After that node, lists are the same, obviously.
	* Realize that when comparing two nodes, you should be comparing the addresses, and NOT values.
 */
public class Intersection {

	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		
		Node l1 = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		Node l2 = six;
		six.next = seven;
		seven.next = three;
		
		System.out.println("Intersection of L1 and L2		" + findIntersection(l1, l2));
		System.out.println("Intersection of L1 and Null		" +findIntersection(l1, null));
		
		l2 = six;
		six.next = seven;
		seven.next = eight;
		
		System.out.println("Intersection of L1 and L2 when there is no intersection		" +findIntersection(l1, null));
	}
	
	public static int findIntersection(Node l1, Node l2) {
		if(l1 == null || l2 == null) return -1;
		while(l1.next != null && l2.next != null) {
			if(l1==l2) return l1.data;
			l1 = l1.next;
			l2 = l2.next;
		}
		return -1;
	}

}

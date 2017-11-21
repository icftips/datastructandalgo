/**
 * 
 */
package sm.code.ds.llstq;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smughal
 *
 */
public class IntersectionTwoLinkedLists {

	/**
	 * Brute force using two nested loops, comparing each element of first list with all the elements of second list.
	 * T=O(mxn) Where m is the length of first list and n is the length of second list.
	 * S=O(1) 
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static boolean isIntersecting_BruteForce(final Node l1, final Node l2) {
		// making copy to keep the input nodes references
		Node firstListNode = l1;
		Node secondListNode = l2;
		
		while(firstListNode!=null) {
			while(secondListNode!=null) {
				if(firstListNode==secondListNode) {
					return true;
				}
				secondListNode = secondListNode.next;
			}
			secondListNode = l2;
			firstListNode = firstListNode.next;
		}
		return false;
	}
	
	/**
	 * Loop through first list and add them al in map. Loop through second list and for each Node check if there in map.
	 * T=O(m+n) Where m is the length of first list and n is the length of second list.
	 * S=O(m) 
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static boolean isIntersecting_Map(final Node l1, final Node l2) {
		Map<Node, Boolean> visitedNodes = new HashMap<>();
		
		return false;
	}

	/**
	 * Slow fast pointer technique if there is a loop pointer will overlap at some point. 
	 * T=O(n) Where m is the length of first list and n is the length of second list.
	 * S=O(1) 
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static boolean isIntersecting_SlowFastPointer(final Node l1, final Node l2) {
		return false;
	}

	public static void main(String[] args) {
		Node l1 = LinkedListHelper.createSampleList(1,5);
		Node l2 = LinkedListHelper.createSampleList(1,4);
		Node l3 = LinkedListHelper.createSampleList(6,5);
		LinkedListHelper.print(l1);
		LinkedListHelper.print(l2);
		LinkedListHelper.print(l3);
		Node l1Tail = LinkedListHelper.getLast(l1);
		Node l2Tail = LinkedListHelper.getLast(l2);
		System.out.println("l1Tail="+l1Tail.data);
		System.out.println("l2Tail="+l2Tail.data);
		
		l2Tail.next = l1Tail;
		l1Tail.next = l3;
		
		LinkedListHelper.print(l1);
		LinkedListHelper.print(l2);
		
		System.out.println("isIntersecting_BruteForce="+isIntersecting_BruteForce(l1,l2));
	}
	
}

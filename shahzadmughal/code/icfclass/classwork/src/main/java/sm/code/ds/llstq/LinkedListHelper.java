/**
 * 
 */
package sm.code.ds.llstq;

/**
 * @author smughal
 *
 */
public class LinkedListHelper {

	public static Node createSampleList(int start, int length) {
		Node head = null;
		Node current = null;
		if(start>0) {
			head = new Node(start);
			current = head;
		}
		for(int i=start+1;i<start+length;i++) {
			current.next = new Node(i);
			current = current.next;
		}
		return head;
	}
	
	public static void print(Node n) {
		if(null==n) {
			System.out.print("null");
			System.out.println();
			return;
		}
		System.out.print(n.data+"->");
		print(n.next);
	}
	
	public static Node getLast(Node n) {
		if(null==n) {
			return null;
		}
		if(n.next==null) {
			return n;
		}else {
			return getLast(n.next);
		}
	}

}

/**
 * 
 */
package sm.code.ds.llstq.lru.cache.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Least Recently Used (LRU) cache
 * 
 * @author smughal
 *
 */
public class SimpleLruCache {

	private int capacity;
	private Map<Object, Node> map;
	private Node head;
	private Node tail;	
	
	/**
	 * 
	 */
	public SimpleLruCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}
	
	public void put(Object key, Object value) {
		Node n = null;
		if(!map.containsKey(key)) {
			if(map.size()==capacity) {
				map.remove(tail.key);
				removeNode(tail);
			}
			n = new Node(key, value);
		}else {
			n = map.get(key);
			n.value = value;
		}
		removeNode(n);		
		makeHead(n);
		map.put(key, n);
	}
	
	public Object get(Object key) {
		if(null!=key) {
			if(map.containsKey(key)) {
				Node n = map.get(key);
				removeNode(n);
				makeHead(n);
				return n.value;
			}
		}
		return null;
	}
	
	private void makeHead(Node n) {
		if(null==head) {
			head = n;
			tail = head;
		}else {
			head.previous = n;
			n.next = head;
			head = n;
		}
	}
	
	public Object delete(Object key) {
		Node n = map.get(key);
		if(null!=n) {
			removeNode(n);
			return n.value;			
		}
		return null;
	}
	
	private void removeNode(Node n) {
		if(null!=n) {
			if(n==tail) {
				tail = n.previous;
			}
			if(n.previous!=null) {
				n.previous.next = n.next;
				n.previous = null;
			}
			if(n.next!=null) {
				n.next.previous=n.previous;
				n.next = null;
			}
		}
	}
	
	@Override
	public String toString() {
		return "LruCache [capacity=" + capacity + ", map=" + map + ", head=" + head + ", tail=" + tail + "]";
	}

	public static void main(String[] args) {
		SimpleLruCache cache = new SimpleLruCache(3);
		cache.put("A", "a_value");
		cache.put("B", "a_value");
		cache.put("C", "a_value");
		cache.get("A");
		cache.put("D", "a_value");
		cache.put("E", "a_value");
		cache.put("F", "a_value");
		System.out.println(cache.get("D"));
	}
	
}
/**
 * Doubly Linked list.
 * 
 * @author smughal
 *
 */
class Node{
	public Object key;
	public Object value;
	public Node next;
	public Node previous;
	
	public Node(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}
}

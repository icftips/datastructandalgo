package design;

import java.util.HashMap;
import java.util.Map;

/*
 * Implement LRU cache with given capacity and it keeps 
 * the most recent items in the cache.
 */
public class LRUCache<K, V> {

	private Map<K, Node<K, V>> cache = new HashMap<>();
	private Node<K, V> head, tail;
	private int capacity = 5;

	public LRUCache() {
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public V get(K key) {
		System.out.print("Get "+key+": ");
		Node<K, V> n = cache.get(key);
		if (n != null) {
			makeNodeRecent(n);
			return n.value;
		}

		return null;
	}

	private void makeNodeRecent(Node<K, V> n) {

		if (n.next == null) {
			n.previous.next = null;
			this.tail = n.previous;
		} else {
			n.previous.next = n.next;
			n.next.previous = n.previous;
		}

		// make n the head
		setHead(n);
	}

	private void setHead(Node<K, V> n) {

		if (this.head == null) {
			this.head = n;
			this.tail = n;
		} else {
			n.previous = null;
			n.next = this.head;
			this.head.previous = n;
			this.head = n;
		}
		printCache();
	}

	public void add(K key, V value) {
		System.out.print("Add "+key+": ");
		Node<K, V> n = new Node<K, V>(key, value);
		if (cache.size() == this.capacity) {
			this.tail = this.tail.previous;
			this.tail.next = null;
		}

		cache.put(key, n);
		setHead(n);
	}

	private void printCache() {
		Node<K, V> current = this.head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}

	private static class Node<K, V> {
		private K key;
		private V value;

		private Node<K, V> previous, next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		LRUCache<Integer, Integer> cache = new LRUCache<>(5);
		cache.add(11, 11);
		cache.add(1, 1);
		cache.add(5, 5);
		cache.add(7, 7);
		cache.get(5);
		cache.add(10, 10);
		cache.add(100, 100);
		cache.get(7);
		cache.get(15);

	}
}

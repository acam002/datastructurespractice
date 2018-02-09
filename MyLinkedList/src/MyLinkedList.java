
public class MyLinkedList implements Iterable<Integer>{
	
	private int theSize;
	private int modCount = 0;
	private Node<Integer> firstNode;
	private Node<Integer> lastNode;
	
	private static class Node<Integer> {
		public Integer data;
		public Node<Integer> prev;
		public Node<Integer> next;
		
		public Node(Integer data, Node<Integer> prev, Node<Integer> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	public int size() {
		return theSize;
	}
	
	public MyLinkedList() {
		doClear();
	}
	
	public void clear() {
		doClear();
	}
	
	private void doClear() {
		firstNode = new Node<Integer>(null, null, null);
		lastNode = new Node<Integer>(null, firstNode, null);
		firstNode.next = lastNode;
		theSize = 0;
	}
	
	private void addBefore(Node<Integer> p, Integer data) {
		Node<Integer> newNode = new Node<Integer>(data, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}
	
	public void add(Integer data) {
		addBefore(getNode(size()), data);
	}
	
	private Integer remove(Node<Integer> p) {
		p.prev.next = p.next;
		p.next.prev = p.prev;
		theSize--;
		modCount++;
		return p.data;
	}
	
	public Integer remove(int index) {
		return remove(getNode(index));
	}
	
	private Node<Integer> getNode(int index, int lower, int upper) {
		
		if (index < lower || index > upper) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<Integer> result;
		
		if (index < size() / 2) {
			result = firstNode.next;
			for (int i = 0; i < index; i++) {
				result = result.next;
			}
		}
		else {
			result = lastNode;
			for (int i = size(); i > index; i--) {
				result = result.prev;
			}
		}
		return result;
	}
	
	private Node<Integer> getNode(int index) {
		return getNode(index, 0, size() - 1);
	}
	
	public Integer get(int index) {
		return getNode(index).data;
	}
	
	public java.util.Iterator<Integer> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements java.util.Iterator<Integer> {
		private Node<Integer> currentNode = firstNode.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		public boolean hasNext() {
			return currentNode != lastNode;
		}
		
		public Integer next() {
			if (expectedModCount != modCount) {
				throw new java.util.ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			
			Integer nextData = currentNode.data;
			currentNode = currentNode.next;
			okToRemove = true;
			return nextData;
		}
		
		public void remove() {
			MyLinkedList.this.remove(currentNode.prev);
		}
	}
}

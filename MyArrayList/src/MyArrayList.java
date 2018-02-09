import java.util.Iterator;

public class MyArrayList implements Iterable<Integer>{

	private Integer[] theItems;
	private int theSize;
	static final int DEFAULT_SIZE = 10;
	
	public MyArrayList() {
		clear();
	}
	
	public void clear() {
		theItems = new Integer[DEFAULT_SIZE];
		theSize = 0;
	}
	
	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return theSize == 0;
	}
	
	public void resize() {
		Integer[] newArray = new Integer[size() * 2 + 1];
		
		for (int i = 0; i < theItems.length; i++) {
			newArray[i] = theItems[i];
		}
		
		theItems = newArray;
	}
	
	
	public void add(int index, Integer data) {
		if (size() == theItems.length) {
			resize();
		}
		
		for (int i = size(); i > index; i--) {
			theItems[i] = theItems[i - 1];
		}
		
		theItems[index] = data;
		theSize++;
	}
	
	public void add(Integer data) {
		add(size(), data);
	}
	
	public Integer remove(int index) {
		
		Integer removedItem = theItems[index];
		
		for(int i = index; i < size() - 1; i++) {
			theItems[i] = theItems[i + 1];
		}
		
		theSize--;
		return removedItem;
	}
	
	public Integer get(int index) {
		return theItems[index];
	}
	
	public java.util.Iterator<Integer> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements java.util.Iterator<Integer> {
		int current = 0;
		public boolean hasNext() {
			return (current < theSize);
		}
		
		public Integer next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			return theItems[current++];
		}
		
		public void remove() {
			MyArrayList.this.remove(--current);
		}
	}
	
	public static void main(String[] args) {
		
		MyArrayList AL = new MyArrayList();
		Iterator<Integer> itr = AL.iterator();
		for (int i = 0; i < 20; i++) {
			AL.add(i);
		}
		
		for (int i = 0; i < AL.size(); i++) {
			System.out.println(AL.get(i));;
		}
		
		AL.add(150);
		AL.remove(5);
		for (int i = 0; i < AL.size(); i++) {
			System.out.println(AL.get(i));;
		}
		
		System.out.println("This is the for each loop");
		for (Integer integer : AL) {
			System.out.println(integer);
		}
		
		System.out.println("This is the for the iterator");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
	}
}

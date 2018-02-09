
public class QuadraticProbingHashTable {
	private int currentSize;
	private static final int DEFAULT_TABLE_SIZE = 101;
	private HashEntry<Integer>[] elements;
	
	private static class HashEntry<Integer> {
		public Integer data;
		public boolean isActive;
		
		public HashEntry(Integer data) {
			this(data, true);
		}
		
		public HashEntry(Integer data, boolean isActive) {
			this.data = data;
			this.isActive = isActive;
		}
	}
	
	public QuadraticProbingHashTable() {
		elements = new HashEntry[DEFAULT_TABLE_SIZE];
		makeEmpty();
		
	}
	
	public void makeEmpty() {
		currentSize = 0;
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
	}
	
	public void reHash() {
		HashEntry<Integer> [] oldList = elements;
		elements = new HashEntry[oldList.length * 2];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = new HashEntry<Integer>(null, false);
		}
		currentSize = 0;
		for (int i = 0; i < oldList.length; i++) {
			if (oldList[i] != null && oldList[i].isActive) {
				insert(oldList[i].data);
			}
		}
	}
	
	public int findPos(Integer num) {
		int currentPosition = myHash(num);
		int offset = 1;
		
		while (elements[currentPosition] != null && !elements[currentPosition].data.equals(num)) {
			currentPosition += offset;
			offset += offset;
		}
		
		currentPosition %= elements.length;
		
		return currentPosition;
	}
	
	
	public void insert(Integer num) {
		int position = myHash(num);
		
		if (elements[position].isActive) {
			return;
		}
		
		elements[position] = new HashEntry<Integer>(num, true);
		
		if (++currentSize > elements.length / 2) {
			reHash();
		}
			
	}
	
	public void remove(Integer num) {
		int position = findPos(num);
		elements[position].isActive = false;
		currentSize--;
	}
	
	public int myHash(Integer num) {
		return num % elements.length;
	}
	
}

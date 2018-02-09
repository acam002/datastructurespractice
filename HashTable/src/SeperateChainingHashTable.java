import java.util.LinkedList;

public class SeperateChainingHashTable {
	private LinkedList<Integer>[] theLists;
	private int currentSize;
	public static final int DEFAULT_TABLE_SIZE = 101;
	
	public SeperateChainingHashTable() {
		theLists = new LinkedList[DEFAULT_TABLE_SIZE];
		currentSize = 0;
		
		for (int i = 0; i < theLists.length; i++) {
			theLists[i] = new LinkedList<>();
		}
	}
	
	public SeperateChainingHashTable(int num) {
		theLists = new LinkedList[num];
		currentSize = 0;
		
		for (int i = 0; i < theLists.length; i++) {
			theLists[i] = new LinkedList<>();
		}
	}
	
	public int myHash(Integer num) {
		return num % theLists.length;
	}
	
	public void insert(Integer num) {
		int key = myHash(num);
		LinkedList<Integer> whichList = theLists[key];
		
		if (!whichList.contains(num)) {
			whichList.add(num);
			
			
			if (++currentSize > theLists.length) {
				rehash();
			}
		}
	}
	
	public boolean contains(Integer num) {
		int key = myHash(num);
		LinkedList<Integer> whichList = theLists[key];
		return whichList.contains(num);
	}
	
	public void remove(Integer num) {
		int key = myHash(num);
		LinkedList<Integer> whichList = theLists[key];
		
		if (whichList.contains(num)) {
			whichList.remove(num);
		}
		
		currentSize--;
	}
	
	public void rehash() {
		LinkedList<Integer>[] oldLists = theLists;
		
		// Create a new list that is twice the size of the original
		theLists = new LinkedList[oldLists.length * 2];
		for (int i = 0; i < theLists.length; i++) {
			theLists[i] = new LinkedList<>();
		}
		
		// Copy the stuff over to the new list
		for (int i = 0; i < oldLists.length; i++) {
			for (Integer item : oldLists[i]) {
				insert(item);
			}
		}
	}
	
	public void makeEmpty() {
		for (int i = 0; i < theLists.length; i++) {
			theLists[i].clear();
		}
		currentSize = 0;
	}
}

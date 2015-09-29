import java.util.*;

/**
 * TODO Replace this comment with your own.
 * 
 * Stub code for an implementation of a DataCounter that uses a hash table as
 * its backing data structure. We included this stub so that it's very clear
 * that HashTable works only with Strings, whereas the DataCounter interface is
 * generic.  You need the String contents to write your hashcode code.
 */
public class HashTable implements DataCounter<String> {
	
	private final int DEFAULT_SIZE = 100;

	int size;
	int dataCount;
	int resize_threshold;
	HashEntry[] hashTable;
	
	protected class HashEntry{
		
		LinkedList<DataCount<String>> dataList;
		
		public HashEntry(){
			dataList = new LinkedList<DataCount<String>>();
		}
		
		void addNode(String key, int newCount){
			DataCount<String> newData = new DataCount<String>(key, newCount);
			dataList.add(newData);
		}
	}
	
	public HashTable() {
		hashTable = new HashEntry[DEFAULT_SIZE];
		size = DEFAULT_SIZE;
		dataCount = 0;
		resize_threshold = size * 5;

		for(int i = 0; i < size; i++){
			hashTable[i] = new HashEntry();
		}
		
	}

    /** {@inheritDoc} */
    public DataCount<String>[] getCounts() {
        ArrayList<DataCount<String>> aryList = new ArrayList<DataCount<String>>(dataCount);
        DataCount<String>[] a = null;
    	
    	for(int i = 0; i < size; i++){
    		while(hashTable[i].dataList.isEmpty() != true){
    			aryList.add(hashTable[i].dataList.pop());
    		}
    	}

        return aryList.toArray(a);
    }

    /** {@inheritDoc} */
    public int getSize() {
        return dataCount;
    }

    /** {@inheritDoc} */
    public void incCount(String newData) {
    	
		int index = hash(newData, size);
		int listPos = search(newData);
		
		if(listPos == -1){
			hashTable[index].addNode(newData, 0);
			dataCount++;
			if(dataCount == resize_threshold){
				resize();
			}
		}
		else {
			hashTable[index].dataList.get(listPos).count++;
		}
    }
    
    private void resize(){
		int newSize = size * 2;
		resize_threshold = newSize * 5;
		HashEntry[] oldTable = hashTable;
		hashTable = new HashEntry[newSize];
		
		for(int i = 0; i < newSize; i++){
			hashTable[i] = new HashEntry();
		}
		
		rehash(oldTable);
		size = newSize;
	}
    
    public void rehash(HashEntry[] oldTable) {
    	for (int i = 0; i < size; i++){
    		while(hashTable[i].dataList.isEmpty() == false){
				DataCount<String> newData = oldTable[i].dataList.pop();
				int index = hash(newData.data, hashTable.length);
				
				hashTable[index].dataList.add(newData);
			}
		}
    	oldTable = null;
    }
    
    public int search(String key){
		int index = hash(key, size);
		HashEntry entry = hashTable[index];
		int listPos = -1;
		
		for(int i = 0; i < entry.dataList.size(); i++){
			if(key.compareTo(entry.dataList.get(i).data) == 0){
				listPos = i;
				break;
			}
		}
		return listPos;
	}
	
	public static int hash(String key, int num){
		if(key == null){
			throw new NullPointerException();
		}
		int index = 0;
		
		for(int i = 0; i < key.length(); i++){
			index = index + 7 * key.charAt(i) * i;
		}
		return (index % num);
	}
	
	public void printHashTable(){
		for (int i = 0; i < size; i++){
			for (int ii = 0; ii < hashTable[i].dataList.size(); ii++){
				System.out.println('"' + hashTable[i].dataList.get(ii).data + '"' + " : " + 
								   hashTable[i].dataList.get(ii).count);
			}
		}
	}

}

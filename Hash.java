
public class Hash {
	private DataItem hashArray[];
	static final int SIZE = 20;
	private int currentSize;
//	private DataItem item;
	
	/*
	 * Construct creates an array
	 */
	public Hash()
	{
		currentSize = 0;
		hashArray = new DataItem[SIZE];
//		DataItem temp = new DataItem(-1, null);
		for(int i =0; i< SIZE; i++)
		{
			hashArray[i] = null;
		}
	}
	/*
	 * hashTable uses hashFunction to get hash code and store it
	 */
//	public void hashTable(DataItem item)
//	{
//		int hashValue = hashFunction(item.getKey());
//		hashArray[hashValue] = item;
//	}
	/*
	 * hashFunction creates hashCode
	 */
	public int hashFunction(int key)
	{
		return (key % SIZE);
	}
	/*
	 * Search
	 */
	public DataItem search(int key)
	{
		//get the hash value or code
		int hashValue = hashFunction(key);
		
		//find until an empty
		while(hashArray[hashValue] != null)
		{
			if(hashArray[hashValue].getKey() == key)
				return hashArray[hashValue];
			//find next cell
			hashValue++;
			
			//wrap around the table
			hashValue %= SIZE;
		}
		
		//if not found...
		return null;
	}
	
	public void insert(DataItem item) 
	{
		//get hash code using hash function
		int hashCode = hashFunction(item.getKey());
		if(currentSize == SIZE) {
			//maybe throw an exception or resize the array
			System.out.println("array is full");
			return;
		}
		if(currentSize == 0)
		{
			hashArray[hashCode] = item;
			return;
		}
		while(hashArray[hashCode] != null)
		{
			//if taken, next cell (next cell)
			hashCode++;
			//wrap around
			hashCode %= SIZE;
		}
		hashArray[hashCode] = item;
		currentSize++;
	}
	
	public void delete(DataItem item)
	{
		//stop if array is empty
		if(currentSize == 0)
		{
			System.out.println("hash is empty already");
			return;
		}
		// get hash Code
		int hashCode = hashFunction(item.getKey());
		
		while(hashArray[hashCode] != null)
		{
			if(hashArray[hashCode].getKey() == item.getKey())
			{
				hashArray[hashCode] = null;
				currentSize--;
				return;
			}
			//if not, next cell
			hashCode++;
			//wrap around
			hashCode %= SIZE;
		}
	}
	public String print()
	{
		for(int i =0; i < SIZE; i++)
		{
			if(hashArray[i] != null)
			{
				System.out.println(i + ":" + hashArray[i].getValue());
			}
		}
		return null;
		
	}
	
	
	
	
}

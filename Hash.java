
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
		//use default key as -1 and value as null
		for(int i =0; i< SIZE; i++)
		{
			hashArray[i] = new DataItem(-1, null);
		}
	}
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
	public DataItem search(DataItem item)
	{
		//get the hash value or code
		int key = item.getKey();
		int hashValue = hashFunction(key);
		
		//find until an empty
		while(hashArray[hashValue] != null)
		{
			if(hashArray[hashValue].getKey() == key)
				return hashArray[hashValue];
			//find next cell
			++hashValue;
			
			//wrap around the table
			hashValue %= SIZE;
		}
		
		//if not found...
		return null;
	}
	
	public void insert(DataItem item) 
	{
		
		//get hash code using hash function
		int hashCode = hashFunction(item.getKey());;
		
		if(currentSize == SIZE) {
			//maybe throw an exception or resize the array
			System.out.println("array is full");
			return;
		}
		if(currentSize == 0)
		{
			hashArray[hashCode] = item;
			currentSize++; // i missed this one.... damn..
			return;
		}
		
		while((hashArray[hashCode].getValue() != null) && (hashArray[hashCode].getKey() != -1))
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
				System.out.println(i + ": Value:" + hashArray[i].getValue()+ " key:" + hashArray[i].getKey());
			}
		}
		return null;
		
	}
	
	
	
	
}

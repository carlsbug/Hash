/*
 * Define a data item that contains key and value
 */
public class DataItem {
	private int key; //data's number
	private String data; //data's value
	
	public DataItem(int key, String data)
	{
		this.key = key;
		this.data = data;
	}
	public int getKey() 
	{
		return key;
	}
	public String getValue()
	{
		return data;
	}
}

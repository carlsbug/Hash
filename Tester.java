
public class Tester {
	public static void main(String args[])
	{
		Hash myHash = new Hash();
		DataItem item1 = new DataItem(1, "Who are you");
		DataItem item2 = new DataItem(17, "hi");
		DataItem item3 = new DataItem(37, "Keon");
		myHash.insert(item1);
		myHash.insert(item2);
		myHash.insert(item3);

		DataItem temp = myHash.search(item1);
		System.out.println(temp.getValue());
		
		temp = myHash.search(item2);
		System.out.println(temp.getValue());
		temp = myHash.search(item3);
		System.out.println(temp.getValue());
		

	}

	
}

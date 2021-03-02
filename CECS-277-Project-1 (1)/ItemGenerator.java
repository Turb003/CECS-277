/**
 * Class that handles the generation of items. Reads from a file which has all
 * of the items listed out.
 * 
 */

public class ItemGenerator {
	
	private ArrayList <Item> itemList; //changed to private
  
  /**
	 * Constructor that reads from the item list text file and places items into
	 * an arraylist
	 */
	public ItemGenerator()
	{
    
		itemList = new ArrayList<Item>();
		Scanner scan;
		try {
			scan = new Scanner(new File("ItemList.txt"));

		do {
      String line = read.nextLine();
      String [] x = line.split(","); 
      Item item = new Item(x[0]); 
      itemList.add(item);

      }
        while(read.hasNextLine());
            read.close();
        }
		 catch (FileNotFoundException e) {
			
			System.out.println("File was not found");
		}
		
	}
	
  /**
	 * Method that returns a random item from the item arraylist
	 * 
	 * @return item
	 */
	public Item generateItem()
	{
		Random generate = new Random();
		int i = generate.nextInt(itemList.size());
		
		return itemList.get(i);
	}
	
}
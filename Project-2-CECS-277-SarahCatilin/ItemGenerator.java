import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class ItemGenerator implements ItemPrototype
{
	private ArrayList<Item> itemList;
	private static ItemGenerator instance = null;
	
	/**
	 * Reads in items from ItemList.txt and saves into an ArrayList.
	 * @throws e exception when file location is not valid
	 */	
	private ItemGenerator() 
	{
		itemList = new ArrayList<Item>();
		try 
		{
			Scanner in = new Scanner(new File("ItemList.txt"));
			while (in.hasNext()) 
			{
				String line = in.nextLine();
				Item item = new Item(line);
				itemList.add(item);
			}
			in.close();
		} 
    catch (FileNotFoundException e) 
    {
			System.out.println("File Not Found");
		}
	}
	


  /**
	 * 
	 * @return instance used to ensure that there is only a single
	 * instance of the class
	 */
	
	public static ItemGenerator getInstance()
	{
		if( instance == null)
		{
			instance = new ItemGenerator();
		}
		return instance;		
	}
	
	/**
	 * Overloaded Constructor
	 */
	
	public ItemGenerator(ItemGenerator ig)
	{
		if (ig != null)
		{
			itemList = ig.itemList;
		}
	}
	
	/**
	 * @return copy of item
	 */
	
	@Override
	public ItemPrototype clone()
	{
		return new ItemGenerator(this);
	}
		
	/**
	 * @return a random Item from itemList.
	 */
	public Item generateItem() 
	{
		itemList.clone();
		Random r = new Random();
		int index = r.nextInt(itemList.size());
		return (itemList.get(index));
	}

  /**
  * @return a potion from the itemList.
  */
  public Item getPotion()
  {
    int index = 0;
    return(itemList.get(index));
  }

  /**
  *@return a key from the itemList.
  */
  public Item getKey()
  {
    int index = 1;
    return (itemList.get(index));
  }
	
	
}

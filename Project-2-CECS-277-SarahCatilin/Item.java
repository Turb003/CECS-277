public class Item implements ItemPrototype
{
	private String name;
	private char type;
	private int value;

	/**
	 * Constructs an Item using name
	 * 
	 * @param n name of Item
	 * @param v the value of the item
	 * @param t the type of item
	 */
	public Item(String n, int v, char t) 
	{
		name = n;
	    value = v; 
	    type = t; 
		
	}
	/**
	 * Constructs a copy of the item
	 * @param i 
	 */
	public Item(Item i)
	{
		if (i != null)
		{
			value = i.value;
		}
	}
	
	
	/**
	 * Copies all values of Item and creates a cloned copy
	 * @return the cloned copy
	 */
	@Override
	public ItemPrototype clone()
	{
		return new Item(this);
	}

	/**
	 * @return name of Item
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 * @return amount of gold item is worth
	 */
	public int getValue()
	{
		return value;
	}
	/**
	 * @return the type of item it is
	 */
	public char getType()
	{
		return type;
	}
	

	

}

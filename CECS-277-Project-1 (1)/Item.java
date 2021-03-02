/**
 * Class in which the items are handled
 */
public class Item extends ItemGenerator
{

  private String name = ""; 

  /**
	 * Constructor of items
	 * 
	 * @param n
	 *            Name of item
	 */
  public Item(String n)
  {
    this.name = n;
  }

  /**
	 * Constructor of items
	 * 
   * @return name
	 */
  public String getName()
  {
    return this.name;
  }

}
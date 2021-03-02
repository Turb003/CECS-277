import java.io.*;
import java.util.*;
import java.awt.Point;

/**
 * Class in which hero/player gets handled such as movement and attacking
 */
public class Hero extends Entity
{

  private ArrayList<Item> items = new ArrayList<Item>();
  private Map map = null;
  private Point location = null;

  /**
	 * Constructs the player's character
	 * 
	 * @param n
	 *            Name that user has selected
	 * @param m
	 *            Map of the current player
	 */
  public Hero(Str n, Map m)
  {
    super(n,25);
    this.map = m;
  }
  
  /**
	 * Abstract method of type Entity. Attack method where the player deals
	 * damage to the enemy
	 */
  public String attack (Entity e){
    Random rd = new Random();
    int dmg = rd.nextInt(5* e.getMaxHP() + 1);
    e.takeDamage(dmg);
    return ( System.out.printf("%s hit a %s for %d damage.%n", getName(),
				e.getName(), dmg));
  }

  public String toString()
  {
    return "";
  }

  public String itemsToString()
  {
    return "";
  }

  /**
	 * Returns the array list size of items
	 * 
	 * @return items.size()
	 */
  public int getNumItems()
  {
    return (  items.size()  );
  }

  /**
	 * Method that checks if the player can hold more items, and if so, will be
	 * added to the arraylist of items, if inventory is full then no item will
	 * be added
	 * 
	 * @param i
	 *            Item that is passed in to add if it can be
	 * @return true or false
	 */
  public boolean pickUpItem(Item i)
  {
    if (items.size() >= 5) {
			return false;
		} else {
			items.add(i);
			return true;
		}
  }

  /**
	 * Calls upon superclass heal method to heal the Hero to maxhp
	 */
  public void drinkPotion()
  {
    super.heal( 25 - super.getHP() );
  }

  /**
	 * Drops an item at index
	 * @param index
	 */
  public void dropItem(int index)
  {
    items.remove(index);
  }

  /**
	 * Checks if there is a health potion in the inventory of the player, if so,
	 * then it will return true and the player will be healed up to max, if
	 * there is no potion, then nothing will happen
	 * 
	 * @return boolean true or false
	 */
  public boolean hasPotion()
  {
    for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals("Health Potion")) {
				return true;
			}
		}
		return false;
  }

  /**
	 * returns current location Point
	 * @return location
	 */
  public Point getLocation()
  {
    return this.location;
  }

  /**
	 * Method that makes the player go up in the map
	 * 
	 * @return c which has the char of the current room
	 */
  public char goNorth()
  {
    int x = (int)location.getX();
    int y = (int)location.getY();
    Point north = new Point(x,y-1);
    char c = getCharAtLoc(north);

    if( c != '0' && c!= '*')
    {
      setLocation(north);
    }
    return c;
    
  }

  /**
	 * Method that makes the player go down in the map
	 * 
	 * @return c which has the char of the current room
	 */
  public char goSouth()
  {
    int x = (int)location.getX();
    int y = (int)location.getY();
    Point south = new Point(x,y+1);

    if( c != '0' && c!= '*')
    {
      setLocation(south);
    }
    return c;
  }

  /**
	 * Method that makes the player go down in the map
	 * 
	 * @return c which has the char of the current room
	 */
  public char goEast()
  {
    int x = (int)location.getX();
    int y = (int)location.getY();
    Point east = new Point(x+1,y);

    if( c != '0' && c!= '*')
    {
      setLocation(east);
    }
    return c;

  }

  /**
	 * Method that makes the player go down in the map
	 * 
	 * @return c which has the char of the current room
	 */
  public char goWest()
  {
    int x = (int)location.getX();
    int y = (int)location.getY();
    Point west = new Point(x-1,y);

    if( c != '0' && c!= '*')
    {
      setLocation(west);
    }
    return c;
  }
}
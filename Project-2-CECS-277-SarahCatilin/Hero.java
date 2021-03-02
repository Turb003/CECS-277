import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Point;
import java.util.Random;

public class Hero extends Entity implements Magical 
{
	private ArrayList<Item> items;
	Map map;
	private Point location;
	private int gold;

	/**
	 * Constructs Hero with 25 maxHP, sets starting location to location on map
	 * where character = 's', creates an empty inventory.
	 * 
	 * @param n the Hero's name
	 * @param m the map which the Hero will move on
	 */
	public Hero(String n, Map m) 
	{
		super(n, 25);
		map = m;
		location = map.findStart();
		items = new ArrayList<Item>();
	}

	/**
	 * @return String representing Hero's name, gold,current HP / maximum HP, and
	 *         displays current inventory
	 */
	public String toString() 
	{
		String string = getName() + "\n" + "Gold: " + getGold() + "\n" + getHP() + "/" + getMaxHP() + "\nInventory:\n" + itemsToString();
		return string;
	}

	/**
	 * @return Formatted String of items in inventory and their positions
	 */
	public String itemsToString() 
	{
		String itemsString = "";
		for (int i = 0; i < getNumItems(); i++) 
		{
			itemsString += Integer.toString(i + 1) + ". " + items.get(i).getName() + "\n";
		}
		return itemsString;
	}

	/**
	 * @return Integer representing number of items in Hero's inventory
	 */
	public int getNumItems() 
	{
		return items.size();
	}

	/**
	 * Adds the argument item into the hero's inventory, and checks to see if the
	 * inventory size exceeds 5.
	 * 
	 * @param i item to be picked up
	 * @return true if inventory has space after pick up, else false
	 */
	public boolean pickUpItem(Item i) 
	{
		items.add(i);
		if (getNumItems() < 6)
			return true;
		return false;
	}

	/**
	 * Removes a single potion from inventory and heals for 25 hp
	 * 
	 * @param index the index of the potion in the Hero's inventory
	 */
	public void drinkPotion() 
	{
		Iterator<Item> i = items.iterator();
		while (i.hasNext()) 
		{
			Item s = i.next();
			if (s.getName().contentEquals("Health Potion")) 
			{
				i.remove();
				break;
			}
		}
		heal(25);
	}

	/**
	 * Removes item from Hero's inventory
	 * 
	 * @param index the index of the *item to remove in the Hero's *inventory
   * @return the item being removed
	 */
	public Item dropItem(int index) 
	{

		return items.remove(index);
	}

	/**
	 * Checks to see if hero has "Health Potion" items in their inventory.
	 * 
	 * @return true if hero has Health Potion, else false
	 */
	public boolean hasPotion() 
	{
		for (Item item : items) 
		{
			if (item.getName().contentEquals("Health Potion"))
				return true;
		}
		return false;
	}

	/**
	 * @return Point object representing hero's location
	 */
	public Point getLocation() 
	{
		return location;
	}

	/**
	 * Updates the hero's Point object to represent movement in the North direction.
	 * 
	 * @return char on map at the hero's new location
	 */
	public char goNorth() 
	{
		location.move((int) location.getX() - 1, (int) location.getY());
		return map.getCharAtLoc(location);
	}

	/**
	 * Updates the hero's Point object to represent movement in the South direction.
	 * 
	 * @return char on map at the hero's new location
	 */
	public char goSouth() 
	{
		location.move((int) location.getX() + 1, (int) location.getY());
		return map.getCharAtLoc(location);
	}

	/**
	 * Updates the hero's Point object to represent movement in the East direction.
	 * 
	 * @return char on map at the hero's new location
	 */
	public char goEast() 
	{
		location.move((int) location.getX(), (int) location.getY() + 1);
		return map.getCharAtLoc(location);
	}

	/**
	 * Updates the hero's Point object to represent movement in the West direction.
	 * 
	 * @return char on map at the hero's new location
	 */
	public char goWest() 
	{
		location.move((int) location.getX(), (int) location.getY() - 1);
		return map.getCharAtLoc(location);
	}

	/**
	 * Magic Missile Magical attack, works similarly to {@link #attack(Entity e) attack()} method.
	 * 
	 * @param e the Entity to receive damage
	 * @return String representing attack and how much damage was done
	 */
	@Override
	public String magicMissile(Entity e) 
	{
		Random r = new Random();
		String attack;
		int damage = r.nextInt(4) + 1;
		e.takeDamage(damage);
		attack = this.getName() + " blasts " + e + " with magic missile for " + damage + " damage!";
		return attack;
	}

	/**
	 * Fireball Magical attack, works similarly to {@link #attack(Entity e) attack()} method.
	 * 
	 * @param e the Entity to receive damage
	 * @return String representing attack and how much damage was done
	 */
	@Override
	public String fireball(Entity e) 
	{
		Random r = new Random();
		String attack;
		int damage = r.nextInt(4) + 1;
		e.takeDamage(damage);
		attack = this.getName() + " burns " + e + " with fireball for " + damage + " damage!";
		return attack;
	}
	/**
	 *Thunderclap Magical attack, works similarly to {@link #attack(Entity e) attack()} method.
	 * 
	 * @param e the Entity to receive damage
	 * @return String representing attack and how much damage was done
	 */
	@Override
	public String thunderclap(Entity e) 
	{
		Random r = new Random();
		String attack;
		int damage = r.nextInt(4) + 1;
		e.takeDamage(damage);
		attack = this.getName() + " zaps " + e + " with thunderclap for " + damage + " damage!";
		return attack;
	}
	
	/**
	 * Physical attack, does a random amount of damage 
	 * to an Entity and returns a String representing attack
	 * 
	 * @param e the Entity to receive damage 
	 * @return description of how much damage was done
	 */
	@Override
	public String attack(Entity e) 
	{
		Random r = new Random();
		String attack;
		int damage = r.nextInt(4) + 1;
		e.takeDamage(damage);
		attack = this.getName() + " attacks " + e + " for " + damage + " damage!";
		return attack;
	}
	
	/**
	 * Gets the Hero's gold
	 * @return amount of gold in inventory
	 */
	public int getGold()
	{
		return gold;
	}
	
	/**
	 * Adds gold to the hero's gold collection
	 * @param g the amount gold to collect
	 */
	public void collectGold(int g)
	{
		gold += g;
	}
	
	/**
	 * Spends gold when character is at the Store
	 * @param g the amount gold to spend
	 */
	public void spendGold(int g)
	{
		gold -= g;
	}
	
	/**
	 * Checks if the hero has armor in their inventory
	 * @return index of the first armor item in inventory, or -1 if not found 
	 */
	public int hasArmorItem()
	{
		//The following MIGHT need to be implemented in the class 'Items'.. Not sure yet.

		if(items.contains('a'))
		{
			return items.indexOf('a'); 
		}
		return -1;
	}
	
	/**
	 * Checks if the hero has a key in their inventory
	 * @return True if there is a key, and False otherwise
	 */
	public boolean hasKey()
	{
		if(items.contains("Key"))
		{
			return true;
		}
		return false;
	}
	
  /**
  * If there is a key in the users inventory then it will remove
  * the key
  *
  * @param index the index of the key in the Hero's inventory
  */

  public void useKey()
  {
    Iterator<Item> i = items.iterator();
		while (i.hasNext()) 
		{
			Item s = i.next();
			if (s.getName().contentEquals("key") || s.getName().contentEquals("Key")) 
			{
				i.remove();
				break;
			}
		}
  }

}
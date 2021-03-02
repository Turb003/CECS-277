import java.util.Random;

public abstract class Enemy extends Entity 
{
	private Item item;
	protected String description;


	/**
	 * Constructs Enemy with mHp maxHP and item.
	 * 
	 * @param n   String to name the Hero
	 * @param mHp the maxHP
	 * @param i   an item for the Enemy to hold
	 */
	public Enemy(String n, int mHp, Item i) 
	{
		super(n, mHp);
		item = i;
	}
		
	/**
	 * @return item that Enemy is holding
	 */
	public Item getItem() 
	{
		return item;
	}

	@Override
	public String attack(Entity e) 
	{
		Random r = new Random();
		String attack;
		int damage = r.nextInt(4) + 1;
		e.takeDamage(damage);
		attack = this + " attacks " + e.getName() + " for " + damage + " damage!";
		return attack;
	}
	
	/**
	  * @return the description
	  */
	  public String getDescription()
	  {
	    return description;
	  }

	  /**
	  * gives the hp of the enemy 
	  */

	  public abstract int enemyHp();



}


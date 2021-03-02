public abstract class Entity 
{
	private String name;
	private int maxHP;
	private int hp;

	
	/**
	 * Entity constructor
	 * @param n the name of the entity
	 * @param mHp Maximum Health Points
	 */
	public Entity(String n, int mHp) 
	{
		name = n;
		maxHP = mHp;
		hp = mHp;
	}

	/**
	 * Physical attack, does a random amount of damage to an Entity and returns
	 * String representing attack.
	 * 
	 * @param e the Entity to receive damage
	 * @return description of how much damage was done
	 */
	public abstract String attack(Entity e); 

	/**
	 * Gets the name of the entity
	 * @return String representing name of Entity
	 */
	public String getName() 
  {
		return name;
	}

	/**
	 * @return current HP of Entity
	 */
	public int getHP() 
  {
		return hp;
	}

	/**
	 * @return maximum HP of Entity
	 */
	public int getMaxHP() 
  {
		return maxHP;
	}

	/**
	 * @param h the amount to heal by. If h + current HP exceeds maximum HP, set
	 *          current HP to equal maximum HP
	 */
	public void heal(int h) 
  {
		hp = ((hp + h) > maxHP) ? maxHP : hp + h;
	}

    /**
    * @param h the damage to be taken
    */
	public void takeDamage(int h) 
  {
		hp -= h;
	}
  
    /**
    * @return name the name of the Entity
    */
	@Override
	public String toString() 
	{
		return name;
	}

}

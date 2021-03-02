import java.util.Random;

public class Troll extends Enemy
{
  private static final int hp = 6;
  private Item item;  
  private String description;

  /**
  *Troll constructor
  */
  public Troll()
  {
    description = "Troll";
  }

  /**
  *@return the hp of the enemy 
  */
  public int enemyHp()
  {
    return hp;
  }

  /**
  *@param e the entity
  *@return attack information
  */
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

}
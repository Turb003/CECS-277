import java.util.Random;

public class Warlock extends EnemyDecorator implements Magical
{
  protected Enemy type;
  public static final int hp = 1; 
  private Item item;

  /**
  *Warlock constructor
  *@param type, the type of enemy
  **/
  public Warlock(Enemy type)
  {
    super(type);
  }

  /**
  *@return name of enemy plus their decorator 
  **/
  public String getDescription()
  {
    return type.getDescription() + " Warlock";
  }

  /**
  *@return the hp of the enemy 
  **/
  public int enemyHp()
  {
    return type.enemyHp() + hp;
  }

	/**
	 * Magic Missile Magical attack, works similarly to {@link #attack(Entity e) attack()} method.
	 * 
	 * @param e the Entity to receive damage
	 * @return attack, how much damage was done
	 */
  @Override
	public String magicMissile(Entity e) 
  {
		Random r = new Random();
		String attack;
		int damage = r.nextInt(4) + 1;
		e.takeDamage(damage);
		attack = this + " blasts " + e.getName() + " with magic missile for " + damage + " damage!";
		return attack;
	}
  /**
	 * Fireball Magical attack, works similarly to {@link #attack(Entity e) attack()} method.
	 * 
	 * @param e the Entity to receive damage
	 * @return attack, how much damage was done
	 */
	@Override
	public String fireball(Entity e) 
  {
		Random r = new Random();
		String attack;
		int damage = r.nextInt(4) + 1;
		e.takeDamage(damage);
		attack = this + " burns " + e.getName() + " with fireball for " + damage + " damage!";
		return attack;
	}

	/**
	 * Thunderclap Magical attack, works similarly to {@link #attack(Entity e) attack()} method.
	 * 
	 * @param e the Entity to receive damage
	 * @return attack, how much damage was done
	 */
	@Override
	public String thunderclap(Entity e) 
  {
		Random r = new Random();
		String attack;
		int damage = r.nextInt(4) + 1;
		e.takeDamage(damage);
		attack = this + " zaps " + e.getName() + " with thunderclap for " + damage + " damage!";
		return attack;
	}

	/**
	 * The attack method for Magical Enemy selects a random magical attack to
	 * perform, unlike a normal Enemy's attack method.
	 * 
	 * @return String representing attack and damage done
	 */
	@Override
	public String attack(Entity e) 
  {
		Random r = new Random();
		String attack = null;
		switch (r.nextInt(3)) {
		case 0:
			attack = magicMissile(e);
			break;
		case 1:
			attack = fireball(e);
			break;
		case 2:
			attack = thunderclap(e);
			break;
		}
		return attack;
	}
}





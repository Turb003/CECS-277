import java.io.*;
import java.util.*;

/**
 * Enemy class. Methods that deal with the enemies will be here
 */

public class Enemy extends Entity {
  /**
	 * Item that enemies carry on them
	 */
  private Item item;

  /**
	 * Constructs Enemy
	 * 
	 * @param n
	 *            Name of enemy
	 * @param h
	 *            health points of enemy
	 * @param i
	 *            Item that will be dropped if enemy is slain
	 */
  public Enemy(Str n, int mHp, Item i)
  {
    super(n,mHp);
    this.item = i; 
    
  }

  /**
	 * Abstract method of type character. Attack method where enemy deals damage
	 * to the player
	 */
  @Override
  public String attack(Entity e){
    Random rand = new Random();
    int dmg = rand.nextInt(5 * e.getHP() + 1);
    e.takeDamage(dmg);
    return (System.out.printf("%s hit a %s for %d damage.%n",getName(),e.getName(), dmg));
  }

 /**
	 * Returns the item that the enemy is carrying
	 * 
	 * @return Item
	 */
  public Item getItem()
  {
    return item;
  }

}

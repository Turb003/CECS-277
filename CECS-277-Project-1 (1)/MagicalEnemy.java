  /**
   *
   *  Class extending Enemy and implementing interface Magical
   *  Template for a magical Enemy
   *
   */

public class MagicalEnemy extends Enemy implements Magical {

  /**
	 * Constructs MagicalEnemy
	 * 
	 * @param n
	 *            Name of enemy
	 * @param mHp
	 *            Max health points of enemy
   *
   * @param i   Item of the enemy is holding
	 */
  public MagicalEnemy(String n, int mHp, Item i)
  {
    super(n, mHp, i);  
  }

  /**
	 * Abstract method of type character. Attack method where enemy deals damage
	 * to the player
	 */
  @Override
  public String attack(Entity e)
  {
    Random rand = new Random();
    int dmg = rand.nextInt(5 * e.getHP() + 1);
    e.takeDamage(dmg);
    return (System.out.printf("%s hit a %s for %d damage.%n",getName(),e.getName(), dmg));
  }

  /**
	 *  Interfacing Method from Magical, magicMissile is an attack of the Magical Enemy
   *  @param e
   *            Entity being attacked
	 *  @return string displaying status
	 */
  public String magicMissile( Entity e ){
    Random rand = new Random();
    int dmg = rand.nextInt(7 * e.getHP() + 1);
    e.takeDamage(dmg);
    return (System.out.printf("%s hit a %s for %d damage.%n",getName(),e.getName(), dmg));
  }
  /**
	 *  Interfacing Method from Magical, fireball is an attack of the Magical Enemy
   *  @param e
   *            Entity being attacked
	 *  @return string displaying status
	 */
  public String fireball( Entity e ){
    Random rand = new Random();
    int dmg = rand.nextInt(3 * e.getHP() + 1);
    e.takeDamage(dmg);
    return (System.out.printf("%s hit a %s for %d damage.%n",getName(),e.getName(), dmg));
  }

  /**
	 *  Interfacing Method from Magical, thunderclap is an attack of the Magical Enemy
   *  @param e
   *            Entity being attacked
	 *  @return string displaying status
	 */
  public String thunderclap( Entity e){
    Random rand = new Random();
    int dmg = rand.nextInt(9 * e.getHP() + 1);
    e.takeDamage(dmg);
    return (System.out.printf("%s hit a %s for %d damage.%n",getName(),e.getName(), dmg));
  }
}
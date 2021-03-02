/**
 * Abstract class, super class for Enemy and Player
 * 
 */
public abstract class Entity{
  private String name;
  private int maxHP;
  private int hp;


  /**
	 * Constructor for characters
	 * 
	 * @param n
	 *            Name of character
	 * @param mHP
	 *            Max Health points of characters
	 */

  public Entity(Str n, int mHP){
    name = n;
    maxHP = mHP;
    hp = MaxHP; //set hp equal to MaxHP 
  }

  /**
	 * Attack function of enemies and Player
	 * 
	 * @param e
	 *            Entity target
	 */
  public abstract String attack(Entity e);
  

  /**
	 * Method that returns the name of character
	 * 
	 * @return name
	 */
  public String getName(){
    return this.name;
  }

  /**
	 * Gets the current health of the character
	 * 
	 * @return Health points
	 */
  public int getHP(){
    return this.hp;
  }


  /**
	 * Gets the max health of the character
	 * 
	 * @return Max Health points
	 */
  public int getMaxHP(){
    return this.maxHP;
  }

  /**
	 * Increases the health of characters
	 * 
	 * @param h
	 *            How much player will be healed for
	 */
  public void heal(int h ){
    this.hp += h; //probably check for maxHP and see if its not already going over so mod it
  }

  /**
	 * Decreases the health points of character
	 * 
	 * @param h
	 *            Damage taken
	 */
  public void takeDamage(int h ){
    this.hp -= h;
  }
  /**
	 * Displays the status of the player
	 */
  public String toString(){
    return (System.out.println("Name: " + name + "\nHealth Points: " + hp));
  }

}
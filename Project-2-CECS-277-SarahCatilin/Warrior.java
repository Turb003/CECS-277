public class Warrior extends EnemyDecorator 
{
  public static final int hp = 2;
  protected Enemy type;
  private Item item;

  /**
  *Warrior Decorator constructor
  *@param type, the type of enemy
  **/
  public Warrior(Enemy type)
  {
    super(type);
  }


  /**
  *@return name of enemy and their decorator 
  **/
  public String getDescription()
  {
    return type.getDescription() + " Warrior";
  }

  /**
  *@return the hp of enemy
  */
  public int enemyHp()
  {
    return type.enemyHp() + hp;
  }

}


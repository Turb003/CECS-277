public abstract class EnemyDecorator extends Enemy 
{
  private Item item;
  private int hp;
  protected Enemy type;

  public EnemyDecorator(Enemy type, String n, int hp)
  {
    super(n,hp);
    this.type = type;
  }

  public abstract String getDescription();









}
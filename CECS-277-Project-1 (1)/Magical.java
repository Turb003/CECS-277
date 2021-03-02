/**
* interface for Magical Enemy
*
*/

interface Magical 
{

  public static final String MAGIC_MENU = "1. Magic Missile\n2.Fireball\n3.Thunderclap";

  /**
   *
   *  magicMissile attack for the magical enemy
   * @param e
   * @return String
   *
   */
  public String magicMissile( Entity e );

  /**
   *
   *  fireball attack for the magical enemy
   * @param e
   * @return String
   *
   */
  public String fireball( Entity e );

  /**
   *
   *  thunderclap attack for the magical enemy
   * @param e
   * @return String
   *
   */
  public String thunderclap( Entity e);

}
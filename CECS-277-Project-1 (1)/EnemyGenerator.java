import java.io.*;
import java.util.*;

/**
 * Class that generates the enemies needed for the game
 */

public class EnemyGenerator{

  private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
  private ItemGenerator ig = new ItemGenerator();

  /**
	 * Constructor that constructs the enemies coming from the enemy list text
	 * file
	 */
  public EnemyGenerator( ItemGenerator ig)
  {
    Scanner scan;
    try{

      scan = new Scanner(new File("EnemyList.txt"));

      do {
        Random generate = new Random();
        Item item = itemList.generateItem();
        String line = read.nextLine();
        String[] x = line.split(","); 

        Enemy enemy = new Enemy(x[0], x[1],Integer.parseInt(x[2]), 1, item);

        enemyList.add(enemy);

            } while (read.hasNextLine());
                 read.close();
    }
    catch(FileNotFoundException e) {
       System.out.println("File was not found"); 
    }
  }

  /**
	 * Method that returns a random enemy from the arraylist of enemies that
	 * were constructed.
	 * 
	 * @param level
	 * @return a constructed enemy
	 */
  public Enemy generateEnemy(int level)
  {
      Random generate = new Random();
      Item item = itemList.generateItem();

      int i = generate.nextInt(EnemyList.size());

      Enemy enemy = enemyList.get(index);
      Enemy copy = new Enemy(enemy.getName(), enemy.getMAXHP(), enemy.getHP() * level, enemy.getLevel(), item);

      while (copy.getLevel() < level) 
      {
            copy.increaseLevel();
      }
        return copy;
  }




}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class EnemyGenerator 
{
	private static EnemyGenerator instance = null;
	private Enemy enemy;
	
	/**
	 * Enemy Constructor which is only to be 
	 * accessed using getInstance()
	 */
	public EnemyGenerator() 
	{
		//
	}

    /**
    * Accesses the constructor 
    * @return instance used to ensure that there is only a single
    * instance of the class
    */
		
		public static EnemyGenerator getInstance()
		{
			if(instance == null)
			{
				instance = new EnemyGenerator();
			}
			return instance;
		}
	
	/**
	 * Randomly generates an enemy based on the level of the Hero.
	 * If the hero is above level 1, Warlock or Warrior will be randomly
	 * generated. For each additional level gained, the enemy will be
	 * decorated twice (thus, improving its strength/maxHP).
	 * @param level the level the Hero is on
	 * 
	 */
	
		
	public Enemy generateEnemy(int level) 
	{
		
		Random r = new Random();
		int randomEnemy = r.nextInt((4) + 1); //generates random int between 1 - 4
		if(randomEnemy == 1)
		{
			enemy = new Troll();
		}
		else if(randomEnemy == 2)
		{
			enemy = new Froglok();
		}
		else if(randomEnemy == 3)
		{
			enemy = new Orc();
		}
		else if(randomEnemy == 4)
		{
			enemy = new Goblin();
		}

	
    
		if (level == 1)
		{
			return enemy;
		}	
		else if(level > 1)
		{
			Random r2 = new Random();
			int index = r2.nextInt((2) + 1);
			if(index == 1)
			{
				new Enemy(Warrior);
			}
		}	
		

	}
}

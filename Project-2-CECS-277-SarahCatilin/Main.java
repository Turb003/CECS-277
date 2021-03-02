/*
CECS 277 - Project #2
Sarah Zacky, Caitlin Martinez 
12/10/20

This program is an interactive dungeon game, where the player can fight enemies and move through levels of the dungeon until they either die or choose to quit.
*/

import java.util.Scanner;
import java.util.Random;
import java.util.Iterator;
import java.awt.Point;

public class Main {
	private final static Scanner in = new Scanner(System.in);

	/**
	 * 
	 * @param h     a Hero object
	 * @param m     a Map object
	 * @param eg    an EnemyGenerator object
	 * @param level the level of difficulty
	 * @return true if monster was defeated, false if the monster was
	 */
	public static boolean monsterRoom(Hero h, Map m, EnemyGenerator eg, int level) 
	{
		Random r = new Random();
		Enemy e = eg.generateEnemy(level);
		String article = (e.getName().contentEquals("Orc")) ? "an" : "a";
		System.out.println("You've encountered " + article + " " + e + "!");
		while (e.getHP() > 0 && h.getHP() > 0) 
		{
			// this block of code validates user input so it is an integer of value 1 or 2
			System.out.println(h.getName() + "\nHP: " + h.getHP() + "/" + h.getMaxHP());
			System.out.println(e + "\nHP: " + e.getHP() + "/" + e.getMaxHP());
			int choice;
			int maxChoices;
			do 
			{
				maxChoices = (h.hasPotion()) ? 3 : 2;
				System.out.println("1. Fight\n" + "2. Run away");
				if (h.hasPotion())
					System.out.println("3. Drink Health potion");
				while (!in.hasNextInt()) 
				{
					System.out.println("Please enter a valid choice!");
					in.next();
				}
				choice = in.nextInt();
			} while (choice < 1 || choice > maxChoices);
			///////////////////////////////////
			switch (choice) 
			{
			//1 - Fight
			case 1:
				if (fight(h, e)) 
				{
					Item monsterItem = e.getItem();
					System.out.println("You received a " + monsterItem.getName() + " from its corpse!");
					int itemChoice;
					if (!h.pickUpItem(monsterItem)) 
					{
						do 
						{
							System.out.println("Inventory full! Select item to discard:\n" + h.itemsToString());
							while (!in.hasNextInt()) 
							{
								System.out.println("Please enter a valid choice!");
								in.next();
							}
							itemChoice = in.nextInt();
						} 
						while (itemChoice < 1 || itemChoice > h.getNumItems());
						h.dropItem(itemChoice - 1);
						System.out.println("Item discarded!");
					}
					return true;
				}
				if (h.getHP() < 0)
					System.out.println("You died");
				break;
			//2 - Run Away
			case 2: 
				int randMove = r.nextInt(4);
				Point currentLoc = h.getLocation();
				if ((randMove % 4) != 0 && currentLoc.getX() != 0) 
				{ // can go North
					h.goNorth();
				} 
				else if ((randMove % 4) != 1 && currentLoc.getY() != 4) 
				{ // can go east
					h.goEast();
				} 
				else if ((randMove % 4) != 2 && currentLoc.getX() != 4) 
				{ // can go south
					h.goSouth();
				} 
				else // can go west
					h.goWest();
				m.reveal(h.getLocation());
				if (m.getCharAtLoc(h.getLocation()) == 'm')
					monsterRoom(h, m, eg, level);
				if (m.getCharAtLoc(h.getLocation()) == 'f' & h.hasKey() == true) 
				{
					System.out.println("You find this floor's exit and descend deeper into the dungeon.");
					level++;
					h.heal(h.getMaxHP());
					m.loadMap(level);
					m.reveal(h.getLocation());
				}
				return false;
			default:
				h.drinkPotion();
				System.out.println("You drank a health potion and recovered 25 HP.");
				System.out.println(e.attack(h));
			}
		}
		return false;
	}

	/**
	 * Gives the user the option to pick between Physical Attack or Magic Attack
	 * 
	 * @param h the hero
	 * @param e the enemy
	 * @return true if enemy is defeated, else false
	 */
	public static boolean fight(Hero h, Enemy e) 
	{
		int fightChoice;
		do 
		{
			System.out.println("1. Physical Attack\n2. Magic Attack");
			while (!in.hasNextInt()) 
			{
				System.out.println("Please enter a valid choice!");
				in.next();
			}
			fightChoice = in.nextInt();
		} 
		while (fightChoice < 1 || fightChoice > 2);
		if (fightChoice == 1) 
		{
			System.out.println(h.attack(e));
		} 
		else 
		{
			int magicChoice;
			do 
			{
				System.out.println("1. Magic Missile\n2. Fireball\n3. Thunderclap");
				while (!in.hasNextInt()) 
				{
					System.out.println("Please enter a valid choice!");
					in.next();
				}
				magicChoice = in.nextInt();
			} while (magicChoice < 1 || magicChoice > 3);
			switch (magicChoice) 
			{
			case 1:
				System.out.println(h.magicMissile(e));
				break;
			case 2:
				System.out.println(h.fireball(e));
				break;
			default:
				System.out.println(h.thunderclap(e));
			}
		}
		if (e.getHP() <= 0)
			return true;
		System.out.println(e.attack(h));
		return false;
		}

	/**
	 * Called if Hero enters a room denoted by char 'i'. Gives player a random item.
	 * 
	 * @param h Hero
	 * @param m Hero's map
	 * @param ig ItemGenerator object to randomly select an item
	 */
	public static void itemRoom(Hero h, Map m, ItemGenerator ig) 
	{
		Item roomItem = ig.generateItem();
		System.out.println("You find a " + roomItem.getName() + "!");
		int itemChoice;
		if (!h.pickUpItem(roomItem)) 
		{
			do 
			{
				System.out.println("Inventory full! Select item to discard:\n" + h.itemsToString());
				while (!in.hasNextInt()) 
				{
					System.out.println("Please enter a valid choice!");
					in.next();
				}
				itemChoice = in.nextInt();
			} 
			while (itemChoice < 1 || itemChoice > h.getNumItems());
			h.dropItem(itemChoice - 1);
			System.out.println("Item discarded!");
		}
		m.removeCharAtLoc(h.getLocation());
	}

/**
	 * Called if Hero wants to visit the store when at the start location
	 * on the map.
	 * 
	 * @param h Hero
	 */
	
	public static void store(Hero h)
	{
    
    ItemGenerator ig = ItemGenerator.getInstance();
    Item potion = ig.getPotion();
    Item key = ig.getKey();
    int gold = h.getGold();
    int size = h.getNumItems();
    

    System.out.println("The amount of gold you have is " + h.getGold());
		System.out.println("Would you like you buy or sell?");
		System.out.println("1.Buy\n2.Sell");
		
		int buyOrSell = in.nextInt();
		
		while(buyOrSell == 1)
		{
			if(buyOrSell == 1)
			{
        if(gold == 0)
        {
          System.out.println("You cannot buy any object since you have no gold!");
          System.out.println("Would you like to sell a item or exit the store?");
          System.out.println("1.Sell\n2.Exit");
          int sellOrExit = in.nextInt();

          if (sellOrExit == 1)
          {
            buyOrSell = 2; 
            break;
          }
          else
          {
            break;
          }         
        }
				  System.out.println("Would you like to buy a health potion or key?");
				  System.out.println("1.health potion\n2.key");
				  int hpOrKey = in.nextInt();
        
				  if(hpOrKey == 1)
				  {
            h.spendGold(potion.getValue());
            h.pickUpItem(potion);
					  System.out.println("You successfully purchased a " + potion.getName());
            System.out.println("You now have " + h.getGold() + " gold.");
				  }
				  else if (hpOrKey == 2)
				  {
            h.spendGold(key.getValue());
					  h.pickUpItem(key);
            System.out.println("You succesfully purchased a " + key.getName());
            System.out.println("You now have " + h.getGold() + " gold.");
				  }

          System.out.println("Would you like to purchase another item or exit the store?");
          System.out.println("1.Purchase\n2.Exit");
          int purchaseOrExit = in.nextInt();

          if(purchaseOrExit == 1)
          {
            buyOrSell = 1; 
          } 
          else if(purchaseOrExit == 2)
          {
            buyOrSell = 0;
            break;
          }
			  }
      }

      while(buyOrSell == 2)
      {
        if(buyOrSell == 2)
        {
          if(size == 0)
          {
            System.out.println("You have no items to sell!");
            break; 
          } 
          
          System.out.println("What item would you like to sell?" + h.itemsToString());
          int itemSelling = in.nextInt();
          h.dropItem(itemSelling - 1);
          h.collectGold(itemSelling);
          System.out.println("You successfully sold the item");
          System.out.println("You currently have "+ h.getGold() + " gold");
          System.out.println("Do you want to sell another item?");
          int sellOrExit = in.nextInt();

          if(sellOrExit == 1)
          {
            buyOrSell = 2; 
          }
          else
          {
            buyOrSell = 3;
            break;
          }
        }
      
    }
		
	}


	/*
	 * The user begins at Map 1 and has the option to travel N/E/S/W. * The user also has the option to vist the store when at start.
	 * 's' is for Start
	 * 'i' is for Item
	 * 'm' is for Monster
	 * 'n' is for Nothing
	 * 'f' is for Finish
	 * 
	 */
	public static void main(String[] args) 
	{
		ItemGenerator itemg = ItemGenerator.getInstance();
		EnemyGenerator enemyg = EnemyGenerator.getInstance();
		int level = 1;
		Map map = Map.getInstance();
		map.loadMap(level);
		System.out.println("What is your name, traveler? ");
		String name = in.next();
		Hero hero = new Hero(name, map);
		do 
		{
			System.out.println(hero);
			map.displayMap(hero.getLocation());
			int moveChoice;
			do 
			{
				System.out.println("1. Go North\n2. Go South\n3. Go East\n4. Go West\n5. Quit");
				while (!in.hasNextInt()) 
				{
					System.out.println("Please enter a valid choice!");
					in.next();
				}
				moveChoice = in.nextInt();
			} 
			while (moveChoice < 1 || moveChoice > 5);
			switch (moveChoice) 
			{
			case 1:
				if (hero.goNorth() == 'x') 
				{
					System.out.println(hero.getName() + " tries to go north but hits a wall.");
					hero.goSouth();
				}
				map.reveal(hero.getLocation());
				break;
			case 2:
				if (hero.goSouth() == 'x') 
				{
					System.out.println(hero.getName() + " tries to go south but hits a wall.");
					hero.goNorth();
				}
				map.reveal(hero.getLocation());
				break;
			case 3:
				if (hero.goEast() == 'x') 
				{
					System.out.println(hero.getName() + " tries to go east but hits a wall.");
					hero.goWest();
				}
				map.reveal(hero.getLocation());
				break;
			case 4:
				if (hero.goWest() == 'x') 
				{
					System.out.println(hero.getName() + " tries to go west but hits a wall.");
					hero.goEast();
				}
				map.reveal(hero.getLocation());
				break;
			default:
				hero.takeDamage(hero.getMaxHP());
				continue;
			}
			switch (map.getCharAtLoc(hero.getLocation())) 
			{
			case 'i':
				itemRoom(hero, map, itemg);
				break;
			case 'm':
				if (monsterRoom(hero, map, enemyg, level))
					map.removeCharAtLoc(hero.getLocation());
				else if (map.getCharAtLoc(hero.getLocation()) == 'i') 
				{
					itemRoom(hero, map, itemg);
				}
				break;
			case 'f':
        if(hero.hasKey() == true)
        {
				  System.out.println("You find this floor's exit and descend deeper into the dungeon.");
          hero.useKey();
				  level++;
				  hero.heal(hero.getMaxHP());
				  map.loadMap(level);
				  map.reveal(hero.getLocation());
				  break;
        }
        else if (hero.hasKey() == false)
        {
          System.out.println("You do not have a key so you cannot level up!");
          break;
        }
			case 's':
				System.out.println("You're back at the start.");
				//*****Caitlin, Need to insert option here to visit the store**********
        System.out.println("Would you like to visit the store?");
				System.out.println("1.Yes\n2.No");
				int storeVisit = in.nextInt();
				boolean visit = true;
				
				while(visit == true)
				{
					if(storeVisit == 1) 
					{
						store(hero);
					}
					else
					{
						visit = false; 
					}
          visit = false;
				}
				break;
			default:
				System.out.println("There's nothing here.");
			}
		} 
    while (hero.getHP() > 0);
		in.close();
		System.out.println("Game Over");
	}

  




}

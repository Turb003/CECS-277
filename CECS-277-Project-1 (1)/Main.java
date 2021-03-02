import java.util.*;
import java.io.*;
import java.awt.Point;

/**
 * Dungeon Master Game; Project 1 Project uses text files to get items, enemies, and maps to use
 * throughout the program.
 * @author Alan Marin, Caitlyn Martinez
 */
public class Main {

  
  //gets called after hero stepped on m tile and 
  public static boolean monsterRoom(Hero h, Map m, EnemyGenerator eg, int level)
  {
    return true;
  }

  //gets called when user steps on m tile
  public static boolean fight( Hero h, Enemy e)
  {

    while(fighting){
      return true;
    }
  }
  //gets called when hero steps on i tile
  public static void itemRoom(Hero h, Map m, ItemGenerator ig)
  {
    return;
  }

  /**
	 * Main game functions reside in the main
	 * 
	 * @param args
	 * 
	 * 
	 */
  public static void main(String[] args) 
  {
    boolean gamestate = true;
    Scanner in = new Scanner(System.in);

    Map m = null;
    Point p = null;
    Hero h = null;

    System.out.print("What is your name, Traveler? ");
    String username = in.nextLine();
    m = new Map();
    p = new Point();
    h = new Hero(username,m);
    m.loadMap(1); //Starting at Map 1

    m.displayMap(p);

  }
}


                            
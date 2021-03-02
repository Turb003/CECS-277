import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;
import java.awt.Point;

/**
* Class for Map which contains all map data and methods
*/
public class Map
{
  private char[][] map;
  private boolean[][] revealed; //revelaed gets updated when hero visits that x,y

  /**
	 * Constructs the 5 x 5 array in which the player will move through the
	 * map
	 */
  public Map()
  {
    map = new char[5][5];
  }

  /**
	 * Method that creates the map by printing out the map. The map
	 * changes depending on the map of the player.
	 * 
	 * @param mapNum
	 *            Map of the player
	 * 
	 */
  public void loadMap(int mapNum)
  {
    String mapName = "Map" + mapNum + ".txt";
    
    Scanner read = new Scanner(new File(mapName));

    String[] line;
    
    for(int i = 0; i<5;i++){
      line = read.nextLine().split("\\s+");
      for(int j = 0; j < line.length;j++){
        map[i][j] = line[j].charAt(0);
      }
    }
    read.close();
  }

  /**
	 * Method that gets the room type in which the player is currently in
	 * 
	 * @param p
	 *            Current location of the player
	 * @return Char that represents the room the player is in
	 */
  public char getCharAtLoc(Point p)
  {
    char room;
    room = map[p.y][p.x];
    return room;
  }

  /**
	 * Method that prints onto the console the map and the location of the
	 * player
	 * 
	 * @param p
	 *            Location of the player, needed to print out the * for thier
	 *            location
	 */
  public void displayMap(Point p) 
  {
    System.out.println("**************");
    for(int i = 0; i < 5; i++){
      System.out.print("| ");
      for(int j = 0;j < 5; j++){
        if(p.getX() == j && p.getY() == i){
          System.out.print("* ");
        }
        else{
          System.out.print(map[i][j] + " ");
        }
      }
      System.out.print("| \n");
    }
    System.out.println("**************");
  }

  /**
	 * Method that searches for the starting point of the map and returns that
	 * location
	 * 
	 * @return Point of the starting point
	 */
  public Point findStart()
  {
    //loop through array and find 's'
    if(map[0].length <1){
      System.out.println("map error");
      return new Point(0,0);
    }
    for(int i = 0; i < map.length; i++){
      for(int j = 0; j < map[i].length;j++){
        if(map[i][j] == 's'){
          return new Point(i,j);
        }
      }
    }
    return new Point(0,0);

  }

  public void reveal (Point p )
  {
    return;
  }

  public void removeCharAtLoc(Point p)
  {
    return;
  }

}
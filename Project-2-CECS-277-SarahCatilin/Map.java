import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.Point;
import java.util.Scanner;

public class Map 
{
	private char[][] map;
	private boolean[][] revealed;
  private static Map instance = null;
	/**
	 * Constructor for map. Sets all values in map[][] to null initially, and all
	 * values in revealed[][] to false initially.
	 */
	private Map() 
  {
		map = new char[5][5];
		revealed = new boolean[5][5];
		for (int row = 0; row < 5; row++) 
    {
			for (int column = 0; column < 5; column++) 
      {
				map[row][column] = '\0';
				revealed[row][column] = false;
			}
		}
	}

  /**
	 * 
	 * @return instance used to ensure that there is only a single
	 * instance of the class
	 */
	
	public static Map getInstance()
	{
		if( instance == null)
		{
			instance = new Map();
		}
		return instance;
	}

	/**
	 * Load characters into map[][] from a text file based on specified mapNum.
	 * 
	 * @param mapNum a number that will specify which map to load. Rolls back when
	 * mapNum exceeds 3.
	 * @throws e exception when file location is not valid
	 * 
	 */
	public void loadMap(int mapNum) 
  {
		Scanner scan = null;
		try 
    {
			switch (mapNum % 3) {
			case 1:
				scan = new Scanner(new FileReader("Map1.txt"));
				break;
			case 2:
				scan = new Scanner(new FileReader("Map2.txt"));
				break;
			default:
				scan = new Scanner(new FileReader("Map3.txt"));
			}
		} 
    catch (FileNotFoundException e) 
    {
			System.out.print("File not found");
		}
		String s = null;
		int row = 0;
		int column = 0;
		while (scan.hasNext()) 
    {
			s = scan.next();
			map[row][column] = s.charAt(0);
			revealed[row][column] = false;
			row = (column == 4) ? row + 1 : row; // if we are one column four, iterate to next row. else stay
			column = (column == 4) ? column = 0 : column + 1; // if we are one column four, reset column count. else
																// iterate column by one
		}
		scan.close();
	}

	/**
	 * @param p a point within the map
	 * @return the char stored at location p. if out of bound, return 'x';
	 */
	public char getCharAtLoc(Point p) 
  {
		if (p.getX() < 0 || p.getX() > 4 || p.getY() < 0 || p.getY() > 4)
			return 'x';
		else
			return map[(int) p.getX()][(int) p.getY()];
	}

	/**
	 * Displays map. '*' denotes location of object at point p. 'n' denotes a
	 * revealed room. 'X' denotes an undiscovered room.
	 * 
	 * @param p the location of an object being tracked on the map
	 */
	public void displayMap(Point p) 
  {
		for (int row = 0; row < 5; row++) 
    {
			for (int column = 0; column < 5; column++) 
      {
				if (row == p.getX() && column == p.getY())
					System.out.print("* ");
				else if (revealed[row][column])
					System.out.print(map[row][column] + " ");
				else
					System.out.print("x ");
			}
			System.out.println();
		}
	}

	/**
	 * @return Point location where char 's' is on map
	 */
	public Point findStart() 
  {
		Point start = new Point();
		for (int row = 0; row < 5; row++) 
    {
			for (int column = 0; column < 5; column++) 
      {
				if (map[row][column] == 's') 
        {
					start.setLocation(row, column);
					reveal(start);
				}
			}
		}
		return start;
	}

	/**
	 * Sets the array location in revealed[][] corresponding to point p as true.
	 * 
	 * @param p point to reveal
	 */
	public void reveal(Point p) 
  {
		revealed[(int) p.getX()][(int) p.getY()] = true;
	}

	/**
	 * Changes character at specified location to 'n', meaning nothing is in the
	 * room. Should call this after the character picks up an item or defeats a
	 * monster.
	 * 
	 * @param p the point to replace with character 'n'
	 */
	public void removeCharAtLoc(Point p) 
  {
		map[(int) p.getX()][(int) p.getY()] = 'n';
	}
}

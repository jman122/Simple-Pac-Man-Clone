/**
 * This class represents position (x,y) of a pixel
 * @author Jia Yu Man
 */
public class Location {
	
	private int x;
	private int y;

	/**
	 * constructor that initializes the Location object with (x,y) coordinates
	 * @param x
	 * @param y
	 */
	public Location(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return x coordinate of this location
	 */
	public int xCoord() {
		
		return x;
	}
	
	/**
	 * 
	 * @return y coordinate of this location
	 */
	public int yCoord() {
		
		return y;
	}
	
	/**
	 * compares this location with p using column order
	 * @param p
	 * @return -1. 0. 1
	 */
	public int compareTo(Location p) {
		
		int posX = p.xCoord();
		int posY = p.yCoord();
		
		if (x > posX || (x == posX && y > posY)) {
			return 1;
		}
		
		else if (x == posX && y == posY) {
			return 0;
		}
		
		else {
			return -1;
		}
	}
}

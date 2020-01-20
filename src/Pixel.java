/**
 * This class represents the data items to be stored in the binary search tree
 * @author Jia Yu Man
 */
public class Pixel {
	
	private Location p;
	private int color;

	/**
	 * constructor initializes new Pixel with the specified coordinates and color
	 * @param p is the key for Pixel
	 * @param color
	 */
	public Pixel(Location p, int color) {
		
		this.p = p;
		this.color = color;
	}
	
	/**
	 * @return location p
	 */
	public Location getLocation() {
		
		return p;
	}
	
	/**
	 * @return color
	 */
	public int getColor() {
		
		return color;
	}
}

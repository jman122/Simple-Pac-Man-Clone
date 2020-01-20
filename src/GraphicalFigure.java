/**
 * This class is used to detect collisions 
 * @author Jia Yu Man
 *
 */
public class GraphicalFigure implements GraphicalFigureADT{
	
	public BinarySearchTree pixels;
	
	private int id, width, height;
	private String type;
	private Location pos;

	/**
	 * constructor 
	 * @param id is identifier for this object
	 * @param width is width of enclosing rectangle
	 * @param height is height of enclosing rectangle
	 * @param type types of this figure: fixed, user, computer target
	 * @param pos offset of this figure
	 */
	public GraphicalFigure(int id, int width, int height, String type, Location pos) {
		
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
		pixels = new BinarySearchTree();
	}
	
	/**
	 * set type
	 */
	public void setType(String type) {
		
		this.type = type;
	}

	/**
	 * return width
	 */
	public int getWidth() {
		
		return width;
	}

	/**
	 * return height
	 */
	public int getHeight() {
		
		return height;
	}

	/**
	 * return type
	 */
	public String getType() {
		
		return type;
	}

	/**
	 * return id
	 */
	public int getId() {
		
		return id;
	}

	/**
	 * return offset
	 */
	public Location getOffset() {
		
		return pos;
	}

	/**
	 * set offset
	 */
	public void setOffset(Location value) {
		
		this.pos = value;
	}

	/**
	 * inserts pix into binary search tree with this figure
	 * throws exception if an error occurs while inserting key
	 */
	public void addPixel(Pixel pix) throws DuplicatedKeyException {
		
		pixels.put(pixels.getRoot(), pix);
	}

	/**
	 * returns true if this figure intersects with the one specified in the parameter
	 * returns false otherwise
	 */
	public boolean intersects(GraphicalFigure fig) {
		
		if (rectangles(fig)) {
			for (Pixel p = pixels.smallest(pixels.getRoot()); p.getLocation().compareTo(pixels.largest(pixels.getRoot()).getLocation()) < 0; p = pixels.successor(pixels.getRoot(), p.getLocation())) {
				int x = this.getOffset().xCoord() + p.getLocation().xCoord() - fig.getOffset().xCoord();
				int y = this.getOffset().yCoord() + p.getLocation().yCoord() - fig.getOffset().yCoord();
					if(getPixel(new Location(x, y))) {
						return true;
					}
			}
		}
		return false; 
	}
	
	/**
	 * checks whether the figure crosses the borders of the window 
	 * @param fig
	 * @return true if the figure is within the borders, false otherwise
	 */
	private boolean rectangles(GraphicalFigure fig) {
		
		if (pos.xCoord() > fig.getOffset().xCoord() + fig.getWidth() || fig.getOffset().xCoord() > pos.xCoord() + width) {
			return false;
		}
		else if (pos.yCoord() > fig.getOffset().yCoord() + fig.getHeight() || fig.getOffset().yCoord() > pos.yCoord() + height) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * checks whether the pixel is in the binary search tree
	 * @param x
	 * @return true if it is, false if it is empty;
	 */
	private boolean getPixel(Location x) {
		
		Pixel p = pixels.get(pixels.getRoot(), x);
		
		if (p == null) {
			return false;
		}
		else {
			return true;
		}
	}
}

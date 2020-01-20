/**
 * This class represents nodes of a binary search tree
 * each node stores and object of the class Pixel
 * @author Jia Yu Man
 */
public class BinaryNode {

	private Pixel value;
	private BinaryNode left, right, parent;
	
	/**
	 * constructor 
	 * @param value Pixel
	 * @param left BinaryNode
	 * @param right BinaryNode
	 * @param parent BinaryNode
	 */
	public BinaryNode(Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
		
	}
	
	/**
	 * constructor that initializes a leaf node
	 * value, left, right, parent are set to null
	 */
	public BinaryNode() {
		
		this.value = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	/**
	 * @return the parent
	 */
	public BinaryNode getParent() {
		
		return parent;
	}
	
	/**
	 * set the parent
	 * @param parent
	 */
	public void setParent(BinaryNode parent) {
		
		this.parent = parent;
	}
	
	/**
	 * set the left child
	 * @param p
	 */
	public void setLeft(BinaryNode p) {
		
		this.left = p;
	}
	
	/**
	 * set the right child
	 * @param p
	 */
	public void setRight(BinaryNode p) {
		
		this.right = p;
	}
	
	/**
	 * set the data value
	 * @param value
	 */
	public void setData (Pixel value) {
		
		this.value = value;
	}
	
	/**
	 * @return true if node is a leaf, false otherwise
	 */
	public boolean isLeaf() {
		
		if (this.left == null && this.right == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @return value
	 */
	public Pixel getData() {
		
		return value;
	}
	
	/**
	 * @return left child
	 */
	public BinaryNode getLeft() {
		
		return left;
	}
	
	/**
	 * @return right child
	 */
	public BinaryNode getRight() {
		
		return right;
	}
}

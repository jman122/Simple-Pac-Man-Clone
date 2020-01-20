/**
 * This class implements an ordered dictionary using a binary search tree
 * @author Jia Yu Man
 */
public class BinarySearchTree {

	private BinaryNode root;
	
	/**
	 * create a tree whose root is a leaf node
	 */
	public BinarySearchTree() {
		
		root = new BinaryNode();
	}
	
	/**
	 * @param r
	 * @param key
	 * @return pixel storing the key, null otherwise
	 */
	public Pixel get(BinaryNode r, Location key) {
		
		if (r.isLeaf()) {
			return null;
		}
		else {
			return getNode(r, key).getData();
		}
	}
	
	/**
	 * inserts the given data in the tree if no same data item is in there already
	 * @param r
	 * @param data
	 * @throws DuplicatedKeyException if a node already stores the given data item
	 */
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException{
		
		 BinaryNode node = getNode(r, data.getLocation());
		 
		 
		 if (!node.isLeaf()) {
			 throw new DuplicatedKeyException();
		 }
		 else {
			 BinaryNode left = new BinaryNode();
			 BinaryNode right = new BinaryNode();
			 node.setData(data);
			 node.setLeft(left);
			 node.setRight(right);
			 left.setParent(node);
			 right.setParent(node);
		 }
	}
	
	/**
	 * removes data item with given key, if key is stored in tree
	 * @param r
	 * @param key
	 * @throws InexistentKeyException if the key is not in the tree
	 */
	public void remove(BinaryNode r, Location key) throws InexistentKeyException {
		
		BinaryNode node = getNode(r, key);
		BinaryNode parent = node.getParent();
		BinaryNode child;
		BinaryNode s;
		
		if (node.isLeaf()) {
			throw new InexistentKeyException();
		}
		else if (node.getLeft().isLeaf() || node.getRight().isLeaf()) {
			if (node.getLeft().isLeaf()) {
				child = node.getRight();	
			}
			else {
				child = node.getLeft();
			}
			if (node == root) {
				root = child;
				root.setParent(null);
			}
			else {
				if (parent.getLeft() == node) {
					parent.setLeft(child);
				}
				else {
					parent.setRight(child);
				}
				child.setParent(parent);
			}
			
		}
		else {
			s = Smallest(node.getRight());
			node.setData(s.getData());
			remove(s, s.getData().getLocation());
		}
	}
	
	/**
	 * @param r
	 * @param key
	 * @return the Pixel with the smallest key larger than the given one
	 */
	public Pixel successor(BinaryNode r, Location key) {
		
		BinaryNode node = getNode(r, key);
		
		if (r.isLeaf()) {
			return null;
		}
		else {
			if (!node.isLeaf() && !node.getRight().isLeaf()){
				return Smallest(node.getRight()).getData();
			}
			else {
				while (node != r && (node == node.getParent().getRight())) {
					node = node.getParent();
				}
				if (node == r) {
					return null;
				}
				else {
					return node.getParent().getData();
				}
			}
		}
	}
	
	/**
	 * @param r
	 * @param key
	 * @return the Pixel with the largest key smaller than the given one
	 */
	public Pixel predecessor(BinaryNode r, Location key) {
		
		BinaryNode node = getNode(r, key);
		
		if (r.isLeaf()) {
			return null;
		}
		else {
			if (!node.isLeaf() && !node.getLeft().isLeaf()){
				return Smallest(node.getLeft()).getData();
			}
			else {
				while (node != r && (node == node.getParent().getLeft())) {
					node = node.getParent();
				}
				if (node == r) {
					return null;
				}
				else {
					return node.getParent().getData();
				}
			}
		}
	}
	
	/**
	 * @param r
	 * @return pixel with smallest key
	 * @throws EmptyTreeException if tree is empty
	 */
	public Pixel smallest(BinaryNode r) throws EmptyTreeException {
		
		if (r == null) {
			throw new EmptyTreeException();
		}
		else {
			return Smallest(r).getData();
		}
	}
	
	/**
	 * @param r
	 * @return pixel with largest key
	 * @throws EmptyTreeException if tree is empty
	 */
	public Pixel largest(BinaryNode r) throws EmptyTreeException{
		
		if (r == null) {
			throw new EmptyTreeException();
		}
		else {
			return Largest(r).getData();
		}
	}
	
	/**
	 * @return the root of the binary search tree
	 */
	public BinaryNode getRoot() {
		
		return root;
	}
	
	/**
	 * algorithm that returns a BinaryNode storing the given key
	 * @param x
	 * @param y
	 * @return a BinaryNode
	 */
	private BinaryNode getNode(BinaryNode x, Location y) {
		
		if (x.isLeaf()) {
			return x;
		}
		
		int key = x.getData().getLocation().compareTo(y);
		
		if (key == 0) {
			return x;
		}
		else {
			if (key < 0) {
				return getNode(x.getRight(), y);
			}
			else {
				return getNode(x.getLeft(), y);
			}
		}
	}
	
	/**
	 * algorithm to find the smallest key in the binary search tree
	 * @param x
	 * @return smallest key
	 */
	private BinaryNode Smallest(BinaryNode x) {
		
		if (x.isLeaf()) {
			return null;
		}
		else {
			BinaryNode p = x;
			while (!p.isLeaf()) {
				p = p.getLeft();
			}
			return p.getParent();
		}
	}
	
	/**
	 * algorithm to find the largest key in the binary search tree
	 * @param x
	 * @return largest key
	 */
	private BinaryNode Largest(BinaryNode x) {
		
		if (x.isLeaf()) {
			return null;
		}
		else {
			BinaryNode p = x;
			while (!p.isLeaf()) {
				p = p.getRight();
			}
			return p.getParent();
		}
	}
}

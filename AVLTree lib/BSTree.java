


public class BSTree {
	
	public BinaryNode root;
	
	public BSTree(){
		root = null;
	}
	
	/**
	 * A simple insertion function for external classes
	 * Call  insert() 
	 * @param newData
	 */
	public void insert(String key){
		WordFreq newData = new WordFreq(key);
		root = insert(root, newData);
	}
	
	/**	
	 * Class insertion function
	 * @param root node
	 * @param newData
	 * @return root node
	 */
	protected BinaryNode insert(BinaryNode root, WordFreq newData){
		if (root == null){
			return new BinaryNode(newData);
		}
		
		int compareResult = root.compareTo(newData);
		if (compareResult > 0){
			root.left = insert(root.left, newData);
		}
		else if (compareResult < 0){
			root.right = insert(root.right, newData);
		}
		else{
			root.incrementFreq(1);
		}
		return root;
	}
	
	public boolean isContained(String key){
		return (search(root, key) != null) ? true : false;
	}
	
	public BinaryNode search(BinaryNode node, String key){
		BinaryNode keyNode = node;
		
		while (keyNode != null){
			int compareResult = keyNode.compareTo(key);
			
			if (compareResult > 0){
				keyNode = keyNode.left;
			}
			else if (compareResult < 0){
				keyNode = keyNode.right;
			}
			else {
				break;
			}
		}
		return keyNode;
	}
	
	/**
	 * Simple remove function for external use
	 * Call remove()
	 * @param key
	 */
	public void remove(String key){
		root = remove(root, key);
	}
	
	/**
	 * Class remove function
	 * @param root
	 * @param key
	 * @return
	 */
	public BinaryNode remove(BinaryNode root, String key){
		if (root == null){
			return root;
		}
		
		int compareResult = root.compareTo(key);
		
		if (compareResult < 0){
			root.right = remove(root.right, key);
		}
		else if (compareResult > 0){
			root.left = remove(root.left, key);
		}
		// key node found, and have two children
		else if (root.left != null && root.right != null){
			root.setData(findMin(root.right).getData());
			root.right = remove(root.right, root.getData().getWord());
		}
		else {
			root = (root.right != null) ? root.right : root.left; 
		}
		return root;
	}
	
	public BinaryNode findMax(BinaryNode root){
		if (root == null){
			throw new NullPointerException();
		}
		
		BinaryNode maxNode = root;
		
		while (maxNode.right != null){
			maxNode = maxNode.right;
		}
		return maxNode;
	}
	
	public BinaryNode findMin(BinaryNode root){
		if (root == null){
			throw new NullPointerException();
		}
		
		BinaryNode minNode = root;
		
		while (minNode.left != null){
			minNode = minNode.left;
		}
		return minNode;
	}
	
	public BinaryNode getRoot(){
		return root;
	}
	
	public int height(){
		return getHeight(root);
	}
	
	public int getHeight(BinaryNode root){
		if (root == null){
			return -1;
		}
		return Math.max(getHeight(root.left), getHeight(root.right) + 1);
	}
	
	public int Traverse(BinaryNode root){
		if (root == null){
			return 0;
		}
		System.out.print(" " + root.getData());
		return (Traverse(root.left) + Traverse(root.right) + 1);
	}
	
}

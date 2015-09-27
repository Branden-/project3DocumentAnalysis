
public class AVLTree extends BSTree {
	
	public AVLTree(){
		super();
	}
	
	/**
	 * Override BinaryTree insertTree
	 */
	public void insert(WordFreq newData){
		root = insert(root, newData);
	}
	
	/**
	 * Override BinaryTree insert
	 * This algorithm is inefficient, and provided from the slide
	 */
	public BinaryNode insert(BinaryNode root, WordFreq newData){
		if (root == null){
			return new BinaryNode(newData);
		}
		
		int compareResult = root.compareTo(newData);
		if (compareResult > 0){
			root.left = insert(root.left, newData);
			
			if(getHeight(root.left) - getHeight(root.right) == 2){
				if(root.left.compareTo(newData) > 0){
					//System.out.println("rotateRight " + root.getData().getWord());
					root = rotateRight(root);
				}	
				else{
				//System.out.println("double left-right rotation " + root.getData().getWord());
				root = doubleLeftRightRotation(root);
				}
			}
		}
		else if (compareResult < 0){
			root.right = insert(root.right, newData);
			
			if(getHeight(root.right) - getHeight(root.left) == 2){
				if(root.right.compareTo(newData) < 0){
					//System.out.println("rotateLeft " + root.getData(.getWord()));
					root = rotateLeft(root);
				}
				else {
					//System.out.println("double right-left rotation " + root.getData().getWord();
					root = doubleRightLeftRotation(root.right);
				}
			}
		}
		else {
			root.incrementFreq(1);
		}
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		
		return root;
	}
	
	private BinaryNode rotateLeft(BinaryNode root){
		BinaryNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		newRoot.height = Math.max(getHeight(newRoot.right), root.height) + 1;
		return newRoot;
	}
	
	private BinaryNode rotateRight(BinaryNode root){
		BinaryNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		newRoot.height = Math.max(getHeight(newRoot.left), root.height) + 1;
		return newRoot;
	}
	
	private BinaryNode doubleLeftRightRotation(BinaryNode root){
		root.left = rotateLeft(root.left);
		return rotateRight(root);
	}
	
	private BinaryNode doubleRightLeftRotation(BinaryNode root){
		root.right = rotateRight(root.right);
		return rotateLeft(root);
	}
	
	
	

}

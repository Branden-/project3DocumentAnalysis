
public class BinaryNode {
	
	private WordFreq data;
	int height;
	BinaryNode left;
	BinaryNode right;
	
	// Constructor to create an empty node
	public BinaryNode(WordFreq key){
		data = new WordFreq(key.getWord());
		height = 0;
		left = null;
		right = null;
	}
	
	// Constructor
	public BinaryNode(WordFreq newValue, int newHeight, BinaryNode leftNode, BinaryNode rightNode){
		data = new WordFreq(newValue.getWord());
		height = newHeight;
		left = leftNode;
		right = rightNode;
	}
	
	/**
	 * Check if a node has any child
	 * @param root
	 * @return true: has at least a child
	 * 		   false: has no child
	 */
	public boolean haveChild(){
		if (left == null &&
			right == null	){
			return false;
		}
		return true;
	}

	public WordFreq getData(){
		return data;
	}
	
	public int getHeight(){
		return height;
	}
	
	public BinaryNode getLeft(){
		return left;
	}
	
	public BinaryNode getRight(){
		return right;
	}
	
	public void setData(WordFreq newValue){
		data.clone(newValue);
	}
	
	public void setHeight(int newHeight){
		height = newHeight;
	}
		
	public void setLeftTree(BinaryNode leftTree){
		left = leftTree;
	}
	
	public void setRightTree(BinaryNode rightTree){
		right = rightTree;
	}
	
	public void incrementFreq(int i){
		data.incrementFreq(i);
	}
	
	/**
	 * Compare the value of the WordFreq to an integer
	 * @param int the number to compare to
	 * @return > 0 if word is bigger
	 * 		   = 0 if equal
	 * 		   < 0 if WordFreq is smaller
	 */
	public int compareTo(WordFreq temp){
		return data.compareTo(temp);
	}
	
	public int compareTo(String key){
		return data.compareTo(key);
	}
}

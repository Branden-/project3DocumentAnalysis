
public class BinaryNode <E>
{

	private E data;
	private BinaryNode<E> left;
	private BinaryNode<E> right;
	private int height;
	
	public BinaryNode()
	{
		setLeft(null);
		setRight(null);
		setData(null);
		setHeight(-1);
	}
	
	public BinaryNode(E data, BinaryNode<E> left, BinaryNode<E> right)
	{
	    this.data = data;
	    this.left = left;
	    this.right = right;
	    this.height = 0;
	}
	
	public BinaryNode(E data)
	{
		this.setData(data);
	}
	
	/**
	 * @param binaryNode set the left node to this value
	 */
	public void setLeft(BinaryNode<E> binaryNode)
	{
		left = binaryNode;
	}
	
	/**
	 * @param binaryNode set the right node to this value
	 */
	public void setRight( BinaryNode<E> binaryNode)
	{
		right = binaryNode;
	}
	
	public void setData(E rootData)
	{
		this.data = rootData;
	}
	
	
	/**
	 * Accessor method for left node
	 * @return left node
	 */
	public BinaryNode<E> getLeft()
	{
		return left;
	}
	
	
	/**
	 * Accessor method for right node
	 * @return right node
	 */
	public BinaryNode<E> getRight()
	{
		return right;
		
	}
	
	/**
	 * @return the data contained in this node
	 */
	public E getData()
	{
		return data;
	}
	
	public void setHeight(int newheight)
	{
	    height= newheight;
	}
	
	public int getHeight()
	{
	    return height;
	}

}

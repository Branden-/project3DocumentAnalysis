


public class BinarySearchTree <E extends Comparable<? super E>>
{
    protected BinaryNode<E> root;


    //constructor section

    /**
     * constructor for our class that is empty
     */
    public BinarySearchTree(){root = null;} //for an empty tree


    /**
     * constructor for our class with initial values
     * @param rootData
     * @param leftBinaryTree
     * @param rightBinaryTree
     */
    //	public BinarySearchTree(E rootData, BinaryNode<E> leftTree, BinaryNode<E> rightTree)
    //	{
    //		root = new BinaryNode<>();
    //		root.setData(rootData);
    //		root.setLeft(leftTree.getRoot());
    //		root.setRight(rightBinaryTree.getRoot());
    //		
    //	}

    public void makeEmpty()
    {
	root = null;
    }

    public boolean isEmpty()
    {
	return root == null;
    }



    //accessor (i.e. "getter") method section

    /**
     * @return the root object/memory address
     */
    public BinaryNode<E> getRoot()
    {
	return root;
    }

    /***********	mutator section			***********/
    /**
     * Inserts a value into the a binary search tree
     * @param valueToInsert value to insert into the tree
     */
    public void insert( E valueToInsert)
    {
	root = insert(valueToInsert, root);
	updateNodeHeights(root);
    }	

    /**
     * public method for removing a value
     * @param valueToRemove the value to remove
     */
    public void remove ( E valueToRemove)
    {
	root = remove( valueToRemove, root);
	updateNodeHeights(root);
    }

    /**
     * @return returns the height of the tree
     */
    public int height()
    {
	if( root == null)
	{
	    return 0;
	}
	return root.getHeight();
    }

    /***********	private method section		***********/

    /**
     * Find the minimum value in the binary search tree
     * @param subTree the binary search tree to find the min value in 
     * @return the node object containing the min value
     */
    protected BinaryNode<E> findMin(BinaryNode<E> subTree)
    {
	if( subTree != null)
	{
	    while ( subTree.getLeft() != null )
	    {
		subTree = subTree.getLeft();
	    }
	}
	return subTree;
    }


    /**
     * Remove an element from a binary search tree if it exists
     * @param valToRemove the value to remove
     * @param subTree the binary search tree we are trying to find the value in 
     * @return the new subtree with the value removed.
     */
    protected BinaryNode<E> remove(E valToRemove, BinaryNode<E> subTree)
    {
	if ( subTree == null)
	{
	    return subTree; //item not found
	}
	int compareResult = valToRemove.compareTo(subTree.getData());

	//is it in the left subtree, if yes, perform recursion using our remove function
	if ( compareResult < 0 )
	{
	    subTree.setLeft(remove(valToRemove, subTree.getLeft() ) );
	}
	//is it in the right subtree, if yes, perform recursion using our remove function
	else if ( compareResult > 0)
	{
	    subTree.setRight( remove(valToRemove, subTree.getRight() ) );
	}
	//Found a node, does it if have children, if yes, fix the tree for removal
	else if (subTree.getRight() != null && subTree.getLeft() != null ) //our discovered node has two children!!
	{
	    subTree.setData(findMin(subTree.getRight() ).getData() );
	    subTree.setRight(remove(subTree.getData(), subTree.getRight()));
	}

	else
	{
	    subTree = (subTree.getLeft() != null) ? subTree.getLeft() : subTree.getRight();
	}
	
	//updateNodeHeights(subTree);
	return subTree;
    }


    /**
     * An internal method to insert a val into (sub) tree
     * @param insertVal The value we want to insert
     * @param tree The tree we want to insert the val into
     * @return the whole Binary (sub) tree
     */
    protected BinaryNode<E> insert(E insertVal, BinaryNode<E> tree)
    {

	if( tree == null)
	{
	    return new BinaryNode<E>(insertVal, null, null);
	}

	int compareResult = insertVal.compareTo( tree.getData() );

	//value is on the left subtree
	if( compareResult <= 0 ) //remove equals sign if we want to not use duplicates
	{
	    tree.setLeft(insert(insertVal, tree.getLeft()) );
	}

	//value is on the right sub tree
	else if (compareResult > 0)
	{
	    tree.setRight(insert(insertVal, tree.getRight()) );
	}
	else {} // put in for situations where we don't check for equals

	//updateNodeHeights(tree);
	return tree;
    }


    //private method section
    /**
     * Find the height of the tree
     * @param binaryNode the 
     * @return the height of the tree
     */
    @SuppressWarnings("unused")
    protected int height(BinaryNode<E> binaryNode)
    {
	if(binaryNode == null)
	{
	    return 0;
	}
	else
	{
	    return 1 + Math.max(height(binaryNode.getLeft()), height(binaryNode.getRight()) );
	}
    }

    /**
     * update all the heights of the the nodes in the tree
     * @param subtree the tree to update the node of
     * @return the current height of the subtree plus one more 
     * for the traversal
     */
    protected int updateNodeHeights(BinaryNode<E> subtree)
    {
        if( subtree == null)
        {
            return 0;
        }
    
        subtree.setHeight( Math.max(updateNodeHeights( subtree.getLeft() ), updateNodeHeights( subtree.getRight() )) );
    
        return subtree.getHeight() + 1;
    }


    /**
     * Find the maximum value in the binary Search tree
     * @param subTree the binarySearch tree to find the max value in 
     * @return  the node object containing the max value
     */
    @SuppressWarnings("unused")
    private BinaryNode<E> findMax( BinaryNode<E> subTree)
    {
	if( subTree != null )
	{
	    while (subTree.getRight() != null )
	    {
		subTree = subTree.getRight();
	    }
	}
	return subTree;
    }
}



public class AvlNode< E extends Comparable<? super E>> extends BinarySearchTree<E>
{
   
    //private BinaryNode<E> 	root;

    public AvlNode()
    {
	root = null;
    }
    /**
     * constructor with initial data
     * @param data val to initialize the tree with
     */
    public AvlNode(E data)
    {
	root = new BinaryNode<E>(data, null, null);
	root.setHeight(0);
    }
    
    /**
     * constructor with initializations with data and left, and
     * right subtree. Assumptions that passed in left and right
     * subtrees is already balanced
     * @param data
     * @param left
     * @param right
     */
    public AvlNode(E data, BinaryNode<E> left, BinaryNode<E> right)
    {
	root = new BinaryNode<E>( data, left, right );
	root.setHeight(0);
    }
    
    public int height()
    {
	return height(root);
    }
    
    /* (non-Javadoc)
     * @see BinarySearchTree#insert(java.lang.Comparable)
     */
    @Override
    public void insert(E valToInsert)
    {
	root = insert(valToInsert, root);
	//super.updateNodeHeights(root);
	//BinaryNode<E> subtree = root;
//	while( subtree != null)
//	{
//	    balance(subtree.getLeft());
//	    balance(subtree.getRight());
//	    //balance(subtree.getLeft().getRight() );
//	    //balance(subtree.getRight().getLeft() );
//	    subtree = subtree.getLeft();
//	}
	//root = balanceSubtrees(root);
	//root = balance(root);
	
    }
    
    protected BinaryNode<E> insert(E x, BinaryNode<E> tree)
    {
        if (tree == null)
        {
            tree = new BinaryNode<E>(x);
        }
        else if ( x.compareTo(tree.getData() ) < 0 )
        {
            tree.setLeft( insert( x, tree.getLeft() ) );
            if( height( tree.getLeft() ) - height( tree.getRight() ) == 2 )
            {
                if( x.compareTo(tree.getLeft().getData() ) < 0 )
                {
                    tree = rotateWithLeftChild( tree );
                    System.out.println("Single left rotation : " + tree.getData());
                }
                else
                {                  
                    tree = doubleWithLeftChild( tree );
                    System.out.println("Double left rotation : " + tree.getData());
                }
            }
        }
        else if( x.compareTo(tree.getData() ) > 0 )
        {
            tree.setRight( insert( x, tree.getRight() ) );
            if( height( tree.getRight() ) - height( tree.getLeft() ) == 2 )
            {
                if( x.compareTo( tree.getRight().getData() ) > 0)
                {
                    tree = rotateWithRightChild( tree );
                    System.out.println("Single right rotation : " + tree.getData());
                }
                else
                {
                    tree = doubleWithRightChild( tree );
                    System.out.println("Double right rotation : " + tree.getData() );
                }
            }
        }
        else
          ;  // Duplicate; do nothing
        tree.setHeight( Math.max( height( tree.getLeft() ), height( tree.getRight() ) ) + 1);
        return tree;
    }
    

    /**
     *  (non-Javadoc)
     * @see BinarySearchTree#remove(java.lang.Comparable)
     */
    @Override
    public void remove( E valToRemove)
    {
        root = super.remove( valToRemove, root);
        super.updateNodeHeights(root);
        root = balance(root);
        
    }

    private BinaryNode<E> balanceSubtrees( BinaryNode<E> subtree)
    {
	if( subtree == null)
	{
	    return subtree;
	}
	
	balance( balanceSubtrees(subtree.getLeft() ) );
	balance( balanceSubtrees(subtree.getRight() ) );
	return subtree;
	
    }


    protected int height( BinaryNode<E> tree)
    {
        return tree == null ? -1 : tree.getHeight();
    }



    private static final int ALLOWED_IMBALANCE = 1; //max allowed imbalance in the AVL tree
    
    /**
     * balances the tree so that no subtree differs by more than height 1
     * @param subtree the subtree to be balanced
     * @return the balanced subtree
     */
    private BinaryNode<E> balance(BinaryNode<E> subtree)
    {
	if( subtree == null)
	{
	    return subtree;
	}
	if( (height(subtree.getLeft() )- height( subtree.getRight() ) )> ALLOWED_IMBALANCE )
	{
	    if(height (subtree.getLeft().getLeft()) >= height( subtree.getLeft().getRight() ) )
	    {
		System.out.print("\n\n Single right rotation: " + subtree.getData() + "\n\n");
		subtree = rotateWithLeftChild( subtree);
		//for part 1 only, delete for part 2
		
	    }
	    else
	    {
		//for part 1 only, delete for part 2
		System.out.print("\n\n Double left-right rotation: " + subtree.getData() + "\n\n");
		subtree = doubleWithLeftChild( subtree );
		
		
	    }
	}
	else
	{
	    if( height( subtree.getRight() ) - height( subtree.getLeft() ) > ALLOWED_IMBALANCE)
	    {
		if( height( subtree.getRight().getRight() ) >= height( subtree.getRight().getLeft() ) )
		{
		  //for part 1 only, delete for part 2
		    System.out.print("\n\n Single left rotation: " + subtree.getData() + "\n\n" );
		    subtree = rotateWithRightChild( subtree );
		  
		}
		else
		{
		   //for part 1 only, delete for part 2
		    System.out.print("\n\n Double right-left rotation: " + subtree.getData() + "\n\n");
		    subtree = doubleWithRightChild( subtree );
		}
	    }
	}
	
	subtree.setHeight( Math.max( height( subtree.getLeft() ), height( subtree.getLeft() )) + 1);
	return subtree;
    }
    
    /**
     * Rotate binary tree node with left child.
     * This is a single rotation for case 1.
     * Update heights, then return the new root.
     * @param the root node of the tree to be balanced
     * @return the new balanced subtree
     */
    private BinaryNode<E> rotateWithLeftChild( BinaryNode<E> k2 )
    {
	
	
	BinaryNode<E> k1 = k2.getLeft();
	k2.setLeft( k1.getRight() );
	k1.setRight(k2);
	k2.setHeight( Math.max(height( k2.getLeft() ), height( k2.getRight() ) ) + 1 );
	k1.setHeight( Math.max( height( k1.getLeft() ), height(k2) ) + 1 );
	return k1;
    }
    
    /**
     * Rotate binary tree node with right child.
     * This is a single rotation for case q.
     * Update heights, then return the new root.
     * @param k2 the root node of the tree to be balanced
     * @return the new balanced subtree
     */
    private BinaryNode<E> rotateWithRightChild( BinaryNode<E> k2 )
    {
	
		
	BinaryNode<E> k1 = k2.getRight();
	k2.setRight(k1.getLeft() );
	k1.setLeft(k2);
	k2.setHeight( Math.max( height( k2.getLeft() ), height( k2.getRight() ) ) + 1);
	k1.setHeight(Math.max(height( k1.getRight() ), k2.getHeight() ) + 1);
	return k1;
    }
    
    
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     * Update heights, then return new root.
     * @param k3
     * @return
     */
    private BinaryNode<E> doubleWithLeftChild( BinaryNode<E> k3 )
    {
	if(k3.getLeft().getRight() == null )
	    System.out.print("NULL POINTER!!! \n\n");
	k3.setLeft( rotateWithRightChild( k3.getLeft() ) );
	return rotateWithLeftChild( k3 );
    }
    
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k3 with new right child.
     * For AVL trees, this is a double rotation for case 2.
     * Update heights, then return new root.
     * @param k3
     * @return
     */
    private BinaryNode<E> doubleWithRightChild( BinaryNode<E> k3 )
    {
	
	
	k3.setRight(rotateWithLeftChild( k3.getRight() ) );
	return rotateWithRightChild( k3 );
	
    }

    
  
}

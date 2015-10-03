import java.util.ArrayList;

public class tester
{

    public static void main(String[] args)
    {

	//boolean variables to turn on tests we actually want to run
	boolean testa = false; //set variable to run first test of project 1
	boolean testb = false;
	boolean part1aTest = false;
	boolean part1bTest = false;

	//my own personal test
	if( testa)
	{

	    // TODO Auto-generated method stub

	    //		create our sample array, an easy test. We
	    //		will do a random array later;

	    int vals[] = {4, 2, 6, 8, 9, 5, 1, 3};

	    /**
	     * create our object for testing
	     */
	    BinarySearchTree<Integer> treeTest1 = new BinarySearchTree<Integer>();

	    for ( int i = 0; i < vals.length; i++ )
	    {
		treeTest1.insert(vals[i]);
	    }

	    //check that the height function is working properly

	    String heightMessage = "The height of the tree is ";
	    System.out.println(heightMessage + treeTest1.height() + "\n \n");

	    String bst_heading = "Binary Search Tree";
	    printBST_Tree(treeTest1, bst_heading);

	}

	if ( part1aTest )
	{

	    //Perform the requirements of the assignment below

	    BinarySearchTree<Integer> treeTest2 = new BinarySearchTree<Integer>();

	    //generate a binary tree that is height 5
	    while(treeTest2.height() != 5)
	    {
		treeTest2.makeEmpty();
		//place items into Binary Tree
		for(int i = 0; i < 32; i++)
		{
		    int valueToPutInTree = (int)(Math.random()*100);
		    if(valueToPutInTree >= 10)
		    {
			treeTest2.insert(valueToPutInTree);
		    }

		}
	    }

	    //print the tree
	    String bst_heading = "Binary Search Tree of Height 5";
	    printBST_Tree(treeTest2, bst_heading);


	    //repeatably delete the root node
	    //System.out.print("/n/n continually deleting root and printing tree /n/n");
	    bst_heading = "Binary Search tree root deleting ";

	    while( !treeTest2.isEmpty())
	    {
		int rootVal = treeTest2.getRoot().getData();
		treeTest2.remove(rootVal);

		printBST_Tree(treeTest2, bst_heading + rootVal );

	    }
	}

	//personal avl test
	if( testb )
	{
	    int vals[] = {20, 15, 25, 12, 16, 17, 18, 19};

	    AvlNode<Integer> avlTree = new AvlNode<Integer>();

	    for( int i = 0; i < vals.length; i++)
	    {
		avlTree.insert(vals[i]);
		System.out.print("\n\n height is " + avlTree.height() + "\n\n");
		printBST_Tree(avlTree, "AVL tree");
	    }

	}

	if ( part1bTest )
	{

	    //Part 1 B AVL tree testing

	    int[] avlVals = new int[35];

	    //System.out.println("values to insert: ");

	    for( int i = 0; i < 35; i++ )
	    {
		int insertVal = (int)(Math.random()*100);
		while (insertVal < 10 )
		{
		    insertVal = (int)(Math.random()*100);
		}
		avlVals[i] = insertVal;
		//System.out.print(insertVal + "\n");
	    }

	    //insert into our avl tree

	    AvlNode<Integer> avlTree = new AvlNode<Integer>();

	    for( int i = 0; i < 35; i++)
	    {
		avlTree.insert(avlVals[i]);
		printBST_Tree(avlTree, "Printing Tree");
	    }

	    //delete root node until tree empty

	    System.out.print ("\n\n Deleting the tree now \n\n");

	    while(!avlTree.isEmpty())
	    {
		avlTree.remove(avlTree.getRoot().getData());
		printBST_Tree(avlTree, "Deleting Tree");
	    }

	}

	boolean part2 = true;

	if( part2 )
	{
	    final int[] N = {1000, 10000, 100000, 1000000};

	    int[][] treeVals = new int[N.length][N[3]];

	    //double[] treeVals = new double[100000];
	    for(int j = 0; j < N.length; j++)
	    {

		insertRandomNums( treeVals[j], N[j]);
		

		//insert vals into BST tree
		BinarySearchTree<>
		for(int i = 0; i < N[0]; i++)
		{
		    
		    
		    //System.out.print(treeVals[j][i] + "\n");
		}
		
		

	    }


	}


    }

    public static void printBST_Tree(BinarySearchTree<Integer> tree, String heading)
    {

	TreePrinter treePrintObj2 = new TreePrinter(tree);
	treePrintObj2.print(heading);
    }

    public static void insertRandomNums( int[] arry, int maxVal )
    {
	for( int i = 0; i < maxVal; i++ )
	{
	    int insertVal = (int)( Math.random()*maxVal);
	    while (insertVal < 10 )
	    {
		insertVal = (int)( Math.random()*maxVal);
	    }
	    arry[i] = insertVal;
	    //System.out.print(insertVal + "\n");
	}
	//return arry;
    }



}

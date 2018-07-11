package com.asim.interviewr2;



public class BST
{


    public Node root;	// References the root node of the BST

    public BST()
    {
        root = null;
    }

    public static void main (String[] args){
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node (30);
        Node n4 = new Node (40);
        Node n5 = new Node (50);
        Node n6 = new Node (3);
        Node n7 = new Node (5);
        Node n8 = new Node (43);
        Node n9 = new Node (33);
       Node root=new Node (2);
       root.left=n2;
       root.right=n1;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        n3.left=n7;
        n3.right=n8;
        n4.right=n9;
        n4.left=null;
        n6.left=null;
        n6.right=null;
        n7.right=null;
        n7.left=null;
        n8.left=null;
        n8.right=null;
        n9.right=null;
        n9.left=null;
        BST object1=new BST();
        //object1.printInorder(root);
        object1.remove(30);
        object1.remove(50);
        object1.printInorder(root);
    }

   /* ================================================================
      findNode(k): find node with key k

      Return:  reference to (k,v) IF k is in BST
               set myParent to parent node (used by put() and remove())
      ================================================================ */

    public Node myParent;   // Used by findNode() to save parent node

    public Node findNode(double x)
    {
        Node curr_node;   // Help variable
        Node prev_node;   // Help variable

       /* --------------------------------------------
	  Find the node with search value == "x" in the BST
          -------------------------------------------- */
        curr_node = root;  // Always start at the root node
        prev_node = root;  // Remember the previous node for insertion

        while ( curr_node != null )
        {
            if ( x == curr_node.value )
            {
                // Found search value in BST
                myParent = prev_node;        // Set myParent
                return curr_node;
            }
            else if ( x < curr_node.value  )
            {
                prev_node = curr_node;       // Remember prev. node
                curr_node = curr_node.left;  // Continue search in left subtree
            }
            else //  This must be true: ( x > curr_node.value )
            {
                prev_node = curr_node;       // Remember prev. node
                curr_node = curr_node.right; // Continue search in right subtree
            }
        }

       /* ======================================
	  When we reach here, x is NOT in BST
          ====================================== */
        myParent = prev_node;            // Set myParent
        return null;		        // Return not found
    }


    /* ================================================================
       put(x): store (x) into the BST

          1. if the search value "x" is found in the BST, don't insert
          2. if the search value "x" is NOT found in the BST, we insert
         a new node containing (x)
       ================================================================ */
    public void put(int x)
    {
        Node p;   // Help variable

       /* ----------------------------------------------------------
	  Just like linked list, insert in an EMPTY BST
	  must be taken care off separately by an if-statement
          ---------------------------------------------------------- */
        if ( root == null )
        {  // Insert into an empty BST

            root = new Node( x );
            return;
        }

       /* ----------------------------------------------------
	  Find the node with search value == "x" in the BST
          ---------------------------------------------------- */
        p = findNode(x);

        if ( p != null )
        {
            return;          // x is already there.... don't insert again
        }

       /* --------------------------------------------
	  Insert a new node (x) under myParent !!!
          -------------------------------------------- */
        Node q = new Node( x );

        if ( x < myParent.value )
            myParent.left = q;            	// Add q as left child
        else
            myParent.right = q;           	// Add q as right child
    }


    /* =======================================================
       remove(x): delete node containg search value x
       ======================================================= */
    public void remove(int x)
    {
        Node p;        // Help variable
        Node parent;   // parent node
        Node succ;     // successor node

       /* --------------------------------------------
          Find the node with search value == "x" in the BST
          -------------------------------------------- */
        p = findNode(x);

        if ( p == null )
            return;			// Not found ==> nothing to delete....



        if ( p.left == null && p.right == null ) // Case 0: p has no children
        {
            if ( p == root )
            {
                root = null;
                return;
            }

            parent = myParent;     // myParent was set by findNode(x)....

	  /* --------------------------------
	     Delete p from p's parent
	     -------------------------------- */
            if ( parent.left == p )
                parent.left = null;
            else
                parent.right = null;

            return;
        }

        if ( p.left == null )                 // Case 1a: p has 1 (right) child
        {
            if ( p == root )
            {
                root = root.right;
                return;
            }

            parent = myParent;     // myParent was set by findNode(x)....

	  /* ----------------------------------------------
	     Link p's right child as p's parent child
             ---------------------------------------------- */
            if ( parent.left == p )
                parent.left = p.right;
            else
                parent.right = p.right;

            return;
        }

        if ( p.right== null )                 // Case 1b: p has 1 (left) child
        {
            if ( p == root )
            {
                root = root.left;
                return;
            }

            parent = myParent;     // myParent was set by findNode(x)....

          /* ----------------------------------------------
             Link p's left child as p's parent child
             ---------------------------------------------- */
            if ( parent.left == p )
                parent.left = p.left;
            else
                parent.right = p.left;

            return;
        }



        if ( p.right.left == null )
        {
          /* ======================================================
	     Special case: the right node of p IS the successor !
	     Replace p with p.right
	     ====================================================== */
            p.value = p.right.value;         // Replace p value
            p.right = p.right.right;         // Replace p right subtree

            return;                       // Done
        }

        succ = p.right;                  // p has 2 children....
        Node succParent = p;             // Init. p as the parent of succ

       /* ----------------------------------
          Find the successor node of p
          --------------------------------- */
        while ( succ.left != null )
        {
            succParent = succ;           // Track succ's parent
            succ = succ.left;
        }

        p.value = succ.value;           // Replace p with successor info.
        succParent.left = succ.right;   // Link right tree to parent's left
    }




  public void printInorder(Node node)
  {
      if (node == null)
          return;

        /* first recur on left child */
      printInorder(node.left);

        /* then print the data of node */
      System.out.print(node.value + " " + "\n" + "--Node===");

        /* now recur on right child */
      printInorder(node.right);
  }

}
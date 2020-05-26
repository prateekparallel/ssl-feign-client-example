package com.java.algirithm;

//you can also use imports, for example:
import java.util.*;


class Tree {
	public int x;
	public Tree l;
	public Tree r;
}

class Solution {
	
	boolean isBalanced(Tree node) 
    { 
        int lh; /* for height of left subtree */
  
        int rh; /* for height of right subtree */
  
        /* If tree is empty then return true */
        if (node == null) 
            return true; 
  
        /* Get the height of left and right sub trees */
        lh = height(node.l); 
        rh = height(node.r); 
  
        if (Math.abs(lh - rh) <= 1
            && isBalanced(node.l) 
            && isBalanced(node.r)) 
            return true; 
  
        /* If we reach here then tree is not height-balanced */
        return false; 
    } 
  
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the 
        number of nodes along the longest path from the root node 
        down to the farthest leaf node.*/
    int height(Tree node) 
    { 
        /* base case tree is empty */
        if (node == null) 
            return 0; 
     /* If tree is not empty then height = 1 + max of left 
         height and right heights */
        return 1 + Math.max(height(node.l), height(node.r)); 
    }
	
    public static int depth = 0;
	public int inOrder(Tree node) {
		if (node == null) {
			return 0;
		}
		inOrder(node.l);
		System.out.printf("%s ", node.x);
		depth ++;
		inOrder(node.r);
		return depth;
	}
	
	
	public Tree findBestBalanceNode(Tree node) {
   		Tree t = null;
		
        if (node == null) 
            return null; 
  
        if (isBalanced(node)) {
        	System.out.println("yes");
        	return node;
        }
        else if (isBalanced(node.r)) {
        	return node.r;
        }
        //else if (isBalanced(node.l)) {
        	//return node.l;
        //}
        int ld = inOrder(node.l);
        Solution.depth = 0;
        int rd = inOrder(node.r);
        if(ld > rd ) {
        	System.out.println("Hmm " + ld);
        	t = findBestBalanceNode(node.l);
        }
        else {
        	t = findBestBalanceNode(node.r);
        }
        
        return t;
    } 

	public int solution(Tree t) {
		// write your code in Java SE 8
		// check left of the tree
		Tree p = null;
		int d = inOrder(t.l);
		Solution.depth = 0;
		int d2 = inOrder(t.r);
		if (d2 > d) {
		    p = t.r;
		}
		else
			p = t.l;
		return p.x;
	}

}

public class TestJavaCode {
	/*
	 * public void createTree(Tree r, int val) { Tree q = r; while(true) { if(q ==
	 * null) { q = new Tree(); q.x = 1; q.l = null; q.r = null; if(q.x ) } } }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree root = new Tree();
		root.x = 1;
		root.l = new Tree();
		root.l.x = 2;
		root.l.r = new Tree();
		root.l.r.x = 4;
		root.l.r.l = null;
		root.l.r.r = null;

		Tree p = root;

		p.r = new Tree();
		p = p.r;
		p.x = 3;
		p.r = new Tree();
		p.l = null;
		p = p.r;
		p.x = 20;
		Tree q = p;
		p.l = new Tree();
		p = p.l;
		p.x = 5;
		p.l = new Tree();
		p = p.l;
		p.x = 7;
		p.l = null;
		p.r = null;

		p = q.l;
		p.r = new Tree();
		p.r.x = 8;
		p.r.l = null;
		p.r.r = null;

		p = q;
		p.r = new Tree();
		p = p.r;
		p.x = 6;
		q = p;
		p.l = new Tree();
		p = p.l;
		p.x = 9;
		p.l = null;
		p.r = null;
		p = q;
		p.r = new Tree();
		p = p.r;
		p.x = 10;
		p.r = null;
		p.l = new Tree();
		p = p.l;
		p.x = 11;
		p.l = null;
		p.r = null;
		
		Solution sol = new Solution();
		//sol.inOrder(root);
		Tree t = sol.findBestBalanceNode(root);
		System.out.println("Best Balanced Node " + t.x);
		
	}

}

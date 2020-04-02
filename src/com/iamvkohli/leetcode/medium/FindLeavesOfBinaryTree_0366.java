package com.iamvkohli.leetcode.medium;
import java.util.*;
import com.iamvkohli.leetcode.commons.TreeNode;

/*
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 */
public class FindLeavesOfBinaryTree_0366 {

	
    //Traverse Tree and collect all leaves
    public TreeNode getLeaves(TreeNode root, ArrayList<Integer> leaves){
        if(root.left==null && root.right==null){
            leaves.add(root.val);
            root=null;
        }else{
            if(root.left!=null ) root.left = getLeaves(root.left, leaves);    
            if(root.right!=null) root.right = getLeaves(root.right, leaves);
        }
        return root;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        
        //Temporary list to store leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        boolean flag = true;
        
        //keep on collecting leaves till root becomes a leaf
        while(flag){
            if((root.left==null)&&(root.right==null)) flag = false;
                
            getLeaves(root, leaves);  //method to get list of current leaves
            result.add(leaves); //addition to the result
            leaves = new ArrayList<Integer>(); //declaring a new list
        }
        return result;        
    }
}


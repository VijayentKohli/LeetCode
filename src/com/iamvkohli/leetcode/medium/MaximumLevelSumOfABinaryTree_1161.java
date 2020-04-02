package com.iamvkohli.leetcode.medium;
import java.util.*;
import com.iamvkohli.leetcode.commons.TreeNode;;;

/*
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */

public class MaximumLevelSumOfABinaryTree_1161 {
	 public int maxLevelSum(TreeNode root) {
	        if(root==null) return 0;
	        if(root.left==null && root.right==null) return root.val;
	        
	        ArrayList<Integer> sums = new ArrayList<>();
	        dfs(sums, root, 1);//Starting with root i.e level 1
	        
	        int result = sums.stream().max(Comparator.comparing(Integer::valueOf)).get();
	        return result;
	    }
	    
	    public void dfs(ArrayList<Integer> sums, TreeNode root, int level){
	        if(root==null){
	            return;
	        }
	        //Add new element with every level
	        if(sums.size()<level){
	            sums.add(0);
	        }
	        
	        int updatedSum = sums.get(level-1)+root.val;
	        sums.add(level-1, updatedSum);
	        
	        dfs(sums, root.left, level+1);
	        level--;
	        dfs(sums, root.left, level+1);
	        level--;
	    }
	    
	    public static void main(String[] args) {
			
		}
}

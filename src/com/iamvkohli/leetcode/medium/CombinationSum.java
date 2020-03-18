package com.iamvkohli.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/

public class CombinationSum {
    
    static List<List<Integer>> result= new ArrayList<>();
 
    
    private static void dfs( List<Integer> path, int[] nums, int target, int curSum, int idx){
        if (curSum == target){
            System.out.println("***==MATCHED==***");
        	result.add(new ArrayList<>(path));
            return;
        }
        if (curSum > target) {
        	System.out.println("==SIYAAPA==");
        	return;
        }
        for (int i = idx; i < nums.length; i++){
        	
            if (curSum + nums[i] > target) {
            	System.out.println("i="+i+"\tIndex="+idx+"\tValue="+nums[i]+"\tCurSum="+(curSum+nums[i]));
            	System.out.println("==BREAK==");
            	break;
            }
            path.add(nums[i]);
            System.out.println("B4 DFS\t i="+i+"\tIndex="+idx+"\tValue="+nums[i]+"\tCurSum="+(curSum+nums[i]));
            dfs(path, nums, target, curSum + nums[i], i);
            System.out.println("AFTER DFS\t i="+i+"\tIndex="+idx+"\tValue="+nums[i]+"\tCurSum="+(curSum+nums[i]));
            path.remove(path.size() - 1);
        }
    }
    
    
    public static void helper(int[] candidates, int target, int left, int right, List<Integer> curList ){
        System.out.println("Target = "+target+"\tLeft="+left+"\tRight="+right);
        if((left>right)){
            return;
        }
        int sum = target - candidates[left];
        if(sum<0){
            return;
        }
        
        System.out.println("SUM = "+sum);
        if(sum == 0){
            System.out.println("----Candidate found-----\n");
            curList.add( candidates[left]  );
            for(int i:curList){
                System.out.print(i+"->");
            }
            System.out.println();
            
            result.add(new ArrayList<Integer>(curList));
            curList.remove(curList.size()-1);
            return;
        }
        
        
        //Including the index
        System.out.println("\tRECURSE same, Target = "+sum+" SAME Left="+left);
        curList.add(candidates[left]);
        helper(candidates, sum, left, right, curList );
        
        
        //Not including the index
        System.out.println("RECURSE without current, Target = "+target+"  Next Left="+(left+1));
        curList.remove(curList.size()-1);
        helper(candidates, target, left+1, right, curList);
        
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	
        Arrays.sort(candidates);
//        helper(candidates, target, 0, candidates.length-1, new ArrayList<Integer>() );
        
        //Another solution
        dfs(new ArrayList<Integer>(), candidates, target, 0, 0);
        return result;
    }
    
    public static void main(String[] args) {
    	
		
    	int[] arr1 = new int[] {2,3,6,7};
    	int[] arr2 = {2,3,5};
    	int[] arr3 = {8,7,4,3};
    	int [] arr4 = {8, 10, 6, 11, 1, 16, 8};
    	
    	combinationSum(arr4, 28);
//    	combinationSum(arr2, 8); 
//    	combinationSum(arr3, 11);
	}
}
package com.iamvkohli.leetcode.medium;

//https://leetcode.com/problems/max-increase-to-keep-city-skyline/

public class MaxIncreaseToKeepCitySkyline {

	
    public static int[] getSkyline(int[][] grid, Boolean isTop){
        
        int max=-1;
        int[] result;
        if(isTop){
            result = new int[grid[0].length];
            for(int col=0; col<grid[0].length; col++){
                max=-1;
                for(int row=0; row<grid.length; row++){
                    if(max < grid[row][col]){
                        max = grid[row][col];
                    }
                }
                result[col]=max;
            }
        }
        else{
            result = new int[grid.length];
            for(int row=0; row<grid.length; row++){
                max=-1;
                for(int col=0; col<grid.length; col++){
                    if(max < grid[row][col]){
                        max = grid[row][col];
                    }
                }   
                result[row]=max;
            }
        }
        
        return result;
    }
    
    
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int numCol = grid[0].length;
        int numRow = grid.length;
        
        int [] colLine = getSkyline(grid, true);
        int [] rowLine = getSkyline(grid, false);
        
        int[][] gridNew = new int[numRow][numCol];
        int totalSum =0;
        
        for(int i=0; i<numRow; i++){
            for(int j=0; j<numCol; j++){
                gridNew[i][j]= colLine[j]>=rowLine[i] ? rowLine[i] : colLine[j];
                totalSum += gridNew[i][j]-grid[i][j];
            }
        }
        
        
        return totalSum;
        
        
    }
    
    public static void main(String[] args) {
		int [][] grid = { {3, 0, 8, 4}, 
		                  {2, 4, 5, 7},
		                  {9, 2, 6, 3},
		                  {0, 3, 1, 0} };
		System.out.println(maxIncreaseKeepingSkyline(grid));
	}
}

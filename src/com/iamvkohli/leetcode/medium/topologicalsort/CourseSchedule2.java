package com.iamvkohli.leetcode.medium.topologicalsort;

public class CourseSchedule2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[]{};
        if (numCourses == 1) return new int[]{0};
        int[] parent = new int[numCourses];//parent[i] => i is parent of parent[i] courses
        for (int[] prerequisite : prerequisites) 
        	parent[prerequisite[1]]++;
        
        boolean[] visited = new boolean[prerequisites.length];
        boolean[] mark = new boolean[numCourses];
        boolean flag = true;
        int idx = numCourses - 1;
        int[] res = new int[numCourses];
        
        
        while (flag) {
            flag = false;
            
            for (int i = 0; i < prerequisites.length; i++) {
            	
                if (!visited[i]) {//For each unvisited course 
                    if (parent[prerequisites[i][0]] == 0) {// check if the course is not parent of any other course
                        visited[i] = true;
                        if (!mark[prerequisites[i][0]]) {
                            mark[prerequisites[i][0]] = true;
                            res[idx] = prerequisites[i][0];//Put this course at last
                            idx--;
                        }
                        parent[prerequisites[i][1]]--;//remote ith course and decrement its parent value
                        flag = true;
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if(parent[i]!=0) return new int[]{};
        }
        for (int i = 0; i < numCourses && idx >= 0; i++) {
            if(!mark[i]) {
                res[idx] = i;
                idx--;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int[][] input =  {{1,0},{2,0},{3,1},{3,2}};
		int[] result = findOrder(4, input);
	}
}
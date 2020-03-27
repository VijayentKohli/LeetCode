package com.iamvkohli.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*(
 * https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels_763 {

	
	public List<Integer> partitionLabels(String S) {
        int[] first = new int[26];
        int [] last = new int[26];
        
        for(int i=0; i<26;  i++){
            last[i]= -1;
        }
        
        int len = S.length();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i< S.length(); i++){
            int idx = S.charAt(i) -'a';
            if(first[idx]==1){
                first[idx]=i;
            }
            last[idx]=i;
        }
        
        int start=0;
        int end=last[S.charAt(0) - 'a'];
        int i=0;
        
        while(end<S.length() && i<S.length()){
            char c = S.charAt(i);
            int lst = last[c-'a'];
            end = Math.max(end, lst);
            
            if(i==S.length()-1){
                System.out.println(len-start);
                result.add(end-start+1);
                break;
            }
            else if(start==end){
                System.out.println(end-start+1);
                result.add(end-start+1);
                start=end+1;
            }
            else if(i<len && i==end){  
                System.out.println(end-start+1);
                result.add(end-start+1);
                start=end+1;
            }
            i++;
        }
        
        return result;
        
    }
	
	
	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		String s2 = "caedbdedda";
		PartitionLabels_763 instance1 = new PartitionLabels_763();
		ArrayList<Integer> result = (ArrayList<Integer>) instance1.partitionLabels(s2);
		
	}
}

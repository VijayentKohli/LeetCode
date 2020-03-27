package com.iamvkohli.leetcode.medium;
import java.util.*;


/*
 * https://leetcode.com/problems/word-ladder/
 */

public class WordLadder_0127 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
    	if(beginWord.equals(endWord)) return 0;
        
        HashSet<String> hs = new HashSet<String>(wordList);
        HashSet<String> visited = new HashSet<String>();
        
        LinkedList<String> ll = new LinkedList<String>();
        ll.add(beginWord);
        visited.add(beginWord);
        ll.add(null);
        int result = 1;
//        int min = 1;
        
        while(!ll.isEmpty()){
            String cur = ll.poll();
            if(cur==null){
                if(ll.isEmpty()){
                    return 0;
                }
                result++;
                ll.add(null);
                continue;
            }
            
//            char[] 
            
            /*
             * Step 1 - Get new string by changing a char
             * Step 2 - Check if that string is present in dictionary, else continue
             * Step 3 - If present, check if that string is the endword, 
             * 			if not, add to the linkedList  
             */

                
            for(int i=0; i<cur.length(); i++){
                for(int j=0; j<26; j++){
                	// String next = cur.replace(cur.charAt(i), (char)(j+'a')) ; - DOES NOT WORK, it replaces all chars of the string with new character
                	String next = cur.substring(0,i)+(char)('a'+j)+cur.substring(i+1);
                	
                	if(next.contentEquals(endWord)) {
                		return result+1;
                	}
                	
                	if( hs.contains(next) && !visited.contains(next)) {
                		ll.add(next);
                		visited.add(next);
                	}
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
//    	String beginWord = "hit";
//    	String	endWord = "cog";
//    	List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
    	
    	String beginWord = "leet";
    	String	endWord = "code";
    	List<String> wordList = Arrays.asList("lest","leet","lose","code","lode","robe","lost");
    	int result1 = ladderLength(beginWord, endWord, wordList);
    	System.out.println(result1);
 
	}
}

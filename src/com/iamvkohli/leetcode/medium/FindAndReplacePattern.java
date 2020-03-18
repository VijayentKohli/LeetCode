package com.iamvkohli.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {

	
    
    public HashMap<Character, ArrayList<Integer>> getPatternMap(String word){
         //To Store patten of Char -- List Of Indices of occurence 
        HashMap<Character, ArrayList<Integer>> hMap = new HashMap<Character, ArrayList<Integer>>();
        
        char[] pttrn = word.toCharArray(); 
        
        for(int i=0; i<word.length(); i++){
            if(!hMap.containsKey(pttrn[i])){
                ArrayList<Integer> aList = new ArrayList<Integer>();
                aList.add(i);
                hMap.put(pttrn[i], aList);
            }
            else{
            	ArrayList<Integer> list2 = hMap.get(pttrn[i]);
            	list2.add(i);
                hMap.put(pttrn[i], list2);
//                hMap.put(pttrn[i],  hMap.get(pttrn[i]).add(i) );
            }
        }
        return hMap;
    }
    
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        //Understand the pattern
        HashMap<Character, ArrayList<Integer>> hMap_P = getPatternMap(pattern);
        
        ArrayList<String> result = new ArrayList<String>();
        
        for(String word : words){
            HashMap<Character, ArrayList<Integer>> cur = getPatternMap(word);
            
            //Compare if pattern matches 
            if(new ArrayList<>( cur.values() ).equals(new ArrayList<>( hMap_P.values() )) ){
                result.add(word);
            }
        }
        
        return result;
        
    }
}

package com.iamvkohli.leetcode.easy;
//https://leetcode.com/problems/repeated-substring-pattern/

public class RepeatedSubstringPattern {
    
    // abab
    public static boolean repeatedSubstringPattern(String str) {

        if ( (str==null) || (str.length()==0) ) {
            return false;
        }

        for (int i=1;i<=str.length()/2;i++) {
            String subStr = str.substring(0,i);
            System.out.println("i="+i);
            if (_isRepeat(subStr, str.substring(i))) {
                return true;
            }
        }
        
        return false;
    }
    // ab, ab
    private static boolean _isRepeat(String curr, String remain) {
        if (remain.length()==0) {
            return true;
        }
        System.out.println("CURR:"+curr+"  remain--"+remain);
        int s = 0;
        int e = curr.length();
        
        if (e <= remain.length()) {
            String remainSub = remain.substring(s, e);
            System.out.println("e:"+e+"  remainSub--"+remainSub);
            if (remainSub.equals(curr)) {
                return _isRepeat(curr, remain.substring(e, remain.length()));
            }
        }
        
        return false;
    }
    
    
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s == null || s.length() < 2) {
                return false;
            }

            return evenPattern(s) || oddPattern(s);

        }

        private boolean evenPattern(String s) {
            int length = s.length();

            if (length % 2 != 0) {
                return false;
            }
            

            if(!s.substring(0, length/2).equals(s.substring(length/2, length))) {
                return false;
            }
            return true;
        }

        private boolean oddPattern(String s) {
            int length = s.length();

            outer: for (int i=3; i<=length; i+=2) {
                if (length % i != 0) {
                    continue;
                }
                int subLen = length/i;
                String first = s.substring(0, subLen);

                for (int j = 1; j<i; j++) {
                    if (!first.equals(s.substring(j*subLen, (j+1)*subLen))) {
                        continue outer;
                    }
                }
                //System.out.println("here");
                return true;
            }

            return false;
        }
    }
  
    /* ***************************** 
	 * BEST SOLUTION ON LEETCODE START
	 */
    public static boolean repeatedSubstringPatternBest(String s) {
        int stringLength = s.length();
		int repeatLength = 1;
		for (int i = stringLength / 2; i > 0; i--) {
			System.out.println("i="+i);
			if (stringLength % i == 0) {
				repeatLength = i;
				System.out.println("repeatLength="+repeatLength);
				System.out.println("Substring="+s.substring(0, repeatLength - 1));
				System.out.println("Substring2="+s.substring(repeatLength, repeatLength + repeatLength - 1));
				if (s.substring(0, repeatLength - 1).equals(s.substring(repeatLength, repeatLength + repeatLength - 1)))
					break;
			}
		}
		String repeatedString = s.substring(0, repeatLength);
		System.out.println("repeatedString="+repeatedString);
		for (int i = repeatLength; i <= stringLength - repeatLength; i += repeatLength) {
			System.out.println("Substring3="+  s.substring(i, i + repeatLength) );
			if (!repeatedString.equals(s.substring(i, i + repeatLength)))
				return false;
		}
		return repeatLength != stringLength;
    }
    /*
  	 * BEST SOLUTION ON LEETCODE ENDS
  	 * ***************************** 
  	 */
    
    public static boolean repeatedSubstringPattern2ndBest(String s) {
        int l = s.length();
        int i = l / 2;
        for (; i >= 1; i--) {
            if (l % i == 0) {
                if (s.startsWith(s.substring(0, i), i)) break;
            }
        }
        if (i == 0) return false;
        String tmp = s.substring(0, i);
        StringBuilder sb = new StringBuilder(tmp);
        while (sb.length() < s.length()) sb.append(tmp);
        return sb.toString().equals(s);
    }
    
    
    public static void main (String [] args) {
    	String str1 = "abcabcabc";
    	String str2 = "abcdabc";
    	String str3 = "abababab";
    	
//    	
//    	System.out.println(repeatedSubstringPatternBest(str1));
//    	System.out.println(repeatedSubstringPatternBest(str2));
//    	System.out.println(repeatedSubstringPatternBest(str3));
    	
    	System.out.println(repeatedSubstringPattern2ndBest(str1));
    	System.out.println(repeatedSubstringPattern2ndBest(str2));
    	System.out.println(repeatedSubstringPattern2ndBest(str3));
    	
    }
}
package com.String;

import java.util.HashSet;

/**
 * Created by hunter on 26-Feb-17.
 */
public class LongestSubstringWithoutRepetingCharacter {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int start = 0;
        //set.add(s.charAt(0));

        for(int i = 0 ; i < s.length() ; i++ ) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                maxLen = Math.max(maxLen ,set.size());
            }else {
                while(s.charAt(i) != s.charAt(start)) {
                    set.remove(s.charAt(i));
                    start++;
                }
                start++;
            }
        }
        return maxLen;
    }

    public static void main(String args[]){
        LongestSubstringWithoutRepetingCharacter lsw = new LongestSubstringWithoutRepetingCharacter();
        System.out.println(lsw.lengthOfLongestSubstring("ABCDECAMNCZB"));
    }
}

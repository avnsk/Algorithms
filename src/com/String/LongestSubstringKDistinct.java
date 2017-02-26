package com.String;

import java.util.HashMap;

/**
 * Created by hunter on 26-Feb-17.
 */
public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0)
            return 0;

        if(s.length() < k)
            return  s.length();

        HashMap<Character ,Integer> map = new HashMap();

        int start = 0;
        int maxLen = k;
        for (int i = 0 ; i < s.length() ; i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i) ,1);

            }else {
                map.put(s.charAt(i) ,map.get(s.charAt(i)) + 1);
            }

            if(map.size() > k) {
                maxLen = Math.max(maxLen ,i-start);
                while(map.size() > k) {
                    int c = map.get(s.charAt(start));
                    if (c > 1)
                        map.put(s.charAt(start), c - 1);
                    else
                        map.remove(s.charAt(start));
                    start++;
                }
            }


        }

        maxLen = Math.max(maxLen,s.length()-start);
        return  maxLen;
    }

    public static void main(String args[])
    {
        String s = "aabacbebebe";
        int k = 3;
        System.out.print(new LongestSubstringKDistinct().lengthOfLongestSubstringKDistinct(s,k));

    }
}

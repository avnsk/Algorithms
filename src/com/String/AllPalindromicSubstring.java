package com.String;

import java.util.HashSet;
import java.util.Set;

public class AllPalindromicSubstring {

    public HashSet<String> palindromicStrings(String str) {
        HashSet<String> res = new HashSet<String>();
        int len = str.length();


        for(int i = 0 ; i < len ; i++) {
            res.add(String.valueOf(str.charAt(i))); // case for unit length palindromes
        }
        int low ,high;
        for(int i = 1 ; i < len ; i++) {
            low = i-1;
            high = i;
            while(low >= 0 && high < len && str.charAt(high) == str.charAt(low)) {
                res.add(str.substring(low,high+1));
                low--;
                high++;
            }

            low = i-1;
            high = i+1;
            while(low >= 0 && high < len && str.charAt(high) == str.charAt(low)) {
                res.add(str.substring(low,high+1));
                low--;
                high++;
            }
        }

        return res;
    }

    public static void main(String args[]) {
        AllPalindromicSubstring aps = new AllPalindromicSubstring();
        aps.palindromicStrings("forgeeksskeegfor").forEach(r -> System.out.println(r));
        System.out.println();
        aps.palindromicStrings("a").forEach(r -> System.out.println(r));
        System.out.println();
        aps.palindromicStrings("abaaa").forEach(r -> System.out.println(r));
    }
}

package com.String;

import com.array.MedianOfTwoSortedArrayOfDifferentLength;

/**
 * Created by hunter on 22-Feb-17.
 */
public class KMPSubstringSearch {

    public int[] buildPrefixArray(char pattern[]) {
        int lps[] = new int[pattern.length];

        int index = 0;
        int i = 1;
        while (i < pattern.length) {
            if (pattern[index] == pattern[i]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }

            }
        }
        return lps;

    }

    public boolean kmpSearch(char text[], char pattern[]) {
        int lps[] = buildPrefixArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMPSubstringSearch ss = new KMPSubstringSearch();
        boolean result = ss.kmpSearch(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
    }
}

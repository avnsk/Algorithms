package com.String;

/**
 * Created by hunter on 26-Feb-17.
 */
public class LongestPalindromeSubstring {

    public int longestPalindromeSubstring(char arr[]) {

        int longest_substring = 1;
        for (int i = 0; i < arr.length; i++) {

            int x, y;
            int palindrome;
            x = i;
            y = i + 1;
            palindrome = 0;
            while (x >= 0 && y < arr.length && arr[x] == arr[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            longest_substring = Math.max(longest_substring, palindrome);

            x = i - 1;
            y = i + 1;
            palindrome = 1;
            while (x >= 0 && y < arr.length && arr[x] == arr[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            longest_substring = Math.max(longest_substring, palindrome);
        }
        return longest_substring;
    }


    public static void main(String args[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindromeSubstring("abba".toCharArray()));
        System.out.println(lps.longestPalindromeSubstring("abbababba".toCharArray()));
        System.out.println(lps.longestPalindromeSubstring("babcbaabcbaccba".toCharArray()));
        System.out.println(lps.longestPalindromeSubstring("cdbabcbabdab".toCharArray()));
    }

}

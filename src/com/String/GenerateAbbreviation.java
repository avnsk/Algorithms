package com.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateAbbreviation {
    public Set<String> generate(String word) {
        int n = word.length();
        Set<String> res = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int len = 0; len <= n - i; len++) {
                String a = word.substring(0, i);
                String b = len > 0 ? String.valueOf(len) : "";
                String c = word.substring(i + len);

                res.add(a + b + c);

                if (c.length() >= 2) {
                    Set<String> rest = generate(c.substring(1));

                    for (String d : rest)
                        res.add(a + b + c.substring(0, 1) + d);
                }
            }
        }

        return res;
    }
    public List<String> generateAbbreviations(String word) {
        long size = 1 << word.length();
        List<String> result = new ArrayList<>();
        for (long i = 0; i < size; i++) {
            result.add(generateString(word, i));
        }
        return result;
    }

    public String generateString(String word, long number) {
        StringBuilder sb = new StringBuilder();
        int consecutiveOne = 0;
        for (int i = 0; i < word.length(); i++) {
           // long bit = (number >> i) & 1;
            if ((number &(1 << i )) > 0) {
                consecutiveOne++;
            } else {
                if (consecutiveOne != 0) {
                    sb.append(consecutiveOne);
                    consecutiveOne = 0;
                }
                sb.append(word.charAt(i));
            }
        }
        if (consecutiveOne != 0) {
            sb.append(consecutiveOne);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        GenerateAbbreviation gabr = new GenerateAbbreviation();
        gabr.generateAbbreviations("word").forEach(r->System.out.println(r));
    }
}

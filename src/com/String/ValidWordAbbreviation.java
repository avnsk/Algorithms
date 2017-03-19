package com.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbreviation {
    private Set<String> uniqueWordInDict;
    private Map<String, String> abbrDict;

    public ValidWordAbbreviation(String dictionary[]) {
        uniqueWordInDict = new HashSet<>();
        abbrDict = new HashMap<>();
        for(String word : dictionary) {
            if(!uniqueWordInDict.contains(word)) {
                String abbr = getAbbr(word);
                if(!abbrDict.containsKey(abbr)){
                    abbrDict.put(abbr, word);
                }else{
                    abbrDict.put(abbr, "");
                }
                uniqueWordInDict.add(word);
            }
        }
    }

    public boolean isUnique(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        String abbr = getAbbr(word);
        if(!abbrDict.containsKey(abbr) || abbrDict.get(abbr).equals(word))
            return true;
        else
            return false;
    }

    private String getAbbr(String word) {
        if (word == null || word.length() < 3) {
            return word;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));

        return sb.toString();

    }
    public static void main(String args[]) {
        String[] dictionary = new String[]{"deer", "door", "cake", "card"};
        ValidWordAbbreviation vwa = new ValidWordAbbreviation(dictionary);
       System.out.println(vwa.isUnique("dear")+" "+vwa.isUnique("cart")+" "
        +vwa.isUnique("cane")+ " "
        +vwa.isUnique("make"));
    }


}

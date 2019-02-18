package com.company;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa"));
    }

    public static boolean isPalindromePermutation(String str) {
        String strToLowerCase = str.toLowerCase();
        String strWithoutEmptySpaces = strToLowerCase.replaceAll(" ", "");
        boolean hasOddLength = (strWithoutEmptySpaces.length() % 2 == 1);
        HashMap<Character, Integer> charCounts = new HashMap<>();

        // count each char's occurrences
        for (int i = 0; i < strWithoutEmptySpaces.length(); i++) {
            if (!charCounts.containsKey(strWithoutEmptySpaces.charAt(i)))
                charCounts.put(strWithoutEmptySpaces.charAt(i), 1);
            else {
                int oldCount = charCounts.get(strWithoutEmptySpaces.charAt(i));
                charCounts.replace(strWithoutEmptySpaces.charAt(i), oldCount + 1);
            }
        }

        if (hasOddLength) {
            Iterator it = charCounts.entrySet().iterator();
            int oddCount = 0;

            while (it.hasNext()) {
                HashMap.Entry pair = (HashMap.Entry) it.next();

                if ((int) pair.getValue() % 2 == 1) {
                    oddCount++;

                    if (oddCount > 1)
                        return false;
                }
            }
        } else {

            for (Map.Entry<Character, Integer> characterIntegerEntry : charCounts.entrySet()) {
                HashMap.Entry pair = characterIntegerEntry;
                if ((int) pair.getValue() % 2 == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

// Time Complexity is: O(n)

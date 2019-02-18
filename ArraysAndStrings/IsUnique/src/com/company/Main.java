package com.company;

// Q1.1

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String testString = "ala";
        System.out.println(isUnique(testString));
        System.out.println(isUniqueWithoutDataStructures(testString));
    }

    public static boolean isUnique(String str) {
        HashSet<Character> occurredChars = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (occurredChars.contains(str.charAt(i)))
                return false;
            else
                occurredChars.add(str.charAt(i));
        }

        return true;
    }

    public static boolean isUniqueWithoutDataStructures(String str) {
        char[] stringAsArray = str.toCharArray();
        Arrays.sort(stringAsArray);
        String sortedString = new String(stringAsArray);

        for(int i = 0; i < str.length() - 1; i++)
            if (sortedString.charAt(i) == sortedString.charAt(++i))
                return false;

        return true;
    }
}

// Time Complexity of 1st Algorithm: O(N)
// Time Complexity of 2nd Algorithm: O(NlogN)
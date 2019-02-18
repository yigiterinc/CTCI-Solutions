package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String str1 = "aday";
        String str2 = "fals";
        System.out.println(checkPermutations(str1, str2));
    }

    public static boolean checkPermutations(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        HashSet<Character> occurredChars = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            occurredChars.add(str1.charAt(i));
        }

        for (int i = 0; i < str2.length(); i++) {
            if (!occurredChars.contains(str2.charAt(i)))
                return false;
        }

    return true;
    }
}

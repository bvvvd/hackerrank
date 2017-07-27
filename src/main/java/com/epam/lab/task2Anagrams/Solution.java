package com.epam.lab.task2Anagrams;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class Solution {

    public static int numberNeeded(String first, String second) {
        Map<Character, Integer> secondLineCharacters = getFrequencyMap(second);
        Map<Character, Integer> firstLineCharacters = getFrequencyMap(first);

        return calculateDeletions(secondLineCharacters, firstLineCharacters);
    }

    private static int calculateDeletions(Map<Character, Integer> secondLineCharacters, Map<Character, Integer> firstLineCharacters) {
        int result = 0;

        for (Character key : firstLineCharacters.keySet()) {
            if (secondLineCharacters.containsKey(key)) {
                result += Math.abs(firstLineCharacters.get(key) - secondLineCharacters.get(key));
            } else {
                result += firstLineCharacters.get(key);
            }
        }

        for (Character key : secondLineCharacters.keySet()) {
            if (!firstLineCharacters.containsKey(key)) {
                result += secondLineCharacters.get(key);
            }
        }

        return result;
    }

    private static Map<Character, Integer> getFrequencyMap(String first) {
        Map<Character, Integer> firstLineCharacters = new HashMap<>();

        for (int i = 0; i < first.length(); i++) {
            if (firstLineCharacters.containsKey(first.charAt(i))) {
                firstLineCharacters.replace(first.charAt(i), firstLineCharacters.get(first.charAt(i)) + 1);
            } else {
                firstLineCharacters.put(first.charAt(i), 1);
            }
        }

        return firstLineCharacters;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

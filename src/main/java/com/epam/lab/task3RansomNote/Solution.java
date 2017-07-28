package com.epam.lab.task3RansomNote;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        System.out.println(canUse(magazine, ransom) ? "Yes" : "No");
    }

    private static boolean canUse(String[] magazine, String[] ransom) {
        Map<String, Integer> magazineAsDictionary = getDictionary(magazine);

        for (String word : ransom) {
            Integer wordFrequency = magazineAsDictionary.get(word);

            if (wordFrequency == null || wordFrequency.equals(0)) {
                return false;
            } else {
                magazineAsDictionary.replace(word, wordFrequency - 1);
            }
        }

        return true;
    }

    private static Map<String, Integer> getDictionary(String[] words) {
        Map<String, Integer> dictionary = new HashMap<>();

        for (String word : words) {
            if (dictionary.containsKey(word)) {
                dictionary.replace(word, dictionary.get(word) + 1);
            } else {
                dictionary.put(word, 1);
            }
        }

        return dictionary;
    }
}

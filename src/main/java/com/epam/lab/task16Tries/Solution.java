package com.epam.lab.task16Tries;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> contacts = new HashSet<>();
        Map<String, Integer> tokens = new HashMap<>();
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();

            if (op.equals("add")) {
                contacts.add(contact);

                String[] split = contact.split("\\s+");
                for (String w : split) {
                    for (int i = 0; i <= w.length(); i++) {
                        String token = w.substring(0, i);
                        if (tokens.containsKey(token)) {
                            int times = tokens.get(token);
                            tokens.put(token, times + 1);
                        } else {
                            tokens.put(token, 1);
                        }
                    }
                }

            } else if (op.equals("find")) {
                System.out.println(tokens.getOrDefault(contact, 0));
            }
        }
    }
}

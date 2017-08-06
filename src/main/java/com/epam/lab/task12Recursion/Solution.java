package com.epam.lab.task12Recursion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            System.out.println(staircase(n));
        }
    }

    private static int staircase(int number) {
        if (number <= 2) {
            return number;
        }

        if (number == 3) {
            return 4;
        }

        if (!map.containsKey(number)) {
            int value = staircase(number - 1) + staircase(number - 2) + staircase(number - 3);
            map.put(number, value);
        }

        return map.get(number);
    }
}

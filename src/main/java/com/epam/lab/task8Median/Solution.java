package com.epam.lab.task8Median;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            values.add(a[a_i]);
            printMedian(values);
        }
    }

    private static void printMedian(List<Integer> realValues) {
        List<Integer> values = new ArrayList<>(realValues);
        Collections.sort(values);
        int size = values.size();

        if (size % 2 == 1) {
            System.out.format("%.1f\n", (double) values.get(size / 2));
        } else {
            System.out.format("%.1f\n",(double) (values.get(size / 2) + values.get(size / 2 - 1))/2);
        }
    }

}

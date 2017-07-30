package com.epam.lab.task10BitManipulation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int bitManipulator = 0;
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            bitManipulator ^= a[a_i];
        }
        System.out.println(bitManipulator);
    }
}

package com.epam.lab.Task1ArraysLeftRotation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        a = rotate(a, k);

        for (int element : a) {
            System.out.print(String.format("%d ", element));
        }
    }

    private static int[] rotate(int[] arrayToRotate, int shift) {
        int[] rotatedArray = new int[arrayToRotate.length];

        System.arraycopy(arrayToRotate, 0, rotatedArray, arrayToRotate.length - shift, shift);
        System.arraycopy(arrayToRotate, shift, rotatedArray, 0, arrayToRotate.length - shift);

        return rotatedArray;
    }
}

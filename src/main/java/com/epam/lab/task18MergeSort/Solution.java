package com.epam.lab.task18MergeSort;

import java.util.*;

public class Solution {

    private static long count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }

            descendingMergeSortExecution(arr, 0, arr.length, new int[arr.length]);

            System.out.println(count);
            count = 0;
        }

    }

    private static void descendingMergeSortExecution(int[] data, int leftBoundInclusive, int rightBoundExclusive, int[] free) {
        final int arrayFrame = rightBoundExclusive - leftBoundInclusive;

        if (arrayFrame <= 1) {
            return;
        }

        final int middle = leftBoundInclusive + arrayFrame / 2;

        descendingMergeSortExecution(data, leftBoundInclusive, middle, free);
        descendingMergeSortExecution(data, middle, rightBoundExclusive, free);

        merger(data, leftBoundInclusive, middle, rightBoundExclusive, free);
    }

    private static void merger(int[] data, int leftBoundInclusive, int middle, int rightBoundExclusive, int[] free) {
        System.arraycopy(data, leftBoundInclusive, free, leftBoundInclusive, rightBoundExclusive - leftBoundInclusive);

        int i = leftBoundInclusive;
        int j = middle;
        for (int k = leftBoundInclusive; k < rightBoundExclusive; k++) {
            if (i >= middle) {
                data[k] = free[j++];
            } else if (j >= rightBoundExclusive) {
                data[k] = free[i++];
            } else if (free[i] <= free[j]) {
                data[k] = free[i++];
            } else {
                data[k] = free[j++];
                count += j - k - 1;
            }
        }
    }
}

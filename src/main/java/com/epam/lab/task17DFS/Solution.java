package com.epam.lab.task17DFS;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        System.out.println(computeTheLargestRegion(grid));
    }

    static int computeTheLargestRegion(int[][] matrix) {
        int largestRegion = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    int size = getRegionSize(matrix, i, j);
                    largestRegion = Math.max(size, largestRegion);
                }
            }
        }

        return largestRegion;
    }

    private static int getRegionSize(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length) {
            return 0;
        }
        if (matrix[i][j] == 0) {
            return 0;
        }

        matrix[i][j] = 0;

        int sizeOfRegion = 1;

        for (int ii = i - 1; ii <= i + 1; ii++) {
            for (int jj = j - 1; jj <= j + 1; jj++) {
                if (i != ii || j != jj) {
                    sizeOfRegion += getRegionSize(matrix, ii, jj);
                }
            }
        }

        return sizeOfRegion;
    }
}

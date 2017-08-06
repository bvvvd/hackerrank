package com.epam.lab.task9Fibonacci;

import java.util.*;

public class Solution {

    private static Map<Integer, Integer> cache = new HashMap<>();
    private static int[] warehouse;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
//        System.out.println(fibonacci(n));
//        System.out.println(cachingFibonacci(n));
//        System.out.println(arrayFibonacci(n));
//        System.out.println(variablesFibonacci(n));
        System.out.println(matrixFibonacci(n));
    }

    private static int matrixFibonacci(int n) {
        int[] matrix = {1, 1, 1, 0};
        return matrixPow(matrix, n)[3];
    }

    private static int[] matrixPow(int[] matrix, int n) {
        int[] result = {1, 1, 1, 0};
        while (n != 0) {
            if (n % 2 != 0)
                result = matrixMultiply(result, matrix);
            n /= 2;
            matrix = matrixMultiply(matrix, matrix);
        }
        return result;
    }

    private static int[] matrixMultiply(int[] x, int[] y) {
        return new int[]{
                x[0] * y[0] + x[1] * y[2],
                x[0] * y[1] + x[1] * y[3],
                x[2] * y[0] + x[3] * y[2],
                x[2] * y[1] + x[3] * y[3]
        };
    }

    private static int variablesFibonacci(int n) {
        int current = 1;
        int previous = 0;
        for (int i = 1; i < n; i++) {
            current += previous;
            previous = current - previous;
        }
        return n == 0 ? 0 : current;
    }

    private static int arrayFibonacci(int n) {
        warehouse = new int[n + 1];
        warehouse[0] = 0;
        warehouse[1] = 1;
        for (int i = 2; i <= n; i++) {
            warehouse[i] = warehouse[i - 1] + warehouse[i - 2];
        }
        return warehouse[n];
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int cachingFibonacci(int n) {

        if (n <= 1) {
            return n;
        } else {
            if (cache.containsKey(n)) {
                return cache.get(n);
            } else {
                int value = cachingFibonacci(n - 1) + cachingFibonacci(n - 2);
                cache.put(n, value);
                return value;
            }

        }
    }
}

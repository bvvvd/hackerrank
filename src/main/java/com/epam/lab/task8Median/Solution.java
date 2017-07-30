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
        Heap heap = new Heap();
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            heap.add(a[a_i]);
            System.out.format("%.1f\n", heap.getMedian());
        }
    }


    private static class Heap {
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        public void add(int i) {
            if (minHeap.size() <= maxHeap.size()) {
                minHeap.add(i);
            } else {
                maxHeap.add(i);
            }
            makeBalance();
        }

        private void makeBalance() {
            while(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()) {
                Integer minValue= minHeap.poll();
                Integer maxValue = maxHeap.poll();
                minHeap.add(maxValue);
                maxHeap.add(minValue);
            }
        }

        public double getMedian() {
            return maxHeap.size() == minHeap.size() ? (double) (maxHeap.peek() + minHeap.peek()) / 2 : minHeap.peek();
        }
    }
}

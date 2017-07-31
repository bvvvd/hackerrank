package com.epam.lab.task15BinarySearch;

import java.util.*;

public class Solution {

    public static int binarySearch(int start, int end, IceCream[] creams, int toFind) {
        if (start <= end) {
            int mid = (start + end) / 2;

            if (creams[mid].getCost() == toFind) {
                return creams[mid].getIndex();
            }

            if (toFind < creams[mid].getCost()) {
                return binarySearch(start, mid - 1, creams, toFind);
            } else {
                return binarySearch(mid + 1, end, creams, toFind);
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int m = in.nextInt();
            int n = in.nextInt();
            IceCream[] creams = new IceCream[n];

            for (int i = 0; i < n; i++)
                creams[i] = new IceCream(in.nextInt(), i + 1);

            Arrays.sort(creams);

            System.out.println(Arrays.toString(creams));

            for (int i = 0; i < n - 1; i++) {
                int search = m - creams[i].cost;
                if (search >= creams[i].cost) {
                    int index = binarySearch(i + 1, n - 1, creams, search);
                    if (index != -1) {
                        System.out.println(Math.min(creams[i].index, index) + " " + Math.max(creams[i].index, index));
                        break;
                    }
                }
            }
        }
    }

}

class IceCream implements Comparable<IceCream> {
    int cost;
    int index;

    public IceCream(int cost, int index) {
        this.cost = cost;
        this.index = index;
    }

    @Override
    public int compareTo(IceCream o) {
        return (cost > o.cost) ? 1 : ((cost == o.cost) ? (index - o.index) : -1);
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "cost=" + cost +
                ", index=" + index +
                '}';
    }

    public int getCost() {
        return cost;
    }

    public int getIndex() {
        return index;
    }
}

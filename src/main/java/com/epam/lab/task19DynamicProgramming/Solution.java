package com.epam.lab.task19DynamicProgramming;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }

        System.out.println(change(coins, n, 0, new HashMap<>()));
    }

    public static long change(int[] coins, int money, int index, HashMap<String, Long> cache) {
        if (noMoney(money)) return 1;

        if (noCoins(coins, index)) return 0;

        String key = money + "-" + index;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int currentAmount = 0;
        long waysToChange = 0;

        while (currentAmount <= money) {
            int remainingMoney = money - currentAmount;
            waysToChange += change(coins, remainingMoney, index + 1, cache);
            currentAmount += coins[index];
        }
        cache.put(key, waysToChange);
        return waysToChange;
    }

    private static boolean noCoins(int[] coins, int index) {
        if (index >= coins.length) {
            return true;
        }
        return false;
    }

    private static boolean noMoney(int money) {
        if (money == 0) {
            return true;
        }
        return false;
    }
}

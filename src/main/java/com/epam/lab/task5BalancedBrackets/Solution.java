package com.epam.lab.task5BalancedBrackets;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        Stack<Character> openingBrackets = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                openingBrackets.push(currentChar);
            } else {
                if (openingBrackets.empty()) {
                    return false;
                }
                Character popedBracket = openingBrackets.pop();

                if (currentChar == '}' && popedBracket != '{') {
                    return false;
                }

                if (currentChar == ']' && popedBracket != '[') {
                    return false;
                }

                if (currentChar == ')' && popedBracket != '(') {
                    return false;
                }
            }

        }

        return openingBrackets.empty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}

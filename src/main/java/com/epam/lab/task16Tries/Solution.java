package com.epam.lab.task16Tries;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Trie trie = new Solution().new Trie();

        int operationNumber = in.nextInt();
        for (int i = 0; i < operationNumber; i++) {
            String operation = in.next();
            String contactName = in.next();

            if (operation.equals("add")) {
                trie.add(contactName);
            } else if (operation.equals("find")) {
                int result = trie.find(contactName);
                System.out.println(result);
            }
        }
    }

    class TrieNode {
        private HashMap<Character, TrieNode> children = new HashMap<>();
        public int size;

        public void putChildIfAbsent(char ch) {
            children.putIfAbsent(ch, new TrieNode());
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void add(String text) {
            TrieNode currentNode = root;

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);

                currentNode.putChildIfAbsent(ch);
                currentNode = currentNode.getChild(ch);

                currentNode.size++;
            }
        }

        public int find(String prefix) {
            TrieNode currentNode = root;

            for (int i = 0; i < prefix.length(); i++) {
                Character ch = prefix.charAt(i);
                currentNode = currentNode.getChild(ch);

                if (currentNode == null) {
                    return 0;
                }
            }

            return currentNode.size;
        }
    }
}
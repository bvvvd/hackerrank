package com.epam.lab.task4DetectACycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    class Node {
        int value;
        Node next;
    }

    boolean hasCycle(Node currentNode) {
        Set<Node> nodes = new HashSet<>();

        while (currentNode != null) {
            if (!nodes.add(currentNode)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }
}

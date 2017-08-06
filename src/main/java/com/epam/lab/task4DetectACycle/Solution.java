package com.epam.lab.task4DetectACycle;

public class Solution {

    class Node {
        int value;
        Node next;
    }

    boolean hasCycle(Node currentNode) {
        Node overtaker = currentNode.next;
        Node leader = currentNode.next.next;

        while (overtaker != leader) {
            if (leader == null || overtaker == null) {
                return false;
            }

            leader = leader.next.next;
            overtaker = overtaker.next;
        }
        return true;
    }

}

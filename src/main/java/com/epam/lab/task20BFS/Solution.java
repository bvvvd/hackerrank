package com.epam.lab.task20BFS;

import java.util.*;

public class Solution {

    private static final int EDGE_LENGTH = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int queries = sc.nextInt();

        for (int i = 0; i < queries; i++) {
            int nodeNumber = sc.nextInt();
            int edgeNumber = sc.nextInt();

            Node[] nodes = createNodes(nodeNumber);

            connectNodes(nodes, edgeNumber, sc);

            int startNode = sc.nextInt();
            calculateDistances(nodes[startNode - 1]);

            printResult(nodes, startNode);
        }

        sc.close();
    }

    private static void connectNodes(Node[] nodes, int numberOfEdges, Scanner sc) {
        for (int i = 0; i < numberOfEdges; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            nodes[node1 - 1].addConnectedNodes(nodes[node2 - 1]);
        }
    }

    private static Node[] createNodes(int numberOfNodes) {
        Node[] nodes = new Node[numberOfNodes];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }

        return nodes;
    }

    static void calculateDistances(Node startNode) {
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(startNode);

        startNode.distance = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node neighbor : currentNode.neighbors) {
                if (neighbor.distance == -1){
                    neighbor.distance = currentNode.distance + EDGE_LENGTH;
                    queue.add(neighbor);
                }
            }
        }
    }

    private static void printResult(Node[] nodes, int startNode) {
        for (int i = 0; i < nodes.length; i++) {
            if (startNode - 1 != i) {
                System.out.format("%d ", nodes[i].distance);
            }
        }
        System.out.println();
    }

    static class Node {

        private int nodeName;
        private Set<Node> neighbors;
        int distance;

        public Node(int nodeName) {
            this.nodeName = nodeName;
            neighbors = new HashSet<>();
            distance = -1;
        }

        public void addConnectedNodes(Node node) {
            neighbors.add(node);
            node.neighbors.add(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return nodeName == node.nodeName;
        }

        @Override
        public int hashCode() {
            return nodeName;
        }
    }
}
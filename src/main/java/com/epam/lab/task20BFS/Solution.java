package com.epam.lab.task20BFS;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for(int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for(int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.get(u).add(v);
                bfs.graph.get(v).add(u);
            }

            // Find shortest reach from node s
            bfs.shortestReach(scanner.nextInt() - 1);
        }

        scanner.close();
    }

    static class Graph {
        private Node[] nodes;
        private static int DISTANCE = 6;

        public Graph(int size) {

        }

        private class Node {
            private Node getNode(int id) {

            }

            public void addEdge(int first, int second) {

            }

            public int[] reach(int startPoint) {
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(startPoint);
                boolean[] visited = new boolean[nodes.length];
                int[] distances = new int[nodes.length];
                Arrays.fill(distances, -1);
                distances[startPoint] = 0;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : nodes[node].neighbors) {
                        if (distances[neighbor] == -1) {
                            distances[neighbor] += DISTANCE;
                            queue.add(neighbor);
                        }
                    }
                }
                return distances;
            }
        }
    }

}

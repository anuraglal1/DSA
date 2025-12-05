package DSU;

import java.util.*;

public class NoOfConnectedComponentInUndirectedGraph {
    static int[] parent;
    public static void main(String[] args) {
        int[][] graph = {{0, 2}, {1, 2}, {3, 5}};
        Map<Integer, List<Integer>> connectedComponents = new HashMap<>();
        int n = 6;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] arr : graph) {
            union(arr[0], arr[1]);
        }

        for (int x = 0; x < parent.length; x++) {
            List<Integer> curr;
            int root = find(x);
            if (connectedComponents.containsKey(root)) {
                curr = connectedComponents.get(root);
            } else {
                curr = new ArrayList<>();
            }
            curr.add(x);
            connectedComponents.put(root, curr);
        }

        System.out.println("Number of connect components are: " + connectedComponents.size());
        System.out.println("Connected components are: " + connectedComponents);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rootX < rootY) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

}

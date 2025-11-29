package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraphUsingTopologicalSort {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);

        System.out.println(isCycle(adj, V) ? "Yes Cycle exists 🙁" : "No, cycle does not exists 😀");

    }

    public static boolean isCycle(List<List<Integer>> adj, int n) {
        int[] inDegrees = new int[n];

        for (List<Integer> i : adj) {
            for(int j : i) {
                inDegrees[j] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int visitedCount = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visitedCount += 1;

            for (int nei : adj.get(curr)) {
                inDegrees[nei] -= 1;
                if (inDegrees[nei] == 0) {
                    queue.add(nei);
                }
            }
        }

        return visitedCount != n;
    }

    public static void addEdge(List<List<Integer>> adj, int src, int dest) {
        adj.get(src).add(dest);
    }
}

package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInUnDirectedGraphUsingDFS {
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

        int[] visited = new int[V];

        Arrays.fill(visited, 0);
        int flag = 0;

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0 && isCycle(i, -1, adj, visited)) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            System.out.println("Yes Cycle exists 🙁");
        } else {
            System.out.println("No, cycle does not exists 😀");
        }
    }

    public static boolean isCycle(int i, int parent, List<List<Integer>> adj, int[] visited) {
        visited[i] = 1;

        for (int nei : adj.get(i)) {
            if (visited[nei] == 0 ) {
                if (isCycle(nei, i, adj, visited)) {
                    return true;
                }
            } else if (nei != parent) {
                return true;
            }
        }

        return false;
    }

    public static void addEdge(List<List<Integer>> adj, int src, int dest) {
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
}

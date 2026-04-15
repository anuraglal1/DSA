package Graph.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/course-schedule/
public class CourseScheduleUsingDFS {
    public static boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] visited = new int[n];
        int[] inStack = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] arr : pre) {
            adj.get(arr[1]).add(arr[0]);
        }

        Arrays.fill(visited, 0);
        Arrays.fill(inStack, 0);

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && isCycle(adj, visited, inStack, i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isCycle(List<List<Integer>> adj, int[] visited, int[] inStack, int curr) {
        visited[curr] = 1;
        inStack[curr] = 1;

        for (int nei : adj.get(curr)) {
            if (visited[nei] == 0 && isCycle(adj, visited, inStack, nei)) {
                return true;
            } else if (inStack[nei] == 1) {
                return true;
            }
        }

        inStack[curr] = 0;
        return false;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] edges = {{0, 1}, {1, 0}};
        boolean result = canFinish(n, edges);

        if (result) {
            System.out.println("Yes course can be finished 😊");
        } else {
            System.out.println("No course cannot be finished 😢");
        }
    }

    public static class DetectCycleInUnDirectedGraphUsingDFS {
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

    public static class isGraphBipartite {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];

            Arrays.fill(color, 0);

            // 0 -> not visited and not colored.
            // 1 -> visited and colored with color 1.
            // -1 -> visited and colored with color 2.

            for (int i = 0; i < n; i++) {
                if (color[i] == 0 && !dfs(graph, color, i, 1)) {
                    return false;
                }
            }

            return true;
        }

        public boolean dfs(int[][] graph, int[] color, int i, int toColor) {
            if (color[i] != 0) {
                return color[i] == toColor;
            }

            color[i] = toColor;

            for (int nei : graph[i]) {
                if (!dfs(graph, color, nei, -1*toColor)) {
                    return false;
                }
            }

            return true;
        }
    }
}

package Graph;

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
}

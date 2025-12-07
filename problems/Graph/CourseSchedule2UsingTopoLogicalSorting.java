package Graph;

import java.util.*;

// Course Schedule II - Using Topological Sorting
// https://leetcode.com/problems/course-schedule-ii/
public class CourseSchedule2UsingTopoLogicalSorting {
    public static int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> topoOrder = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] arr : pre) {
            adj.get(arr[1]).add(arr[0]);
        }

        int[] inDegree = new int[n];
        Arrays.fill(inDegree, 0);

        for (List<Integer> list : adj) {
            for (int i : list) {
                inDegree[i] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int visitedCount = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoOrder.add(curr);
            visitedCount += 1;

            for (int nei : adj.get(curr)) {
                inDegree[nei] = inDegree[nei] - 1;

                if (inDegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }

        if (visitedCount == n) {
            int[] res = new int[topoOrder.size()];
            int k = 0;
            for (int i : topoOrder) {
                res[k++] = i;
            }
            return res;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
//        int n = 2;
//        int[][] edges = {{0, 1}, {1, 0}};
        int n = 4;
        int[][] edges = {{1,0},{2,0},{3,1},{3,2}};
        int[] result = findOrder(n, edges);

        if (result.length > 0) {
            System.out.println("Yes course can be finished and one of the correct order to finish it is : "
                    + Arrays.toString(result) + " 😊 ");
        } else {
            System.out.println("No course cannot be finished 😢");
        }
    }
}

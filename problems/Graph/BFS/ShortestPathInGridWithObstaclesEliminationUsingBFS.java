package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/description/
// BFS
public class ShortestPathInGridWithObstaclesEliminationUsingBFS {
        class Node {
            int i;
            int j;
            int k;

            Node(int i, int j, int k) {
                this.i = i;
                this.j = j;
                this.k = k;
            }
        }

        public int shortestPath(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;

            Queue<Node> queue = new LinkedList<>();
            boolean[][][] visited = new boolean[m][n][k + 1];

            queue.add(new Node(0, 0, k));
            visited[0][0][k] = true;

            int steps = 0;
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int s = 0; s < size; s++) {
                    Node curr = queue.poll();

                    if (curr.i == m - 1 && curr.j == n - 1) {
                        return steps;
                    }

                    for (int[] d : dirs) {
                        int ni = curr.i + d[0];
                        int nj = curr.j + d[1];

                        if (ni >= 0 && nj >= 0 && ni < m && nj < n) {
                            int newK = curr.k - grid[ni][nj];

                            if (newK >= 0 && !visited[ni][nj][newK]) {
                                visited[ni][nj][newK] = true;
                                queue.add(new Node(ni, nj, newK));
                            }
                        }
                    }
                }
                steps++;
            }

            return -1;
        }
}

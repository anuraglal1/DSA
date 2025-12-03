package Graph;

import java.util.Arrays;
public class isGraphBipartite {
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

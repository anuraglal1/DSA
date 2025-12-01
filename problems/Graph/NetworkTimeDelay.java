package Graph;

import java.util.*;

// https://leetcode.com/problems/network-delay-time/?envType=problem-list-v2&envId=graph
public class NetworkTimeDelay {
    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] arr : times) {
            adj.get(arr[0]).add(new Edge(arr[1], arr[2]));
        }

        for (int i = 1; i <= n; i++) {
            if (i == k) {
                continue;
            }
            int distance = dijkstra(adj, n, k, i);

            // System.out.println("Shortest path between " + k + " and  " + i + " is:  " + distance);

            ans = Math.max(ans, distance);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int dijkstra(List<List<Edge>> adj, int n, int src, int dest) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(
                a -> a.weight
        ));

        dist[src] = 0;
        pq.add(new Edge(src, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int node = curr.to;
            int weight = curr.weight;

            if (node == dest) {
                break;
            }

            for (Edge nei : adj.get(node)) {
                int next = nei.to;
                int newWeight = weight + nei.weight;

                if (newWeight < dist[next]) {
                    dist[next] = newWeight;
                    pq.add(new Edge(next, newWeight));
                }
            }
        }

        return dist[dest];
    }
}

package Graph;

import java.util.*;

// Dijkstra Algorithm
public class ShortestDistanceDirectedWeightedGraph {

    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 3, 7);
        addEdge(adj, 2, 3, 1);
        addEdge(adj, 3, 4, 3);

        int src = 0;
        int dest = 4;

        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        int result =  shortestPath(adj, src, dest, dist, parent);

        if (result == Integer.MAX_VALUE) {
            System.out.println("Oops 😢 there isn't any valid path from source: " + src +
                    " to destination: " + dest);
        } else {
            System.out.println("Shortest distance from Source: " + src + " to Destination: "
                    + dest + " is: " + result + " 😀 ");
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();

        for (int at = dest; at != -1; at = parent[at]) {
            path.add(at);
        }

        Collections.reverse(path);

        if (result != Integer.MAX_VALUE) {
            System.out.println("Valid path is: " + path);
        }


    }

    public static int shortestPath(List<List<Edge>> adj, int src, int dest,
                                   int[] dist, int[] parent) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(
                a -> a.weight
        ));
        dist[src] = 0;
        pq.add(new Edge(src, 0));

        while (!pq.isEmpty()) {
            Edge currEdge = pq.poll();
            int node = currEdge.to;
            int d = currEdge.weight;

            if (node == dest) {
                break;
            }

            if (d != dist[node]) {
                continue;
            }

            for (Edge nei : adj.get(node)) {
                int next = nei.to;
                int newWeight = nei.weight + dist[node];

                if (newWeight < dist[next]) {
                    dist[next] = newWeight;
                    parent[next] = node;
                    pq.add(new Edge(next, newWeight));
                }
            }
        }

        return dist[dest];
    }

    public static void addEdge(List<List<Edge>> adj, int src, int dest, int weight) {
        adj.get(src).add(new Edge(dest, weight));
    }
}

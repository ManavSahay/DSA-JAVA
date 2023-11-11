package graphs;

import java.util.ArrayList;

public class Cycle_Detection_Directed {
    static class Edge {
        int source;
        int destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycleDirected(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] rec) {
        // rec --> recursion stack
        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.destination]) {
                return true;
            }
            else if (!vis[e.destination]) {
                if (isCycleDirected(graph, vis, e.destination, rec)) {
                    return true;
                }
            }
        }

        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                boolean isCycle = isCycleDirected(graph, vis, 0, rec);
                if (isCycle) {
                    System.out.println(isCycle);
                    break;
                }
            }
        }
    }
}

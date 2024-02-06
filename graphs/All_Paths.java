package graphs;

import java.util.ArrayList;

public class All_Paths {

    static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void DFS(ArrayList<DFS.Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            DFS.Edge e = graph[curr].get(i);
            if (!vis[e.destination]) {
                DFS(graph, e.destination, vis);
            }
        }
    }

    public static void printAllPAth(ArrayList<Edge>[] graph, boolean[] vis, int curr, String path, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.destination]) {
                vis[curr] = true;
                printAllPAth(graph, vis, e.destination, path + e.destination, target);
                vis[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);

        int src = 0, tar = 5;
        printAllPAth(graph, new boolean[vertices], src, "0", tar);
    }
}

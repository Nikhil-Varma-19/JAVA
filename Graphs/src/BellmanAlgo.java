import java.util.ArrayList;
import java.util.Arrays;

public class BellmanAlgo {
    static class Edge {
        int src;
        int dest;
        int weight;


        Edge(int src, int dest, int weight) {
            this.dest = dest;
            this.src = src;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));

    }

    static void bellmanAlgo(ArrayList<Edge> graph[], int src){
        int[] dist = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if( i != src) dist[i] = Integer.MAX_VALUE;
        }

        int V = graph.length;

// All loop for edge , T.C : O(V) so total  : T.C : O(V*E)
        for (int i = 0; i < V - 1; i++) {
// T.C : O(E(edge))
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                     Edge e = graph[j].get(k);
                    int u = e.src, v = e.dest, wt = e.weight;
                     if(dist[u] != Integer.MAX_VALUE &&  dist[u] + wt < dist[v]){
                         dist[v] = dist[u] + wt;
                     }
                }
            }

        }

        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
            int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellmanAlgo(graph,0);

    }
}

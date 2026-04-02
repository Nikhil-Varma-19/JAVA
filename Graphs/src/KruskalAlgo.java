import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgo {
    static class Edge{
        int src, dst, cost;

        public Edge(int src, int dst, int cost) {
            this.src = src;
            this.dst = dst;
            this.cost = cost;
        }
    }

    static void  createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    static int n = 4;
    static int[] rank = new int[n];
    static int[] parent = new int[n];

    public static void init(){
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public  static int find(int x){
        if(x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            parent[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            parent[parB] = parA;
        }else {
            parent[parA] = parB;
        }
    }

    static int kruskalAlgo(ArrayList<Edge> edges, int V){
        init();
        edges.sort((a, b) -> a.cost - b.cost); // O(ElogE)
        int mstCost = 0, count = 0;

        for (int i = 0; i < edges.size() && count < V - 1; i++) { // O(V)
            Edge e = edges.get(i);

            int parA = find(e.src), parB = find(e.dst);

            if(parA != parB){
                union(e.src,e.dst);
                mstCost += e.cost;
                count++;
            }
        }

        return count == V - 1 ? mstCost : -1; // disconnected graph
    }

    public static void main(String[] args) {
            int V = 4;
            ArrayList<Edge> edges = new ArrayList<>();
            createGraph(edges);
           System.out.println(kruskalAlgo(edges,V));
    }
}

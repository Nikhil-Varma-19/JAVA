import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
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

  private static  void  createGraph(ArrayList<Edge> graph[]){
      for (int i = 0; i < graph.length; i++) {
          graph[i] = new ArrayList<>();
      }

      graph[0].add(new Edge(0,1,2));
      graph[0].add(new Edge(0,2,4));

      graph[1].add(new Edge(1,3,7));
      graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
  }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

  private  static void dijAl(ArrayList<Edge> graph[],int src){
        // T.C: O(V+ElogV)
        int dis[] = new int[graph.length]; // dis[i] -> src to i
      for (int i = 0; i < graph.length; i++) {
          if(i != src) dis[i] = Integer.MAX_VALUE;
      }

      boolean isVisited[] = new boolean[graph.length];
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src,0));

      while (!pq.isEmpty()){
          Pair curr = pq.poll();

//          if(curr.path > dis[curr.n]) continue;  this line act same as the visited array

          if(!isVisited[curr.n]){
              isVisited[curr.n] = true;
              // neighbours
              for (int i = 0; i < graph[curr.n].size(); i++) {
                  Edge e = graph[curr.n].get(i);
                  int u = e.src, v = e.dest, wt = e.weight;
                  if(dis[u] + wt < dis[v]){ //  update  distance of src to v
                      dis[v] = dis[u] + wt;
                      pq.add(new Pair(v,dis[v]));
                  }
              }
          }
      }

      for (int i = 0; i < dis.length; i++) {
          System.out.print(dis[i] + " ");
      }
      System.out.println();
  }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijAl(graph,0);
    }

}

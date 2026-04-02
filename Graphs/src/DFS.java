import java.util.ArrayList;

public class DFS {
    static  class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.dest = dest;
            this.src = src;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[1].add(new Edge(2,0,1));
        graph[1].add(new Edge(2,4,1));

        graph[1].add(new Edge(3,1,1));
        graph[1].add(new Edge(3,4,1));
        graph[1].add(new Edge(3,5,1));

        graph[1].add(new Edge(4,2,1));
        graph[1].add(new Edge(4,3,1));
        graph[1].add(new Edge(4,5,1));

        graph[1].add(new Edge(5,3,1));
        graph[1].add(new Edge(5,4,1));
        graph[1].add(new Edge(5,6,1));

        graph[1].add(new Edge(6,5,1));

    }

    static void dfsGraph(ArrayList<Edge> graph[], int curr, boolean[] isVisited ){

        System.out.print(curr + " ");
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge edge = graph[curr].get(i);
            if(!isVisited[edge.dest]){
                dfsGraph(graph, edge.dest, isVisited);
            }
        }

    }

    public static void main(String[] args) {
        /*
              1 ---- 3
             /       | \
           0         |   5  ---  6
            \        |  /
             2 ----  4
         */

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        dfsGraph(graph,0,new boolean[graph.length]);

    }
}

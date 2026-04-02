import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HasPath {
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

    static boolean isPathDFS(ArrayList<Edge> graph[], int src, int des, boolean[] isVisited){
        if(src == des) return true;

        isVisited[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge edge = graph[src].get(i);
           if(!isVisited[edge.dest]){
               boolean res = isPathDFS(graph,edge.dest,des,isVisited);
               if (res) return true;
           }
        }

        return  false;
    }

    static boolean isPathBFS(ArrayList<Edge> graph[], int src, int des, boolean[] isVisited){
        Queue<Integer> q =new LinkedList<>();

        q.add(src);

        while (!q.isEmpty()){
            int curr = q.remove();
            if(curr == des){
                return true;
            }
            isVisited[curr] = true;

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge edge = graph[curr].get(i);
                if (!isVisited[edge.dest]) q.add(edge.dest);
            }
        }

        return false;
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

        System.out.println(isPathDFS(graph,0,4,new boolean[graph.length]));
        System.out.println(isPathBFS(graph,0,4,new boolean[graph.length]));


    }
}

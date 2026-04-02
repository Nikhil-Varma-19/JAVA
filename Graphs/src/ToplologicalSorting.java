import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ToplologicalSorting {
    static class Edge {
        int src;
        int dest;


        Edge(int src, int dest ) {
            this.dest = dest;
            this.src = src;
        }
    }

    private static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

    static void topSort(ArrayList<Edge> graph[]){
        boolean[] isVisited = new boolean[graph.length];

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if(!isVisited[i]){
                // modified DFS
                topSortUtils(graph,isVisited,i,s);
            }
        }

        while (!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    private static void topSortUtils(ArrayList<Edge>[] graph, boolean[] isVisited, int curr, Stack<Integer> s) {
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest]){
                topSortUtils(graph,isVisited,e.dest,s);
            }
        }
        s.add(curr);
    }

    private static void calcuInDeg(ArrayList<Edge> graph[],int[] inDeg){
        for (ArrayList<Edge> edges : graph) {
            for (Edge e : edges) {
                inDeg[e.dest]++;
            }
        }
    }

    static void topSortBFS(ArrayList<Edge> graph[]) {
        // Kahn's Algo
        int[] inDeg = new int[graph.length];

        Queue<Integer> q = new LinkedList<>();

        calcuInDeg(graph, inDeg);

        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) q.add(i);
        }

        ArrayList<Integer> s = new ArrayList<>();

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            s.add(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if (inDeg[e.dest] == 0) q.add(e.dest);
            }
        }
        System.out.println();
        System.out.println(s);
    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
        System.out.println();
        topSortBFS(graph);

    }
}

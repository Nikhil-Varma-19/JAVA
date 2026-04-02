import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleGraph {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.dest = dest;
            this.src = src;
            this.wt = wt;
        }
    }

    static class Pair{
        int node;
        int parent;

        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[1].add(new Edge(2, 0, 1));
        graph[1].add(new Edge(2, 4, 1));

        graph[1].add(new Edge(3, 1, 1));
        graph[1].add(new Edge(3, 4, 1));
        graph[1].add(new Edge(3, 5, 1));

        graph[1].add(new Edge(4, 2, 1));
        graph[1].add(new Edge(4, 3, 1));
        graph[1].add(new Edge(4, 5, 1));

        graph[1].add(new Edge(5, 3, 1));
        graph[1].add(new Edge(5, 4, 1));
        graph[1].add(new Edge(5, 6, 1));

        graph[1].add(new Edge(6, 5, 1));

    }

    static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean[] isVisited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                if (detectCycleUtils(graph, isVisited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean detectCycleUtils(ArrayList<Edge>[] graph, boolean[] isVisited, int current, int parent) {
        isVisited[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (!isVisited[e.dest] && detectCycleUtils(graph, isVisited, e.dest, current)) {
                return true;
            } else if (isVisited[e.dest] && e.dest != parent) {
                return true;
            }
        }

        return false;
    }

    private static boolean detectCycleBFS(ArrayList<Edge>[] graph){
        boolean[] isVisited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!isVisited[i]){
               if(detectCycleHelper(graph,isVisited,i)) return true;
            }
        }
        return false;
    }

    private static boolean detectCycleHelper(ArrayList<Edge>[] graph, boolean[] isVisited, int start){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start,-1));
        isVisited[start] = true;
        while (!queue.isEmpty()){
            Pair curr = queue.poll();

            for(Edge e : graph[curr.node]){
                if(!isVisited[e.dest]){
                    isVisited[e.dest] = true;
                    queue.add(new Pair(e.dest,curr.node));
                }
                else if (e.dest != curr.parent) return  true;
            }

        }

        return false;
    }


    public static void main(String[] args) {

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(detectCycle(graph));
        System.out.println(detectCycleBFS(graph));

    }
}

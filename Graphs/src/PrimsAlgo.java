import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
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

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));

    }

    static class Pair implements Comparable<Pair>{
        int vertex;
        int cost;

        Pair(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    static void primsAlgo(ArrayList<Edge> graph[]){

        boolean[] visited = new boolean[graph.length];

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0,0));
        int finalCost = 0;

        while (!queue.isEmpty()){
            Pair curr = queue.poll();
            if(!visited[curr.vertex]){
                visited[curr.vertex] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    queue.add(new Pair(e.dest,e.weight));
                }
            }
        }

        System.out.println("Min MST: "+ finalCost);

    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primsAlgo(graph);

        
    }
}

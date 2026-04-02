import java.util.ArrayList;

public class AllPath {
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

        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

    static void getALlPath(ArrayList<Edge> graph[], int src, int des, String path){
            if(src == des) System.out.println(path+des);

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            getALlPath(graph,e.dest,des,path+src);
        }
    }

    public static void main(String[] args) {
        // Directed Graph

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getALlPath(graph,5,1,"");
    }
}

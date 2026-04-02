import java.util.ArrayList;
import java.util.Stack;

public class KasarajuAlgo {

    static class Edge{
        int src, dst;

        public Edge(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));

    }

    static void topoSortDFS(ArrayList<Edge> graph[],int node, boolean[] visited, Stack<Integer> s){
        visited[node] = true;

        for(int i = 0; i < graph[node].size(); i++){
            Edge e = graph[node].get(i);
            if(!visited[e.dst]){
                topoSortDFS(graph,e.dst,visited,s);
            }
        }

        s.add(node);
    }


    private static ArrayList<ArrayList<Integer>> kasarajusAlgo(ArrayList<Edge> graph[]){
//   Step 1: get node in stack(topological sort)
        Stack<Integer> s = new Stack<>();
        boolean[] visited  = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                topoSortDFS(graph,i,visited,s);
            }
        }

//        while (!s.isEmpty()) System.out.print(s.pop() + " ");

        // Step 2 : Transpose the graph
        ArrayList<Edge> transpose[] = new ArrayList[graph.length];

        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dst].add(new Edge(e.dst,e.src));
            }
        }

        // Step 3 : Do DFS according to stack node on the transpose graph

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (!s.isEmpty()){
            int node = s.pop();
            if(!visited[node]){
                ArrayList<Integer> temp = new ArrayList<>();
                dfsTr(transpose,visited,node,temp);
                res.add(temp);
//                System.out.println();
            }
        }

        return res;
    }

    private  static void dfsTr(ArrayList<Edge> transpose[],boolean[] visited, int node, ArrayList<Integer> ans){

        visited[node] = true;
        ans.add(node);
//        System.out.printf(node + " ");
        for (int i = 0; i < transpose[node].size(); i++) {
            Edge e = transpose[node].get(i);
            if(!visited[e.dst]){
                dfsTr(transpose, visited, e.dst,ans);
            }
        }

    }



    public static void main(String[] args) {
            int V = 5;
            ArrayList<Edge> graph[] = new ArrayList[V];

            createGraph(graph);

        System.out.println(kasarajusAlgo(graph));
    }
}

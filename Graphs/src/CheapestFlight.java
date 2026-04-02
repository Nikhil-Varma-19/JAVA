import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlight {
    static class Pair implements Comparable<Pair>{
        int node ;
        int costs;
        int stop;

        Pair(int node, int costs, int stop){
            this.node = node;
            this.costs = costs;
            this.stop = stop;
         }


        @Override
        public int compareTo(Pair p2) {
            return this.stop != p2.stop ? this.stop - p2.stop : this.costs - p2.costs;
        }
    }

    static class Edge{
        int src;
        int dst;
        int costs;

        Edge(int src, int dst, int costs){
            this.costs = costs;
            this.dst = dst;
            this.src = src;
        }
    }

    private static void createGraph(int[][] flight, ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flight.length; i++) {
            int src = flight[i][0], dst = flight[i][1], costs = flight[i][2];
            graph[src].add(new Edge(src,dst,costs));
        }

    }

    private static int cheapestFight(ArrayList<Edge> graph[], int src, int dest, int k){
        int[] distances = new int[graph.length];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[src] = 0;

        boolean[] visited = new boolean[graph.length];

        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.add(new Pair(src,0,0));

        while (!q.isEmpty()){
            Pair curr = q.poll();

            if(curr.stop > k) break;

            if(!visited[curr.node]){
                visited[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);

                    if(distances[e.src] != Integer.MAX_VALUE && distances[e.src] + e.costs < distances[e.dst]){
                        distances[e.dst] = distances[e.src] + e.costs;
                        q.add(new Pair(e.dst,distances[e.dst],curr.stop +1));
                    }
                }

            }
        }

        return distances[dest] != Integer.MAX_VALUE ? distances[dest] : -1 ;
    }
    
    private static int cheapestFlightCost(int[][] flights, int src, int dst, int  k){
        int n = flights.length;
        int[] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[src] = 0;


        for (int i = 0; i <= k; i++) {
            int[] tempCosts = costs.clone();
            for (int j = 0; j < n; j++) {
                int[] flight = flights[j];
                int src_f = flight[0], dst_f = flight[1], cost = flight[2];

                if(costs[src_f] == Integer.MAX_VALUE) continue;

                if(costs[src_f] + cost < tempCosts[dst_f]){
                    tempCosts[dst_f] = costs[src_f] + cost;
                }
            }

            costs = tempCosts;
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    public static void main(String[] args) {
       int n = 4;
       int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
       int src = 0, dst = 3, k = 1;

        ArrayList<Edge>[] graph = new ArrayList[flights.length];

       createGraph(flights,graph);

        System.out.println(cheapestFight(graph,src,dst,k));
        System.out.println(cheapestFlightCost(flights,src,dst,k));
    }
}

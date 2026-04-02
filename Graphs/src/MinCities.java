import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCities {
    static class Edge {
        int dst;
        int cost;

        Edge(int dst, int cost){
            this.cost =cost;
            this.dst =dst;
        }
    }

    private static int minCitiesConnections(int[][] cities){
        PriorityQueue<Edge> pq =new PriorityQueue<>((a,b) -> a.cost - b.cost);

        boolean[] visited = new boolean[cities.length];

        int finalCost = -1;

        pq.add(new Edge(0,0));
        while (!pq.isEmpty()){
            Edge curr = pq.poll();

            if(!visited[curr.dst]){
                visited[curr.dst] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dst].length; i++) {
                    if(cities[curr.dst][i] != 0){
                        pq.add(new Edge(i,cities[curr.dst][i]));
                    }
                }
                
            }
        }

        return finalCost;
    }

    private static int minimumCost(int n, int[][] connection){
        
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for(int[] city : connection){
            int src = city[0], dst = city[1], cost = city[2];
            graph.get(src).add(new int[]{dst,cost});
            graph.get(dst).add(new int[]{src,cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{1,0});

        boolean[] visited = new boolean[n+1];
        int finalCost = 0, countNode = 0;

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0] , cost = curr[1];
            if(visited[node]) continue;

            visited[node] = true;
            finalCost += cost;
            countNode++; // count of node bzc then node can be diconnected

            for (int[] neighbour : graph.get(node)){
                if(!visited[neighbour[0]]) pq.add(new int[]{neighbour[0],neighbour[1]});
            }
        }

        return countNode == n ? finalCost : -1;
    }
    public static void main(String[] args) {
        int[][] cities = { {0,1,2,3,4},
                            {1,0,5,0,7},
                            {2,5,0,6,0},
                            {3,0,6,0,0},
                            {4,7,0,0,0}};

        int[][] smallCities = { {1,2,5},{1,3,6},{2,3,1}};
        System.out.println(minCitiesConnections(cities));
        System.out.println(minimumCost(smallCities.length,smallCities));
    }
}

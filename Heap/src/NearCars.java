import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class NearCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int ditSq;
        int index;

        public Point(int x, int y, int ditSq, int index) {
            this.x = x;
            this.y = y;
            this.ditSq = ditSq;
            this.index = index;
        }

        @Override
        public int compareTo(Point p) {
            return  this.ditSq - p.ditSq;
        }
    }
    public static void main(String[] args) {
        int[][] points = {{3,3},{4,8},{5,-1},{9,1}};

        int k = 2;

        PriorityQueue<Point> minHeap = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int distSq = (x*x) + (y*y) ;
            minHeap.add(new Point(x,y,distSq,i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("Index: " + minHeap.remove().index);
        }
    }
}

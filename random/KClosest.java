package random;

import java.util.*;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        List<Integer[]> list = new ArrayList<>();
        Arrays.stream(points).forEach(point -> list.add(new Integer[] { point[0], point[1] }));

        list.sort((point1, point2) -> Integer.compare(point1[1] * point1[1] + point1[0] * point1[0],
                point2[1] * point2[1] + point2[0] * point2[0]));
        int[][] result = new int[k][1];
        for (int i = 0; i < k; i++) {
            result[i] = new int[] { list.get(i)[0], list.get(i)[1] };
        }
        return result;
    }

    public int[][] kClosestPriorityQueue(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((point1, point2) -> Integer
                .compare(point1[1] * point1[1] + point1[0] * point1[0], point2[1] * point2[1] + point2[0] * point2[0]));
        Arrays.stream(points).forEach(point -> pq.add(point));

        int[][] result = new int[k][1];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}

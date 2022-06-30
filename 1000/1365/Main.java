import java.util.*;
import java.io.*;

public class Main {
    private static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Point> queue = new PriorityQueue<>();
        int size = Integer.parseInt(reader.readLine());
        int[] array = new int[size];
        lis = new int[size];
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < input.length; i++) 
            queue.add(new Point(i, input[i]));

        int index = 0;
        while (!queue.isEmpty()) {
            array[index] = queue.poll().p2;
            index += 1;
        }
        System.out.println(size - lowerBound(array));
    }

    private static int binarySearch(int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (lis[mid] < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    private static int lowerBound(int[] array) {
        lis[0] = array[0];
        int i = 1, j = 0;

        while (i < array.length) {
            if (lis[j] < array[i]) {
                lis[j + 1] = array[i];
                j += 1;
            } else 
                lis[binarySearch(0, j, array[i])] = array[i];
            i += 1;
        }

        return j + 1;
    }
}

class Point implements Comparable<Point> {
    int p1, p2;

    public Point(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public int compareTo(Point o) {
        return this.p1 - o.p1;
    }
}
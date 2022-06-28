import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Point> queue = new PriorityQueue<>();
        int size = Integer.parseInt(reader.readLine());
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            queue.add(new Point(input[0], input[1]));
        }

        int index = 0;
        while(!queue.isEmpty()) {
            array[index] = queue.poll().p2;
            index += 1;
        }
        System.out.print(size - lis(array));
    }

    private static int lis(int[] array) {
        int[] dp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) 
                if (array[j] < array[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        }

        return Arrays.stream(dp).max().getAsInt();
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
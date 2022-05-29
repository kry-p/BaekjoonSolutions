import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int size;
    public static int[][] map;
    public static PriorityQueue<Integer> priorityQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        priorityQueue = new PriorityQueue<>();
        size = Integer.parseInt(reader.readLine());
        int count = 0;
        map = new int[size][size];

        for (int i = 0; i < size; i++)
            map[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < size; i++) 
            for (int j = 0; j < size; j++) 
                if (map[i][j] == 1) {
                    count += 1;
                    bfs(i, j);
                }
    
        builder.append(count + "\n");
        while (!priorityQueue.isEmpty())
            builder.append(priorityQueue.poll() + "\n");
            
        System.out.print(builder.toString());
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        map[x][y] = 0;
        int temp = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size)
                    continue;
                if (map[nextX][nextY] == 0)
                    continue;
                map[nextX][nextY] = 0;
                queue.add(new Point(nextX, nextY));
                temp += 1;
            }
        }
        priorityQueue.add(temp);
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
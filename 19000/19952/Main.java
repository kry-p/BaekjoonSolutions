import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private final static String SUCCEED = "잘했어!!\n";
    private final static String FAILED = "인성 문제있어??\n";
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int w, h, endX, endY; 

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = reader.readLine().split(" ");
            int o = Integer.parseInt(input[2]);
            int f = Integer.parseInt(input[3]);
            int startX = Integer.parseInt(input[4]);
            int startY = Integer.parseInt(input[5]);

            w = Integer.parseInt(input[1]);
            h = Integer.parseInt(input[0]);
           
            endX = Integer.parseInt(input[6]);
            endY = Integer.parseInt(input[7]);

            map = new int[h][w];
            isVisited = new boolean[h][w];
            for (int j = 0; j < o; j++) {
                input = reader.readLine().split(" ");
                map[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = Integer.parseInt(input[2]);
            }

            bfs(startX - 1, startY - 1, f);

            if (isVisited[endX - 1][endY - 1])
                builder.append(SUCCEED);
            else
                builder.append(FAILED); 
        }
        System.out.print(builder.toString());
    }

    private static void bfs(int x, int y, int initialForce) {
        Queue<Point> queue = new LinkedList<>();
        isVisited[x][y] = true;
        queue.add(new Point(x, y, initialForce));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == (endX - 1) && p.y == (endY - 1))
                break;

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + DX[i];
                int nextY = p.y + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= h || nextY >= w || isVisited[nextX][nextY])
                    continue;
                if (map[nextX][nextY] - map[p.x][p.y] > p.force)
                    continue;
                if (p.force < 1)
                    continue;
                isVisited[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY, p.force - 1));
            }
        }
    }
}

class Point {
    public int x, y;
    public int force;
    public Point(int x, int y, int force) {
        this.x = x; this.y = y; this.force = force;
    }
}
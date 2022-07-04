import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int n, k, s, x, y;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nk[0];
        k = nk[1];

        map = new int[n][n];

        for (int i = 0; i < n; i++) 
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sxy = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        s = sxy[0];
        x = sxy[1] - 1;
        y = sxy[2] - 1;

        loop:
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < k; j++) {
                bfs(j + 1);
                if (map[x][y] != 0) break loop; 
            }
        }

        System.out.println(map[x][y]);
    }    

    private static void bfs(int virus) {
        Queue<Point> queue = new LinkedList<>();
    
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++)
                if (map[i][j] == virus) queue.add(new Point(i, j));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + DX[i];
                int nextY = p.y + DY[i];
    
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || map[nextX][nextY] != 0)
                    continue;

                map[nextX][nextY] = virus;
            }
        }
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
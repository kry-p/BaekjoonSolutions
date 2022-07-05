import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 }; 
    private static int n, m, t;
    private static int[][] map;
    private static boolean[][][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nmt = reader.readLine().split(" ");
        n = Integer.parseInt(nmt[0]);
        m = Integer.parseInt(nmt[1]);
        t = Integer.parseInt(nmt[2]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) 
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        isVisited = new boolean[n][m][2];
        int result = bfs(0, 0);

        System.out.println(result == -1 ? "Fail" : result);
    }

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0, false));
        isVisited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.depth > t) break;
            if (p.x == n - 1 && p.y == m - 1) return p.depth;
            
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + DX[i];
                int nextY = p.y + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) 
                    continue;   
                if (p.isGramObtained) {
                    if (!isVisited[nextX][nextY][1]) {
                        queue.add(new Point(nextX, nextY, p.depth + 1, true));
                        isVisited[nextX][nextY][1] = true;
                    }
                } else {
                    if (!isVisited[nextX][nextY][0]) {
                        if (map[nextX][nextY] == 0) {
                            queue.add(new Point(nextX, nextY, p.depth + 1, p.isGramObtained));
                            isVisited[nextX][nextY][0] = true;
                        }
                        if (map[nextX][nextY] == 2) {
                            queue.add(new Point(nextX, nextY, p.depth + 1, true));
                            isVisited[nextX][nextY][0] = true;
                        }                        
                    }
                }
            }
        }
        return -1;
    }
}

class Point {
    public int x, y, depth;
    public boolean isGramObtained;
    public Point(int x, int y, int depth, boolean isGramObtained) {
        this.x = x; this.y = y; this.depth = depth; this.isGramObtained = isGramObtained;
    }
}
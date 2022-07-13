import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int m, n, count;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = reader.readLine().split(" ");
            count = 0;
            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);

            map = new int[m][n];
            isVisited = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                input = reader.readLine().split(" ");
                map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
            }

            find();
            builder.append(count + "\n");
        }
        System.out.print(builder.toString());
    }

    private static void find() {
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    dfs(i, j);
                    count += 1;
                }
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];

            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)
                continue;
            if (isVisited[nextX][nextY])
                continue;
            if (map[nextX][nextY] == 1)
                dfs(nextX, nextY);
        }
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
}
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int[][] map;
    private static int n, m, k, max, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        max = Integer.MIN_VALUE;
        map = new int[n][m];

        for (int i = 0; i < k; i++) {
            input = reader.readLine().split(" ");
            map[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    temp = 0;
                    dfs(i, j);
                    max = Math.max(max, temp);
                }
            }
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y) {
        map[x][y] = 0;
        temp += 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                continue;
            if (map[nextX][nextY] == 0)
                continue;
            dfs(nextX, nextY);
        }
    }
}
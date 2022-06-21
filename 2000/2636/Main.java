import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 0, 0, 1, -1 };
    private final static int[] DY = { 1, -1, 0, 0 };
    private static int[][] cheese;
    private static boolean[][] melt, visited;
    private static int x, y, time, latest;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split(" ");
        x = Integer.parseInt(size[0]);
        y = Integer.parseInt(size[1]);
        cheese = new int[x][y];
        time = 0;
        latest = 0;

        for (int i = 0; i < x; i++) 
            cheese[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (true) {
            int current = countCheese();
            if (current == 0) break;
            else latest = current;
            scan();
            meltCheese();
            time += 1;
        }

        System.out.println(time);
        System.out.println(latest);
    }

    private static int countCheese() {
        int count = 0;

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                if (cheese[i][j] == 1) count += 1;

        return count;
    }

    // 외부 공기 : 2, 내부 공기 : 0
    private static void scan() {
        melt = new boolean[x][y];
        visited = new boolean[x][y];

        dfs(0, 0);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (cheese[i][j] == 1) {
                    int count = 0;

                    for (int k = 0; k < 4; k++) {
                        int nextX = i + DX[k];
                        int nextY = j + DY[k];

                        if (nextX > x - 1 || nextX < 0 || nextY > y - 1 || nextY < 0)
                            continue;
                        if (cheese[nextX][nextY] == 2)
                            count += 1;
                    }
                    if (count > 0)
                        melt[i][j] = true;
                }
            }
        }
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        cheese[i][j] = 2;

        for (int k = 0; k < 4; k++) {
            int nextX = i + DX[k];
            int nextY = j + DY[k];

            if (nextX < 0 || nextY < 0 || nextX >= x || nextY >= y)
                continue;
            if (visited[nextX][nextY] || cheese[nextX][nextY] == 1)
                continue;
            cheese[nextX][nextY] = 2;
            dfs(nextX, nextY);
        }
    }

    private static void meltCheese() {
        // 치즈를 녹임
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                if (melt[i][j])
                    cheese[i][j] = 0;

        // 외부 공기 접촉 여부를 초기화
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                if (cheese[i][j] == 2)
                    cheese[i][j] = 0;
    }
}
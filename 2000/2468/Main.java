import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    private final static int DX[] = { 1, -1, 0, 0 };
    private final static int DY[] = { 0, 0, 1, -1 };
    private static int[][] map, temp;
    private static int[] result;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(reader.readLine());

        map = new int[size][size];
        result = new int[101];

        for (int i = 0; i < size; i++)
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= 100; i++) {
            createTemp(i);
            track(i);
        }

        Arrays.sort(result);
        System.out.println(result[100]);
    }

    private static void createTemp(int height) {
        temp = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (map[i][j] > height - 1)
                    temp[i][j] = 1;
    }

    private static void track(int height) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (temp[i][j] == 1) {
                    dfs(i, j);
                    count += 1;
                }
            }
        }
        result[height] = count;
    }

    private static void dfs(int x, int y) {
        temp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];

            if (nextX < 0 || nextY < 0 || nextX > size - 1 || nextY > size - 1 || temp[nextX][nextY] == 0)
                continue;

            dfs(nextX, nextY);
        }
    }

}
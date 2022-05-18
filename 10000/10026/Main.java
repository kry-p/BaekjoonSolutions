import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    private final static int[] DX = { 0, 0, 1, -1 };
    private final static int[] DY = { 1, -1, 0, 0 };
    private final static String[] RGB = { "R", "G", "B" };
    private static int[] result;
    private static int[][] temp;
    private static int size, sum;
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(reader.readLine());
        map = new String[size][size];

        for (int i = 0; i < size; i++) {
            map[i] = reader.readLine().split("");
        }

        calculate(false);
        calculate(true);
    }

    private static void calculate(boolean isBlind) {
        result = new int[4];
        sum = 0;

        if (isBlind) {
            createRGB(RGB[0]);
            createRGB(RGB[1]);
            track(3); // 색약이 구분한 빨강-초록을 제 4의 색으로 처리
            createRGB(RGB[2]);
            track(2);
        } else {
            // RGB 각각 구함
            for (int i = 0; i < RGB.length; i++) {
                temp = new int[size][size];
                createRGB(RGB[i]);
                track(i);
            }
        }

        for (int i = 0; i < result.length; i++)
            sum += result[i];

        System.out.print(sum + " ");
    }

    // 각각 RGB 배열을 생성
    // 0: R 1: G 2: B
    private static void createRGB(String rgb) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (map[i][j].equals(rgb))
                    temp[i][j] = 1;
    }

    private static void track(int rgb) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (temp[i][j] == 1) {
                    dfs(i, j);
                    count += 1;
                }
            }
        }
        result[rgb] = count;
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
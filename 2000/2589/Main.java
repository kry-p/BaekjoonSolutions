import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    private static int[] DX = { 1, -1, 0, 0};
    private static int[] DY = { 0, 0, 1, -1}; 
    private static boolean[][] isVisited;
    private static int row, col;
    private static String[][] map;
    private static int[][] len;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        row = size[0];
        col = size[1];

        map = new String[row][col];
        len = new int[row][col];
        isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String[] input = reader.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = input[j];
            }
        }
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j].equals("L")) {
                    len = new int[row][col];
                    isVisited = new boolean[row][col];
                    bfs(i, j);
                    for (int k = 0; k < row; k++) {
                        for (int l = 0; l < col; l++) {
                            max = Math.max(max, len[k][l]);
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col)
                    continue;
                if (isVisited[nextX][nextY])
                    continue;
                if (map[nextX][nextY].equals("W"))
                    continue;
                isVisited[nextX][nextY] = true;
                len[nextX][nextY] = len[current.x][current.y] + 1;
                queue.add(new Point(nextX, nextY));
            }
        }

    }
}

class Point {
    public int x, y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
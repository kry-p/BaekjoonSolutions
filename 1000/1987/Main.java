import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static boolean[] isAlphabetVisited;
    private static boolean[][] isMapVisited;
    private static String[][] map;
    private static int r, c;
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split(" ");
        r = Integer.parseInt(size[0]);
        c = Integer.parseInt(size[1]);
        map = new String[r][c];

        for (int i = 0; i < r; i++)
            map[i] = reader.readLine().split("");

        isAlphabetVisited = new boolean[26];
        isMapVisited = new boolean[r][c];
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int x, int y, int depth) {
        isMapVisited[x][y] = true;
        isAlphabetVisited[map[x][y].charAt(0) - 'A'] = true;
        max = Math.max(max, depth);

        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];

            if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c)
                continue;
            if (isMapVisited[nextX][nextY])
                continue;
            int nextAlphabet = map[nextX][nextY].charAt(0) - 'A';
            if (isAlphabetVisited[nextAlphabet])
                continue;
            
            isAlphabetVisited[nextAlphabet] = true;
            isMapVisited[nextX][nextY] = true;
            dfs(nextX, nextY, depth + 1);
            isAlphabetVisited[nextAlphabet] = false;
            isMapVisited[nextX][nextY] = false;
        }
    }
}
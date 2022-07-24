import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Main {
    private static int[] DX = {1, -1, 0, 0};
    private static int[] DY = {0, 0, 1, -1};
    private static int[][] map, mapBak;
    private static int temp, height, willExplode;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        boolean isExploded = false; 
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        height = input[0];
        willExplode = input[1];
        map = new int[height][10];
        mapBak = new int[height][10];

        for (int i = 0; i < height; i++) 
            map[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        copyArray(map, mapBak);
        do {
            Queue<Point> explodedPoint = new LinkedList<>(); 
            isExploded = false;

            for (int i = 0; i < height; i++) 
                for (int j = 0; j < 10; j++) 
                    if (map[i][j] != 0) {
                        temp = 0;
                        dfs(i, j, map);
                        if (temp >= willExplode) {
                            explodedPoint.add(new Point(i, j));
                            isExploded = true;
                        }
                    }
            while (!explodedPoint.isEmpty()) {
                Point p = explodedPoint.poll();
                dfs(p.x, p.y, mapBak);
            }
            for (int i = 0; i < 10; i++) {
                Stack<Integer> verticalPuyos = new Stack<>();
                for (int j = 0; j < height; j++) {
                    if (mapBak[j][i] != 0)
                        verticalPuyos.add(mapBak[j][i]);
                }
                int index = height - 1;
                while(!verticalPuyos.isEmpty()) {
                    mapBak[index][i] = verticalPuyos.pop();
                    index -= 1;
                }
                for (int j = index; j >= 0; j--) {
                    mapBak[j][i] = 0;
                }
            }
            copyArray(mapBak, map);
        } while (isExploded);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < 10; j++) 
                builder.append(map[i][j]);
            builder.append("\n");
        }        
        System.out.print(builder.toString());
    }
    
    private static void copyArray(int[][] source, int[][] destination) {
        for (int i = 0; i < source.length; i++) 
           System.arraycopy(source[i], 0, destination[i], 0, source[0].length); 
    }

    private static void dfs(int x, int y, int[][] map) {
        int current = map[x][y];
        map[x][y] = 0;
        temp += 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];

            if (nextX < 0 || nextY < 0 || nextX >= height || nextY >= 10)
                continue;
    
            if (map[nextX][nextY] == current)
                dfs(nextX, nextY, map);
        }
    }
}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] map = new int[x][y];

        for (int i = 0; i < x; i++) {
            String[] ln = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                map[i][j] = ln[j].charAt(0) - 48;
            }
        }

        Picture picture = new Picture(map);
        System.out.println(picture.getPictureCount());
        System.out.println(picture.getBiggestPictureSize());
    }
}

class Picture {

    private int[][] map;
    private int x, y;

    private int biggestPictureSize, pictureCount;
    private int temp;

    private final int dx[] = { 1, -1, 0, 0 };
    private final int dy[] = { 0, 0, 1, -1 };

    public Picture(int[][] map) {
        this.map = map;

        x = map.length;
        y = map[0].length;

        biggestPictureSize = 0;
        pictureCount = 0;

        track();
    }

    private void track() {
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (map[i][j] == 1) {
                    temp = 0;
                    dfs(i, j);
                    pictureCount += 1;
                    biggestPictureSize = Math.max(biggestPictureSize, temp);
                }
            }
        }
    }

    private void dfs(int x, int y) {

        map[x][y] = 0;
        temp += 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= this.x || nextY >= this.y || map[nextX][nextY] == 0)
                continue;

            dfs(nextX, nextY);
        }
    }

    public int getPictureCount() {
        return pictureCount;
    }

    public int getBiggestPictureSize() {
        return biggestPictureSize;
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] map = new int[x][y];

        for (int i = 0; i < x; i++) {
            String ln = br.readLine();
            for (int j = 0; j < y; j++) {
                map[i][j] = ln.charAt(j) - 48;
            }
        }

        Percolate percolate = new Percolate(map);
        System.out.println(percolate.getResult());
    }
}

class Percolate {

    private int[][] map;
    private int x, y;
    private boolean connected;
    private boolean[][] isVisited;

    private final int dx[] = { 1, -1, 0, 0 };
    private final int dy[] = { 0, 0, 1, -1 };

    public Percolate(int[][] map) {
        this.map = map;

        x = map.length;
        y = map[0].length;
        connected = false;
        isVisited = new boolean[x][y];

        for (int i = 0; i < map[0].length; i++) {
            if (map[0][i] == 0)
                track(0, i);
        }
    }

    private void track(int x, int y) {
        isVisited[x][y] = true;

        if (x == this.x - 1) {
            connected = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= this.x || nextY >= this.y)
                continue;
            if (map[nextX][nextY] == 1)
                continue;
            if (isVisited[nextX][nextY])
                continue;
            track(nextX, nextY);
        }
    }

    public String getResult() {
        return connected ? "YES" : "NO";
    }
}
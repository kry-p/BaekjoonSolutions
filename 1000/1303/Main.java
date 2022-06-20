import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static String[][] map;
    private static int n, m, black, white, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);
        black = 0;
        white = 0;

        map = new String[m][n];
        for (int i = 0; i < m; i++) 
            map[i] = reader.readLine().split("");
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String current = map[i][j];
                if (map[i][j].equals("B") || map[i][j].equals("W")) {
                    temp = 0;
                    dfs(i, j, current);
                    if (current.equals("B"))
                        black += (int) Math.pow(temp, 2);
                    else
                        white += (int) Math.pow(temp, 2);
                }
            }
        }
        System.out.println(white + " " + black);
    }

    private static void dfs(int x, int y, String current) {
        map[x][y] = "V";
        temp += 1;
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];

            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || map[nextX][nextY].equals("V"))
                continue;
            if (map[nextX][nextY].equals(current))
                dfs(nextX, nextY, current);
        }
    }
}
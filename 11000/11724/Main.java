import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split(" ");

        int vertex = Integer.parseInt(size[0]);
        int edge = Integer.parseInt(size[1]);
        int count = 0;
        int hasNoConnection = 0;

        int[][] map = new int[vertex + 1][vertex + 1];

        for (int i = 0; i < edge; i++) {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            map[a][b] = map[b][a] = 1;
        }

        for (int i = 1; i < map.length; i++) {
            int connection = 0;
            for (int j = 1; j < map[0].length; j++) {
                if(map[i][j] == 1) 
                    connection += 1;
            }

            if (connection == 0)
                hasNoConnection += 1;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    count += 1;
                    scan(map, i, j);
                    scan(map, j, i);
                }
            }
        }
        
        System.out.print(count + hasNoConnection);
    }

    public static void scan(int[][] map, int x, int y) {
        map[x][y] = 0;

        for (int i = 0; i < map.length; i++) 
            if (map[y][i] == 1)
                scan(map, y, i);
    }
}
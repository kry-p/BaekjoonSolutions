import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static boolean[][][] isVisited;
    private static int[][] map;
    private static int sizeX, sizeY;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sizeX = size[0];
        sizeY = size[1];
        isVisited = new boolean[sizeX][sizeY][4];
        map = new int[sizeX][sizeY];
        
        for (int i = 0; i < sizeX; i++)
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
        for (int i = 0; i < sizeX; i++) 
            for (int j = 0; j < sizeY; j++) 
                if (map[i][j] == 9)
                    bfs(i, j);
            
        int count = 0;
        for (int i = 0; i < sizeX; i++) 
            for (int j = 0; j < sizeY; j++) 
                for (int k = 0; k < 4; k++) 
                    if (isVisited[i][j][k]) {
                        count += 1;
                        break;
                    }
                
        System.out.println(count);
    }
    
    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            queue.add(new Point(x, y, i));
            isVisited[x][y][i] = true;
        }
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int nextX = current.x + DX[current.direction];
            int nextY = current.y + DY[current.direction];
                
            if (nextX < 0 || nextY < 0 || nextX >= sizeX || nextY >= sizeY)
                continue;
            // 해당 방향으로 방문했으면 재방문하지 않음
            if (isVisited[nextX][nextY][current.direction])
                continue;

            isVisited[nextX][nextY][current.direction] = true;
            switch (map[nextX][nextY]) {
                case 1:
                    if (current.direction % 2 == 1) 
                        continue;
                    break;
                case 2:
                    if (current.direction % 2 == 0)
                        continue;
                    break;
                case 3:
                    if (current.direction == 0) current.direction = 1;
                    else if (current.direction == 1) current.direction = 0;
                    else if (current.direction == 2) current.direction = 3;
                    else current.direction = 2;
                    break;
                case 4:
                    if (current.direction == 0) current.direction = 3;
                    else if (current.direction == 1) current.direction = 2;
                    else if (current.direction == 2) current.direction = 1;
                    else current.direction = 0;
                    break;
            } 
            queue.add(new Point(nextX, nextY, current.direction));
        }
    }
}

class Point {
    public int x, y;
    public int direction; // 0: right, 1: down, 2: left, 3: up
    public Point(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
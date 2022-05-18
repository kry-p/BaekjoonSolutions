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
    private static String[][] map, mapBak;
    private static int temp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExploded = false; // 각 스캔에서 터졌는지 체크
        int currentRen = 0; // 연쇄 횟수
        map = new String[12][6];
        mapBak = new String[12][6];

        for (int i = 0; i < 12; i++) 
            map[i] = reader.readLine().split("");

        copyArray(map, mapBak); // 원본 배열의 백업

        do {
            Queue<Point> explodedPoint = new LinkedList<>(); // 터질 뿌요의 시작점을 저장
            isExploded = false;

            // 필드를 순회해 터질 뿌요를 찾음
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!map[i][j].equals(".")) {
                        temp = 0;
                        dfs(i, j, map);
                        if (temp >= 4) {
                            explodedPoint.add(new Point(i, j));
                            isExploded = true;
                        }
                    }
                }
            }
            // 터진 뿌요가 하나 이상이면 연쇄 횟수 증가
            if (isExploded)
                currentRen += 1;
            // 실제 반영될 필드에서 뿌요를 터뜨림
            while (!explodedPoint.isEmpty()) {
                Point p = explodedPoint.poll();
                dfs(p.x, p.y, mapBak);
            }
            // 뿌요를 내려 필드를 다시 그림
            for (int i = 0; i < 6; i++) {
                Stack<String> verticalPuyos = new Stack<>();
                for (int j = 0; j < 12; j++) {
                    if (!mapBak[j][i].equals("."))
                        verticalPuyos.add(mapBak[j][i]);
                }
                int index = 11;
                while(!verticalPuyos.isEmpty()) {
                    mapBak[index][i] = verticalPuyos.pop();
                    index -= 1;
                }
                for (int j = index; j >= 0; j--) {
                    mapBak[j][i] = ".";
                }
            }
            copyArray(mapBak, map);
        } while (isExploded);

        System.out.println(currentRen);
    }
    
    // 2차원 배열 복사
    private static void copyArray(String[][] source, String[][] destination) {
        for (int i = 0; i < source.length; i++) 
           System.arraycopy(source[i], 0, destination[i], 0, source[0].length); 
    }

    private static void dfs(int x, int y, String[][] map) {
        String current = map[x][y];
        map[x][y] = ".";
        temp += 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];

            if (nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6)
                continue;
    
            if (map[nextX][nextY].equals(current))
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

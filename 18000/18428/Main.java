import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static boolean[] isVisited;
    private static int[] result;
    private static String[][] map;
    private static int size, blankCount;
    private static boolean isCanHide = false;
    private static ArrayList<Point> blankList, teacherList;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        blankList = new ArrayList<>();
        teacherList = new ArrayList<>();
        size = Integer.parseInt(reader.readLine());
        blankCount = 0;
        result = new int[3];
        map = new String[size][size];

        for (int i = 0; i < size; i++) {
            map[i] = reader.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                if (map[i][j].equals("X")) {
                    blankCount += 1;
                    blankList.add(new Point(i, j));
                }
                if (map[i][j].equals("T"))
                    teacherList.add(new Point(i, j));
            }
        }
        isVisited = new boolean[blankCount];
        dfs(0, 0);

        System.out.println(isCanHide ? "YES" : "NO");
    }
    
    private static void dfs(int depth, int latest) {
        if (depth == 3) {
            // 장애물을 배치
            placeObstacle(result);

            boolean seek = false;
            // 선생님이 학생을 찾음
            for (int i = 0; i < teacherList.size(); i++) {
                seek = seek || findStudentForTeacher(teacherList.get(i));
            }
            if (!seek) {
                isCanHide = true;
            }
            
            // 장애물을 다시 치움
            removeObstacle(result);
            return;
        }

        for (int i = 0; i < blankCount; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = i - 1;

                if (latest <= result[depth]) {
                    dfs(depth + 1, result[depth]);
                }
                isVisited[i] = false;
            }
        }
    }

    private static void placeObstacle(int[] obstaclePositions) {
        for (int position : obstaclePositions) {
            Point realPosition = blankList.get(position);
            map[realPosition.x][realPosition.y] = "O";
        }
    }

    private static void removeObstacle(int[] obstaclePositions) {
        for (int position : obstaclePositions) {
            Point realPosition = blankList.get(position);
            map[realPosition.x][realPosition.y] = "X";
        }
    }

    // 찾으면 true, 못 찾으면 false
    private static boolean findStudentForTeacher(Point teacherPos) {
        boolean result = false;
        int[] DX = { 1, -1, 0, 0};
        int[] DY = { 0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int directionX = DX[i];
            int directionY = DY[i];
            int length = 0;

            while (true) {
                length += 1;
                int nextX = teacherPos.x + directionX * length; 
                int nextY = teacherPos.y + directionY * length; 
            
                // 범위를 넘어가면 탐색 중단 (찾을 수 없음)
                if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size) 
                    break;
                // 장애물을 만나면 탐색 중단
                if (map[nextX][nextY].equals("O"))
                    break;
                // 학생을 찾음
                if (map[nextX][nextY].equals("S")) 
                    return true;
            }
        }

        return result;
    }
}

class Point {
    public int x, y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
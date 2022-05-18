import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] map;
    private static int row, column;

    private static final int[] DX = { 0, 1, -1, 0, 0 };
    private static final int[] DY = { 0, 0, 0, 1, -1 };

    private static Queue<Point> boomQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        row = Integer.parseInt(tokenizer.nextToken());
        column = Integer.parseInt(tokenizer.nextToken());
        int time = Integer.parseInt(tokenizer.nextToken());

        map = new int[row][column];
        boomQueue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            String line = reader.readLine();

            for (int j = 0; j < column; j++) {
                map[i][j] = line.charAt(j) == '.' ? 0 : 3;
            }
        }

        int current = 0;

        if (time != 0) {
            while (true) {
                current += 1;
                elapse();
                if (current % 2 == 0) {
                    install();
                }
                if (current == time)
                    break;
            }
        }

        print();
    }

    private static void install() {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                if (map[i][j] == 0)
                    map[i][j] = 3;
    }

    private static void elapse() {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 0)
                    continue;
                if (map[i][j] == 1)
                    boomQueue.add(new Point(i, j));
                if (map[i][j] > 1)
                    map[i][j] -= 1;
            }

        boom();
    }

    private static void boom() {
        while (!boomQueue.isEmpty()) {
            Point boomPoint = boomQueue.poll();

            for (int i = 0; i < 5; i++) {
                int currentX = boomPoint.getX() + DX[i];
                int currentY = boomPoint.getY() + DY[i];

                if (currentX < 0 || currentX > row - 1 || currentY < 0 || currentY > column - 1)
                    continue;
                map[currentX][currentY] = 0;
            }
        }
    }

    private static void print() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                builder.append(map[i][j] > 0 ? "O" : ".");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

    private static void print_test() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                builder.append(map[i][j]);
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    };

    public int getY() {
        return y;
    }
}

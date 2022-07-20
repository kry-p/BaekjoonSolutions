import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Point[] points = new Point[3];

        for (int i = 0; i < 3; i++) {
            String[] input = reader.readLine().split(" ");
            points[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int result = ccw(points[0], points[1], points[2]);
        if (result > 0) System.out.println("1");
        if (result == 0) System.out.println("0");
        if (result < 0) System.out.println("-1");
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        return (p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y);
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
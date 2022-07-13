import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(reader.readLine());
        Point[] points = new Point[vertex + 1];
        double sumLeft = 0, sumRight = 0;

        for (int i = 0; i < vertex; i++) {
            String[] input = reader.readLine().split(" ");
            points[i] = new Point(Double.parseDouble(input[0]), Double.parseDouble(input[1]));
        }
        points[vertex] = new Point(points[0].x, points[0].y);

        // 신발끈 공식
        for (int i = 0; i < vertex; i++) {
            sumLeft += points[i].x * points[i + 1].y;
            sumRight += points[i].y * points[i + 1].x;
        }

        System.out.print(String.format("%.1f", (Math.abs(sumLeft - sumRight)) / 2.0));
    }
}

class Point {
    public double x, y;
    public Point(double x, double y) {
        this.x = x; this.y = y;
    }
}

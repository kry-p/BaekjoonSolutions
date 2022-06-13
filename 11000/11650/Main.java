import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Point> queue = new PriorityQueue<>();
        StringBuilder builder = new StringBuilder();
        int size = Integer.parseInt(reader.readLine());

        for (int i = 0; i < size; i++) { 
            String[] input = reader.readLine().split(" ");
            queue.add(new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            builder.append(p.getX() + " " + p.getY() + "\n");
        }
        System.out.print(builder.toString());
    }
}

class Point implements Comparable<Point> {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.x > p.getX()) {
            return 1;
        } else if (this.x == p.getX()) {
            return this.y - p.getY();
        } else {
            return -1;
        }
    }
}
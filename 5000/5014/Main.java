import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[] attempt;
    public static int floors, start, goal, up, down, result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();

        attempt = new int[input[0] + 1];
        floors = input[0];
        start = input[1];
        goal = input[2];
        up = input[3];
        down = input[4];

        if (start == goal) {
            System.out.print(0);
        } else {
            result = bfs();
            if (result == -1) {
                System.out.print("use the stairs");
            } else {
                System.out.print(result);
            }
        }
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        attempt[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
        
            if (current == goal) {
                return attempt[current] - 1;
            }

            // up
            if (current + up <= floors) {
                if (attempt[current + up] == 0) {
                    attempt[current + up] = attempt[current] + 1;
                    queue.add(current + up);
                }
            }

            // down
            if (current - down > 0) {
                if (attempt[current - down] == 0) {
                    attempt[current - down] = attempt[current] + 1;
                    queue.add(current - down); 
                }
            }
        }

        return -1;
    }
}
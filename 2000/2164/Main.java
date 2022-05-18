import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int number = scanner.nextInt();

        for (int i = 1; i <= number; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.peek());

        scanner.close();
    }
}
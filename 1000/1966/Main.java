import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Collections;

public final class Main {

    private static int attempt;
    private static Queue<Integer> print, initialPosition;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        attempt = scanner.nextInt();
        print = new LinkedList<>();
        initialPosition = new LinkedList<>();

        for (int i = 0; i < attempt; i++) {
            int queueSize = scanner.nextInt();
            int pos = scanner.nextInt();
            int attempt = 0;

            for (int j = 0; j < queueSize; j++) {
                print.add(scanner.nextInt());
                initialPosition.add(j);
            }

            while (true) {
                if (print.isEmpty())
                    break;
                int currentPoll = print.peek();

                if (currentPoll < Collections.max(print)) {
                    print.add(print.poll());
                    initialPosition.add(initialPosition.poll());
                } else {
                    print.poll();
                    attempt += 1;
                    if (initialPosition.poll() == pos) {
                        builder.append(Integer.toString(attempt) + "\n");
                        break;
                    }
                }
            }
            print.clear();
            initialPosition.clear();
        }

        scanner.close();
        System.out.println(builder.toString());
    }
}
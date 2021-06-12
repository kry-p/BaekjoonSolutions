import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> absQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if (abs1 > abs2)
                    return 1;
                else if (abs1 == abs2) {
                    if (o1 > o2)
                        return 1;
                    else
                        return -1;
                } else {
                    return -1;
                }
            }
        });

        int attempt = scanner.nextInt();

        for (int i = 0; i < attempt; i++) {
            int value = scanner.nextInt();
            if (value == 0) {
                if (absQueue.isEmpty()) {
                    System.out.println("0");
                } else
                    System.out.println(absQueue.poll());
            } else {
                absQueue.add(value);
            }
        }

        scanner.close();
    }
}

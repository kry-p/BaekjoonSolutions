import java.util.Scanner;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Arrays;

public class Main {
    private static boolean[] isVisited;
    private static int result, hidePos;
    private static int[] attempt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        scanner.close();

        isVisited = new boolean[100001];
        attempt = new int[100001];

        int seekPos = Integer.parseInt(input[0]);
        hidePos = Integer.parseInt(input[1]);

        Arrays.fill(attempt, -1);
        attempt[seekPos] = 0;

        if (hidePos == seekPos) {
            System.out.println(0);
        } else {
            zeroOneBfs(seekPos);
            System.out.println(attempt[hidePos]);
        }
    }

    private static void zeroOneBfs(int pos) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(pos);

        while (!deque.isEmpty()) {
            int current = deque.poll();
            int next;

            // 2 * n
            next = current * 2;
            if (next >= 0 && next <= 100000) {
                if (!isVisited[next]) {
                    attempt[next] = attempt[current];
                    deque.addFirst(next);
                    isVisited[next] = true;
                }
            }

            // n + 1
            next = current + 1;
            if (next >= 0 && next <= 100000) {
                if (!isVisited[next]) {
                    attempt[next] = attempt[current] + 1;
                    deque.addLast(next);
                    isVisited[next] = true;
                }
            }

            // n - 1
            next = current - 1;
            if (next >= 0 && next <= 100000) {
                if (!isVisited[next]) {
                    attempt[next] = attempt[current] + 1;
                    deque.addLast(next);
                    isVisited[next] = true;
                }
            }
            
        }
    }
}
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static boolean[] isVisited;
    private static int result, hidePos;
    private static int[] attempt;
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        scanner.close();

        isVisited = new boolean[100001];
        attempt = new int[100001];

        int seekPos = Integer.parseInt(input[0]);
        hidePos = Integer.parseInt(input[1]);

        count = 0;
        result = 2147483647;

        if (hidePos == seekPos) {
            System.out.println(0);
            System.out.println(1);
        } else {
            bfs(seekPos);
            System.out.println(result);
            System.out.println(count);
        }
    }

    public static void bfs(int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        attempt[pos] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] next = { current - 1, current + 1, current * 2 };

            if (attempt[current] > result)
                return;

            for (int n : next) {
                if (n < 0 || n > 100000)
                    continue;

                if (n == hidePos) {
                    result = attempt[current];
                    count++;
                }

                if (!isVisited[n] || attempt[n] == attempt[current] + 1) {
                    queue.add(n);
                    attempt[n] = attempt[current] + 1;
                    isVisited[n] = true;
                }
            }
        }
    }
}
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

        if (hidePos == seekPos) {
            System.out.println(0);
        } else {
            bfs(seekPos);
            System.out.println(result);
        }
    }

    public static void bfs(int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        isVisited[pos] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] next = { current - 1, current + 1, current * 2 };

            for (int n : next) {
                if (n == hidePos) {
                    result = attempt[current] + 1;
                    return;
                }

                if (n >= 1 && n < 100001 && !isVisited[n]) {
                    queue.add(n);
                    attempt[n] = attempt[current] + 1;
                    isVisited[n] = true;
                }
            }
        }
    }
}
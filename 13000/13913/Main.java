import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    private static boolean[] isVisited;
    private static int result, hidePos;
    private static int[] attempt, prev;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        scanner.close();

        isVisited = new boolean[100001];
        attempt = new int[100001];
        prev = new int[100001];

        int seekPos = Integer.parseInt(input[0]);
        hidePos = Integer.parseInt(input[1]);
        result = 2147483647;

        if (hidePos == seekPos) {
            System.out.println(0);
            System.out.println(seekPos);
        } else {
            bfs(seekPos);
            System.out.println(result);

            Stack<Integer> stack = new Stack<>();
            int current = hidePos;
            while (true) {
                stack.add(current);
                int next = prev[current];
                if (next == seekPos) break;
                current = next;
            }
            stack.add(seekPos);
            StringBuilder builder = new StringBuilder();
            
            while (!stack.isEmpty()) 
                builder.append(stack.pop() + " ");
            System.out.println(builder.toString());
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
                    prev[n] = current;
                }

                if (!isVisited[n] || attempt[n] == attempt[current] + 1) {
                    queue.add(n);
                    attempt[n] = attempt[current] + 1;
                    prev[n] = current;
                    isVisited[n] = true;
                }
            }
        }
    }
}
import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    private final static String[] symbols = { "+", "-", "*", "/" };

    private static int min, max, size;
    private static String[] operation, result;
    private static Stack<String[]> operations;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = scanner.nextInt();

        arr = new int[size];
        int[] oper = new int[4];
        int pos = 0;

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        operation = new String[size - 1];
        result = new String[size - 1];
        visited = new boolean[size - 1];
        operations = new Stack<String[]>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            oper[i] = scanner.nextInt();
        }

        for (int i = 0; i < oper.length; i++) {

            if (oper[i] != 0) {
                for (int j = 0; j < oper[i]; j++) {
                    operation[pos] = symbols[i];
                    pos += 1;
                }
            }
        }
        calc(0);

        System.out.println(max + "\n" + min);
    }

    private static void calc(int depth) {
        if (depth == size - 1) {
            int temp = arr[0];
            for (int i = 0; i < result.length; i++) {
                if (result[i].equals("+")) {
                    temp += arr[i + 1];
                }
                if (result[i].equals("-")) {
                    temp -= arr[i + 1];
                }
                if (result[i].equals("*")) {
                    temp *= arr[i + 1];
                }
                if (result[i].equals("/")) {
                    temp /= arr[i + 1];
                }
            }

            max = Math.max(max, temp);
            min = Math.min(min, temp);

            return;
        }

        for (int i = 0; i < size - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = operation[i];
                calc(depth + 1);
                visited[i] = false;
            }
        }
        return;
    }
}
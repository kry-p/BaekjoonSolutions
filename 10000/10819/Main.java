import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static boolean[] isVisited;
    private static int[] temp, arr;
    private static int max, size;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        arr = new int[size];
        isVisited = new boolean[size];
        temp = new int[size];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();

        scanner.close();
        track(0);

        System.out.println(max);
    }

    private static void track(int depth) {
        if (depth == size) {
            calculate(temp);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                temp[depth] = i;
                track(depth + 1);

                isVisited[i] = false;
            }
        }
        return;
    }

    private static void calculate(int[] order) {
        int result = 0;
        for (int i = 0; i < size - 1; i++) {
            result += Math.abs(arr[order[i]] - arr[order[i + 1]]);
        }
        max = Math.max(result, max);
    }
}
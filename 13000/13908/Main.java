import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static int size, count;
    private static int[] required;
    private static Integer[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = scanner.nextInt();
        count = 0;
        int reqCount = scanner.nextInt();

        required = new int[reqCount];
        result = new Integer[size];

        for (int i = 0; i < reqCount; i++) {
            required[i] = scanner.nextInt();
        }

        track(0);

        scanner.close();
        System.out.print(count);
    }

    private static void track(int depth) {
        if (depth == size) {
            for (int i = 0; i < required.length; i++) {
                if (!Arrays.asList(result).contains(required[i]))
                    return;
            }
            count += 1;
            return;
        }

        for (int i = 0; i < 10; i++) {
            result[depth] = i;
            track(depth + 1);
        }
        return;
    }
}
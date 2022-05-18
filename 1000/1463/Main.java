import java.util.Scanner;

public class Main {

    private static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        result = new int[input + 1];
        System.out.println(calculate(input));
        scanner.close();
    }

    private static int calculate(int num) {
        for (int i = 2; i <= num; i++) {
            result[i] = result[i - 1] + 1;
            if (i % 2 == 0)
                result[i] = Math.min(result[i / 2] + 1, result[i]);
            if (i % 3 == 0)
                result[i] = Math.min(result[i / 3] + 1, result[i]);
        }

        return result[num];
    }
}

import java.util.Scanner;

public class Main {
    private static int result, size;
    private static boolean[] check;
    private final static int[] ROME = { 1, 5, 10, 50 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        result = 0;
        check = new boolean[1001];
        scanner.close();

        calc(0, 0, 0);

        System.out.println(result);
    }

    private static void calc(int current, int pos, int index) {
        if (pos == size) {
            if (!check[current]) {
                check[current] = true;
                result += 1;
            }
            return;
        }

        for (int i = index; i < 4; i++) {
            calc(current + ROME[i], pos + 1, i);
        }
    }
}
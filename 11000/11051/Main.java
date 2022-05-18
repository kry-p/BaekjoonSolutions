import java.util.Scanner;

public class Main {
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        memo = new int[n + 1][n + 1];

        scanner.close();
        System.out.println(recursive(n, k));
    }

    private static int recursive(int n, int k) {
        if (memo[n][k] != 0)
            return memo[n][k];
        if (n == k || k == 0)
            return memo[n][k] = 1;

        return memo[n][k] = (recursive(n - 1, k - 1) + recursive(n - 1, k)) % 10007;
    }
}
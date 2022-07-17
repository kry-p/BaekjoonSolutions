import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] T = new int[n + 1];
        int[] P = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; ++i) {
            max = Math.max(max, dp[i]);
            int next = i + T[i];
            if (next <= n) dp[next] = Math.max(dp[next], max + P[i]);
        }

        System.out.println(max);
    }
}
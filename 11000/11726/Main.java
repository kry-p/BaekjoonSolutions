import java.io.*;
import java.util.*;

public class Main {
    private final static int DIVISOR = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        int[] dp = new int[1002];
        dp[1] = 1;

        for (int i = 2; i <= 1000; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIVISOR;

        System.out.println(dp[input + 1]);
    }
}
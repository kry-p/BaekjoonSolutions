import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
import java.util.Arrays;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        BigInteger[][] dp = new BigInteger[101][101];

        for (int n = 0; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                if (n == r || r == 0) 
                    dp[n][r] = new BigInteger("1");
                else
                    dp[n][r] = dp[n - 1][r - 1].add(dp[n - 1][r]);
            }
        }

        System.out.println(dp[Integer.parseInt(input[0])][Integer.parseInt(input[1])]);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCase; i++) {
            int column = Integer.parseInt(reader.readLine());
            int[][] dp = new int[2][column + 1];
            int[][] map = new int[2][column];

            for (int j = 0; j < 2; j++)
                map[j] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            dp[0][1] = map[0][0];
            dp[1][1] = map[1][0];

            for (int j = 1; j < column; j++) {
                dp[0][j + 1] = Math.max(dp[1][j], dp[1][j - 1]) + map[0][j];
                dp[1][j + 1] = Math.max(dp[0][j], dp[0][j - 1]) + map[1][j];
            }

            System.out.println(Math.max(dp[0][column], dp[1][column]));
        }

    }
}
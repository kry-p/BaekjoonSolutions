import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main { 
    private final static int DIVIDER = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        int[] dp = new int[input + 1];

        if (input < 2) {
            System.out.print(input);
        } else {
            dp[1] = 1;

            for (int i = 2; i <= input; i++) 
                dp[i] = (dp[i - 1]  + dp[i - 2]) % DIVIDER;
    
            System.out.print(dp[input]);
        }
    }
}
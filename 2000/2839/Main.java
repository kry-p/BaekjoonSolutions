import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        int[] dp = new int[5000 + 1];
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= input; i++) {
            if (dp[i - 3] == 0 && dp[i - 5] == 0)
                dp[i] = 0;
            else 
                if (dp[i - 3] == 0)
                    dp[i] = dp[i - 5] + 1;
                else if (dp[i - 5] == 0)
                    dp[i] = dp[i - 3] + 1;
                else
                    dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;    
        }
           
        int result = dp[input];
        System.out.println(result == 0 ? -1 : result);
    }
}
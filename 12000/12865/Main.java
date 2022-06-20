import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int elementCount = Integer.parseInt(input[0]);
        int capacity = Integer.parseInt(input[1]);
        
        int[][] dp = new int[elementCount + 1][capacity + 1];
        int[] weight = new int[elementCount];
        int[] value = new int[elementCount];
        
        for (int i = 0; i < elementCount; i++) {
            int[] jewel = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            weight[i] = jewel[0];
            value[i] = jewel[1];
        }
		
		for (int i = 1; i <= elementCount; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0) dp[i][j] = 0;
				else if (weight[i - 1] <= j) dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
				else dp[i][j] = dp[i - 1][j];
			}
		}
		System.out.println(dp[elementCount][capacity]);
    }
}
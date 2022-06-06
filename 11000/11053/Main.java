import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[size];
 
        for (int i = 0; i < size; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) 
                if (array[j] < array[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        System.out.print(Arrays.stream(dp).max().getAsInt());
    }
}
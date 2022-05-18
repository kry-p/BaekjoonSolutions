import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] answer = new int[n + 1];
        int[] price = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    
        answer[0] = 0;
        answer[1] = price[0];

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) 
                min = Math.min(min, answer[i - j - 1] + price[j]);
            answer[i] = min;
        }

        System.out.print(answer[n]);
    }
}
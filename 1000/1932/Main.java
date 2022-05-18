import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static int[][] memo, map;
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        map = new int[size][size];
        memo = new int[size][size];

        for (int i = 0; i < size; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j <= i; j++) 
                map[i][j] = input[j];
        }
    
        memo[0][0] = map[0][0];
        
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    memo[i][j] = memo[i - 1][j] + map[i][j];
                } else if (j == i) {
                    memo[i][j] = memo[i - 1][j - 1] + map[i][j];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j - 1], memo[i - 1][j]) + map[i][j]; 
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) 
            max = Math.max(memo[size - 1][i], max);

        System.out.println(max);
    }
}
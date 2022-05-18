import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int floors = Integer.parseInt(reader.readLine());
        int[][] map = new int[floors][3];
        int[][] max = new int[floors][3];
        int[][] min = new int[floors][3];

        for (int i = 0; i < floors; i++) 
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for (int i = 0; i < 3; i++) {
            max[0][i] = map[0][i];
            min[0][i] = map[0][i];
        }

        if (floors > 1) {
            for (int i = 1; i < floors; i++) {
                max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + map[i][0];
                max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + map[i][1];
                max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + map[i][2];

                min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + map[i][0];
                min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + map[i][1];
                min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + map[i][2];
            }
        }

        int minSum = Math.min(min[floors - 1][0], Math.min(min[floors - 1][1], min[floors - 1][2]));
        int maxSum = Math.max(max[floors - 1][0], Math.max(max[floors - 1][1], max[floors - 1][2]));

        System.out.print(maxSum + " " + minSum);
    }
}
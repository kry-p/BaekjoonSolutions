import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine());
        int[][] map = new int[15][15];

        for (int i = 0; i < 15; i++)
            map[0][i] = i;

        for (int i = 1; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) 
                    sum += map[i - 1][k];
                map[i][j] = sum;
            }
        }    

        for (int i = 0; i < testCase; i++) {
            System.out.println(map[Integer.parseInt(reader.readLine())][Integer.parseInt(reader.readLine())]);
        }
    }
}
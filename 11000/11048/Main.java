import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] max, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = new int[size[0] + 1][size[1] + 1];
        max = new int[size[0] + 1][size[1] + 1];
        String[] str;
        for (int i = 1; i <= size[0]; i++) {
            str = reader.readLine().split(" ");
            for (int j = 1; j <= size[1]; j++) {
                arr[i][j] = Integer.parseInt(str[j - 1]);
            }
        }

        for (int i = 1; i <= size[0]; i++) {
            for (int j = 1; j <= size[1]; j++) {
                max[i][j] = Math.max(max[i - 1][j], Math.max(max[i][j - 1], max[i - 1][j - 1])) + arr[i][j];
            }
        }

        System.out.println(max[size[0]][size[1]]);
    }
}
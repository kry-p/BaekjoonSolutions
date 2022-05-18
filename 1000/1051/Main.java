import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split(" ");
        int max = 0, temp = 0;
        arr = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int current = arr[i][j];
                for (int k = 0; k < Math.min(arr.length, arr[0].length); k++) {
                    if (i + k < arr.length && j + k < arr[0].length) {
                        if (current == arr[i][j + k] && current == arr[i + k][j] && current == arr[i + k][j + k]) {
                            temp = (k + 1) * (k + 1);
                            max = Math.max(max, temp);
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}

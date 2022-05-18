import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static int[] stairs, result;
    // private static int[] count;
    private static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        height = Integer.parseInt(reader.readLine());
        stairs = new int[height + 1];
        // count = new int[height + 1];
        result = new int[height + 1];

        for (int i = 1; i <= height; i++) {
            stairs[i] = Integer.parseInt(reader.readLine());
        }

        // count[1] = 1;
        result[1] = stairs[1];

        if (height >= 2) {
            result[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= height; i++) {
            result[i] = Math.max(result[i - 2], result[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(result[height]);
    }

    // private static void dp() {
    // for (int i = 2; i <= height; i++) {
    // if (count[i - 1] > 1) {
    // result[i] = result[i - 2] + stairs[i];
    // count[i] = 0;
    // } else {
    // int max = Math.max(result[i - 2], result[i - 1]) + stairs[i];
    // result[i] = max;
    // if (max == (result[i - 2] + stairs[i])) {
    // count[i] = 0;
    // } else {
    // count[i] = count[i - 1] + 1;
    // }
    // }
    // }
    // }
}

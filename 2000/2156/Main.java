import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[] result = new int[size + 1];
        int[] input = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            input[i] = Integer.parseInt(reader.readLine());
        }

        result[1] = input[1];

        if (size >= 2) {
            result[2] = input[1] + input[2];
        }

        for (int i = 3; i <= size; i++) {
            result[i] = Math.max(result[i - 1],
                    Math.max(result[i - 2] + input[i], result[i - 3] + input[i - 1] + input[i]));
        }

        System.out.println(result[size]);
    }
}

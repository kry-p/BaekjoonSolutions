import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int attempt = Integer.parseInt(reader.readLine());

        for (int i = 0; i < attempt; i++) {
            int size = Integer.parseInt(reader.readLine());
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            result = new int[size];

            calculate(array, size);
            builder.append(getResult(array, size) + "\n");
        }
        System.out.print(builder.toString());
    }

    private static void calculate(int[] array, int size) {
        result[0] = array[0];

        for (int j = 1; j < size; j++) {
            result[j] = Math.max(array[j], array[j] + result[j - 1]);
        }
    }

    private static int getResult(int[] array, int size) {
        if (size == 1)
            return result[0];

        return Math.max(result[size - 1], getResult(array, size - 1));
    }
}
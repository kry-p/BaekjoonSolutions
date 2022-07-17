import java.util.*;
import java.io.*;

public class Main {
    private static int[] input, result;
    private static int size;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        result = new int[6 + 1];

        while (true) {
            input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            size = input[0];
            if (size == 0) break;

            dfs(0);
            builder.append("\n");
        }
        System.out.print(builder.toString());

        
    }
    private static void dfs(int depth) {
        if (depth == 6) {
            for (int i = 1; i <= 6; i++)
                builder.append(result[i] + " ");
            builder.append("\n");
            return;
        }
        for (int i = 1; i <= size; i++) {
            if (input[i] > result[depth]) {
                result[depth + 1] = input[i];
                dfs(depth + 1);
            }
        }
        return;
    }
}
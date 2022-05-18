import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        
        int testCase = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < testCase; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            builder.append((input[0] - 1) + "\n");
            for (int j = 0; j < input[1]; j++) {
                int[] temp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }
        
        System.out.print(builder.toString());
    }
}
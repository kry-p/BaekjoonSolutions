import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = input[1];
        int current = 0;
        int max = 0;
        int[] temperatures = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for (int i = 0; i < size; i++)
            current += temperatures[i];
        max = current;

        for (int i = 0; i < temperatures.length - size; i++) {
            current += temperatures[i + size] - temperatures[i];
            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
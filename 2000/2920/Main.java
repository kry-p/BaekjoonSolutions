import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isAscending = false, isDescending = false;

        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1])
                isAscending = true;
            if (input[i] < input[i - 1])
                isDescending = true;
        }

        System.out.println(isAscending && isDescending 
                            ? "mixed"
                            : (isAscending
                            ? "ascending" : "descending"));
    }

}
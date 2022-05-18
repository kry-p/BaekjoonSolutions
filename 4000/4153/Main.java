import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main { 
    private final static int[][] order = { {1, 2}, {0, 2}, {0, 1} };
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while (true) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int index = 0;
            int hypotenuse = 0;
            int sum = 0;
            if (input[0] + input[1] + input[2] == 0) 
                break;
            
            for (int i = 0; i < 3; i++) 
                if (input[i] > hypotenuse) {
                    index = i;
                    hypotenuse = input[i];
                }
            for (int i = 0; i < 2; i++) 
                sum += Math.pow(input[order[index][i]], 2);
            
            if (sum == Math.pow(hypotenuse, 2)) {
                builder.append("right\n");
            } else {
                builder.append("wrong\n");
            }
        }
        System.out.print(builder.toString());
    }
}
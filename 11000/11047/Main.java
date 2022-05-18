import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] categoryAndSum = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] categories = new int[categoryAndSum[0]];
        int result = 0;

        for (int i = 0; i < categories.length; i++)
            categories[i] = Integer.parseInt(reader.readLine());

        for (int i = categories.length - 1; i >= 0; i--) {
            while (categoryAndSum[1] >= categories[i]) {
                categoryAndSum[1] -= categories[i];
                result += 1;
            }
        }

        System.out.println(result);
    }
}
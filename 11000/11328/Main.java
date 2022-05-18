import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int size = Integer.parseInt(reader.readLine());
        int[][] count = new int[2][27];
        boolean result;

        for (int i = 0; i < size; i++) {
            String[] strArr = reader.readLine().split(" ");
            result = true;

            for (int j = 0; j < strArr[0].length(); j++) {
                count[0][strArr[0].charAt(j) - 96] += 1;
            }

            for (int j = 0; j < strArr[1].length(); j++) {
                count[1][strArr[1].charAt(j) - 96] += 1;
            }

            for (int j = 0; j < 27; j++) {
                if (count[0][j] != count[1][j])
                    result = false;
            }

            Arrays.fill(count[0], 0);
            Arrays.fill(count[1], 0);

            builder.append(result ? "Possible\n" : "Impossible\n");
        }

        System.out.println(builder.toString());
    }
}

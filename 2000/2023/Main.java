import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static int input;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        input = Integer.parseInt(reader.readLine());
        dfs("", 0);
        
        System.out.print(builder.toString());
    }

    private static void dfs(String number, int digit) {
        if (digit == input) {
            builder.append(number + "\n");
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (isPrimeNumber(Integer.parseInt(number + i))) {
                dfs(number + i, digit + 1);
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) 
            return false;
        
        for (int i = 2; i * i <= number; i++) 
            if (number % i == 0) 
                return false;

        return true;
    }
}
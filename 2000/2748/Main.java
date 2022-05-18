import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static long[] memo = new long[100];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(fibonacci(n));
    }

    public static long fibonacci(int n) {
        if (memo[n] != 0)
            return memo[n];
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        
        return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
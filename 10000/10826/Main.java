import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;

public class Main {
    private static BigInteger[] result = new BigInteger[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 2) {
            System.out.print(n);
        } else {
            result[0] = new BigInteger("0");
            result[1] = new BigInteger("1");
            for (int i = 2; i <= n; i++) 
                result[i] = result[i - 1].add(result[i - 2]);
            System.out.print(result[n]);
        }
    }
}
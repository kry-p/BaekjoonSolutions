import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        long gcd = Integer.parseInt(input[0]);
        long lcm = Integer.parseInt(input[1]);
        long resultA = 0;
        long resultB = 0;
        for (long i = 1; i * i <= lcm / gcd ; i++) {
            if ((lcm / gcd) % i == 0) {
                long a = i;
                long b = lcm / gcd / i;
                if (gcd(a, b) == 1) {
                    resultA = a;
                    resultB = b;
                }
            }
        }
        System.out.println(resultA * gcd + " " + resultB * gcd);
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
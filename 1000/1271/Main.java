import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        scanner.close();
        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);

        System.out.println(a.divide(b));
        System.out.println(a.remainder(b));
    }
}
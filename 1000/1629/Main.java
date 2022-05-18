import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(input[0], input[1], input[2]));
    }

    private static long getResult(int a, int b, int c) {
        if (b == 1)
            return a % c;
        long temp = getResult(a, b / 2, c);
        temp = temp * temp % c;

        if (b % 2 == 0)
            return temp;
        else
            return temp * a % c;
    }
}
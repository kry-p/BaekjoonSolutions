import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;

        for (int i = 1; i <= input; i++) {
            if (check(i))
                count += 1;
        }

        System.out.println(count);
        scanner.close();
    }

    public static boolean check(int n) {
        int digit = (int) Math.log10(n) + 1;

        if (digit == 1 || digit == 2)
            return true;
        else {
            int[] digits = new int[digit];
            int i = 0, input = n;
            while (input > 0) {
                digits[i] = input % 10;
                input /= 10;
                i += 1;
            }

            int sub = digits[0] - digits[1];

            for (int j = 0; j < digits.length - 1; j++) {
                if (digits[j] - digits[j + 1] != sub)
                    return false;
            }

            return true;
        }
    }
}

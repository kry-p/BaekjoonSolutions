import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[2];

        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }

        int[] inverted = new int[2];

        for (int i = 0; i < num.length; i++) {
            int digit = (int) Math.log10(num[i]) + 1;

            int[] digits = new int[digit];
            int j = 0;
            while (num[i] > 0) {
                digits[j] = num[i] % 10;
                num[i] /= 10;
                j += 1;
            }
            int result = 0;
            for (int k = 0; k < digits.length; k++) {
                result += Math.pow(10, digits.length - 1 - k) * digits[k];
            }

            inverted[i] = result;
        }

        if (inverted[0] > inverted[1])
            System.out.println(inverted[0]);
        else
            System.out.println(inverted[1]);
    }
}
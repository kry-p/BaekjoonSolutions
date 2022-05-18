import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        scanner.close();
        // int digits = (int) Math.log10(input) + 1;

        for (int i = 1; i <= input; i++) {
            int result = i;
            int temp = i;
            while (temp > 0) {
                result += temp % 10;
                temp /= 10;
            }
            if (result == input)
                min = Math.min(min, i);
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        int[] count = new int[10];
        int max = 0;

        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i) - 48] += 1;
        }

        int sixesAndNines = count[6] + count[9];
        count[6] = sixesAndNines % 2 == 0 ? sixesAndNines / 2 : sixesAndNines / 2 + 1;
        count[9] = 0;

        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }

        System.out.println(max);

    }
}

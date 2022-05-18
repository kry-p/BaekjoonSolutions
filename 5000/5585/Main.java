import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 1000 - scanner.nextInt();
        int count = 0;
        scanner.close();

        int[] unit = { 500, 100, 50, 10, 5, 1 };

        for (int i = 0; i < unit.length; i++) {
            while (true) {
                if (input < unit[i])
                    break;
                else {
                    input -= unit[i];
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}

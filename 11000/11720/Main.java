import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String numbers = scanner.nextLine();

        String[] numberText = numbers.split("");

        int sum = 0;

        for (String s : numberText) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int size = scanner.nextInt();

        scanner.close();

        int temp = 2 * size - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                builder.append(" ");
            }
            for (int j = 0; j < temp; j++) {
                builder.append("*");
            }
            builder.append("\n");
            temp -= 2;
        }
        temp += 4;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 2 - i; j++) {
                builder.append(" ");
            }
            for (int j = 0; j < temp; j++) {
                builder.append("*");
            }
            builder.append("\n");
            temp += 2;
        }
        System.out.println(builder.toString());

    }
}
import java.util.Scanner;

public class Main {

    private static StringBuilder builder;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        builder = new StringBuilder();
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                drawer(i, j, size);
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
        scanner.close();
    }

    public static void drawer(int i, int j, int size) {
        if ((i / size) % 3 == 1 && (j / size) % 3 == 1) {
            builder.append(" ");
        } else {
            if (size / 3 == 0)
                builder.append("*");
            else
                drawer(i, j, size / 3);
        }
    }
}

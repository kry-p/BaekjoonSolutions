import java.util.Scanner;

public class Main {

    private static StringBuilder builder;
    private static char[][] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        result = new char[size][size * 2];

        builder = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = ' ';
            }
        }

        draw(0, size - 1, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size * 2; j++) {
                builder.append(result[i][j]);
            }
            builder.append("\n");
        }

        System.out.print(builder.toString());

        scanner.close();
    }

    private static void draw(int x, int y, int size) {
        if (size == 3) {
            result[x][y] = '*';
            result[x + 1][y - 1] = result[x + 1][y + 1] = '*';
            for (int i = y - 2; i <= y + 2; i++) {
                result[x + 2][i] = '*';
            }
        } else {
            draw(x, y, size / 2);
            draw(x + size / 2, y - size / 2, size / 2);
            draw(x + size / 2, y + size / 2, size / 2);
        }
    }
}
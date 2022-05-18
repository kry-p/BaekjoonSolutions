import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split(" ");
            int repeat = Integer.parseInt(input[0]);

            for (int j = 0; j < input[1].length(); j++) {
                for (int k = 0; k < repeat; k++) {
                    builder.append(input[1].charAt(j));
                }
            }
            builder.append('\n');
        }

        System.out.println(builder.toString());
    }
}
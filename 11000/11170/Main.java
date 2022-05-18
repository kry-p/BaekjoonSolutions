import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int attempt = scanner.nextInt();

        for (int i = 0; i < attempt; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int result = 0;

            for (int j = a; j <= b; j++) {
                int current = j;
                if (current == 0) {
                    result += 1;
                    continue;
                }
                while (current > 0) {
                    int temp = current % 10;
                    current /= 10;

                    if (temp == 0)
                        result += 1;
                }
            }
            builder.append(result + "\n");
        }
        scanner.close();
        System.out.println(builder.toString());
    }
}
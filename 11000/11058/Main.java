import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] answer = new long[100 + 1];
        int attempt = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= attempt; i++) {
            answer[i] = answer[i - 1] + 1;
          
            if (i >= 7)
                for (int j = 3; i - j > 0; j++) {
                    answer[i] = Math.max(answer[i], answer[i - j] * (j - 1));
                }
        }
        System.out.print(answer[attempt]);
    }
}
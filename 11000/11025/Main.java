import java.util.Scanner;

public class Main { 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = (answer + k - 1) % i + 1;
        }
        System.out.println(answer);
    }
}
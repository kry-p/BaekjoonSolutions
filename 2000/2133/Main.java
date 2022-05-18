import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] answer = new int[30 + 1];
        scanner.close();
        answer[0] = 1;
        answer[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            answer[i] = answer[i - 2] * answer[2];
            for (int j = i - 4; j >= 0; j -= 2) 
                answer[i] += answer[j] * 2;
        }
        System.out.println(answer[n]);
    }
}
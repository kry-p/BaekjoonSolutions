import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int players = scanner.nextInt();
        int jimin = scanner.nextInt() - 1;
        int hansu = scanner.nextInt() - 1;
        scanner.close();
        
        int count = 1;
        while (players > 1) {
            int jiminPos = jimin / 2;
            int hansuPos = hansu / 2;

            if (jiminPos == hansuPos) {
                System.out.print(count);
                System.exit(0);
            }

            players = players / 2 + 1;
            jimin = jiminPos;
            hansu = hansuPos;

            count += 1;
        }
        System.out.print(-1);
    }
}
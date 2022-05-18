import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();

        int temp = 0;
        int current = 1;
        boolean direction = false; // 올라가는 방향이면 true

        while (true) {
            direction = !direction;
            if (temp + current + 1 > x)
                break;
            temp += current;
            current += 1;
        }

        System.out.println(direction ? (current - (x - temp) + 1) + "/" + (x - temp)
                : (x - temp) + "/" + (current - (x - temp) + 1));
    }
}

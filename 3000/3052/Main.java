import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] mod = new boolean[42];

        for (int i = 0; i < 10; i++) {
            int input = scanner.nextInt();
            mod[input % 42] = true;
        }

        int count = 0;

        for (boolean modulo : mod) {
            if (modulo)
                count += 1;
        }

        System.out.println(count);
    }
}
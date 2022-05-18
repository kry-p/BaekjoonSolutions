import java.util.Stack;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            int current = scanner.nextInt();

            if (current == 0) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }

        int result = 0;
        while (stack.size() > 0)
            result += stack.pop();

        System.out.println(result);

        scanner.close();
    }
}

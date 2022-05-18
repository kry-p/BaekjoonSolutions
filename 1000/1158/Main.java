import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int size = scanner.nextInt();
        int next = scanner.nextInt();

        builder.append("<");

        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 1; i <= size; i++) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            for (int i = 0; i < next - 1; i++) {
                list.add(list.pollFirst());
            }
            int poll = list.pollFirst();
            if (list.size() == 0)
                builder.append(poll);
            else
                builder.append(poll + ", ");
        }
        builder.append(">");

        System.out.println(builder.toString());
    }
}
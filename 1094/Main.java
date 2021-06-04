import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int pos = 0;
        ArrayList<Integer> pieces = new ArrayList<Integer>();

        pieces.add(64);

        do {
            int temp = pieces.get(pos);
            int subtotal;

            subtotal = pieces.stream().mapToInt(Integer::intValue).sum();
            if (subtotal == size)
                break;

            int splitted = temp / 2;

            pieces.remove(pieces.size() - 1);
            pieces.add(splitted);

            subtotal = pieces.stream().mapToInt(Integer::intValue).sum();

            if (subtotal >= size) {
            } else {
                pieces.add(splitted);
                pos++;
            }

        } while (true);

        System.out.println(pieces.size());

        scanner.close();
    }
}

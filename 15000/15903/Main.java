import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] cardList = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        for (int i = 0; i < input[1]; i++) {
            Arrays.sort(cardList);
            long temp = cardList[0] + cardList[1];
            cardList[0] = temp;
            cardList[1] = temp;
        }

        long result = Arrays.stream(cardList).sum();
        System.out.println(result);
    }
}

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int person = Integer.parseInt(scanner.nextLine());
        int[] process = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(process);
        int[] mininum = new int[person];
        scanner.close();

        int temp = 0, sum = 0;
        for (int i = 0; i < person; i++) {
            temp += process[i];
            mininum[i] += temp;
        }

        for (int i = 0; i < person; i++)
            sum += mininum[i];

        System.out.println(sum);
    }
}
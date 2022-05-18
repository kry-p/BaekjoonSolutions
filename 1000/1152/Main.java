import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(Arrays.stream(input.split(" ")).filter(str -> !str.equals("")).toArray().length);
    }
}

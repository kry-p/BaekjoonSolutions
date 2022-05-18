import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(input.indexOf(Character.toString(i)));
        }
    }
}
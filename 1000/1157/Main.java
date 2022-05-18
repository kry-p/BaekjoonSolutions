import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] count = new int[26];

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                count[input.charAt(i) - 'A'] += 1;
            } else {
                count[input.charAt(i) - 'a'] += 1;
            }
        }
        char result = '?';
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                result = (char) (i + 65);
            } else if (count[i] == max) {
                result = '?';
            }
        }

        System.out.println(result);

    }
}
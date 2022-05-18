import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempt = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < attempt; i++) {
            boolean[] isVisited = new boolean[26];
            String word = scanner.next();
            int prev = 0;
            boolean isGroup = true;

            for (int j = 0; j < word.length(); j++) {
                int current = word.charAt(j);

                if (prev != current) {
                    if (!isVisited[current - 97]) {
                        isVisited[current - 97] = true;
                        prev = current;
                        continue;
                    } else {
                        isGroup = false;
                        break;
                    }
                } else
                    continue;
            }
            if (isGroup)
                count += 1;
        }
        scanner.close();
        System.out.println(count);
    }
}
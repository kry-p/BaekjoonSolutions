import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j > 0; j--)
                builder.append(" ");
            for (int j = 0; j <= i; j++) {
                if (i == j) 
                    builder.append("*\n");
                else 
                    builder.append("* ");
            }
        }
        System.out.println(builder.toString());
    }    
}

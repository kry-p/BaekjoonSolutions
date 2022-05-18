import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.close();

        if (input % 2 == 0) 
            System.out.print("CY");
        else
            System.out.print("SK");
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width, height;
        int initialX, initialY;
        int attempt;

        width = scanner.nextInt();
        height = scanner.nextInt();

        initialX = scanner.nextInt();
        initialY = scanner.nextInt();
        attempt = scanner.nextInt();

        int attemptX = attempt % (2 * width);
        int attemptY = attempt % (2 * height);
        int directionX = 1, directionY = 1;

        int currentPositionX = initialX;
        int currentPositionY = initialY;

        for (int i = 0; i < attemptX; i++) {
            if (currentPositionX == 0 || currentPositionX == width) {
                directionX *= -1;
            }
            currentPositionX += directionX;
        }
        for (int i = 0; i < attemptY; i++) {
            if (currentPositionY == 0 || currentPositionY == height) {
                directionY *= -1;
            }
            currentPositionY += directionY;
        }

        System.out.println(currentPositionX + " " + currentPositionY);

        scanner.close();
    }
}

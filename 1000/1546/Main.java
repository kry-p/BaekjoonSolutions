import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subject = scanner.nextInt();

        int[] actualScore;
        int temp;
        double actualMax, fakeMean;

        actualScore = new int[subject];

        temp = 0;
        actualMax = 0;

        for (int i = 0; i < subject; i++) {
            temp = scanner.nextInt();
            actualScore[i] = temp;
            if (actualMax < temp)
                actualMax = temp;
        }

        double fakeSum = 0;
        for (int i = 0; i < subject; i++) {
            fakeSum += actualScore[i] / actualMax * 100;
        }

        System.out.println(fakeSum / subject);
    }
}
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        boolean[] array = new boolean[10001];
        Arrays.fill(array, true);
        int temp;
        for (int i = 1; i <= 10001; i++) {
            temp = d(i);

            if (temp < 10001) {
                array[temp] = false;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (array[i])
                builder.append(Integer.toString(i) + "\n");
        }

        System.out.println(builder.toString());
    }

    public static int d(int n) {
        int sum = n;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int select = scanner.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        NM6 nm = new NM6(size, select, arr);
        System.out.println(nm.getResult());
    }
}

class NM6 {

    private int size, select;
    private int[] arr, result;
    private boolean[] isVisited;
    private StringBuilder builder;

    public NM6(int size, int select, int[] arr) {
        this.size = size;
        this.arr = arr;
        this.select = select;

        builder = new StringBuilder();
        result = new int[select];
        isVisited = new boolean[size];

        track(0, 0);
    }

    public String getResult() {
        return builder.toString();
    }

    private void track(int depth, int latest) {
        if (depth == select) {
            for (int value : result) {
                builder.append(value + " ");
            }
            builder.append('\n');
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = arr[i];

                if (latest <= result[depth]) {
                    track(depth + 1, result[depth]);
                }
                isVisited[i] = false;
            }
        }
        return;
    }
}
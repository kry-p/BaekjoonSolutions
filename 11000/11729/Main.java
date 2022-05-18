import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

final class Hanoi {

    private StringBuilder builder;
    private int attempt;

    public Hanoi(int height) {
        builder = new StringBuilder();
        attempt = 0;
        hanoi(height, 1, 2, 3);
    }

    public String getResult() {
        builder.insert(0, Integer.toString(attempt) + "\n");
        return builder.toString();
    }

    private void move(int from, int to) {
        attempt += 1;
        builder.append(from + " " + to + "\n");
    }

    private void hanoi(int height, int from, int via, int to) {
        if (height == 1) {
            move(from, to);
        } else {
            hanoi(height - 1, from, to, via);
            move(from, to);
            hanoi(height - 1, via, from, to);
        }
    }
}

public final class Main {

    private static int height;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            height = Integer.parseInt(stringTokenizer.nextToken());

        } catch (IOException e) {
            e.printStackTrace();
        }
        Hanoi hanoi = new Hanoi(height);
        System.out.println(hanoi.getResult());
    }
}

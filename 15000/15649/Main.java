import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class Main {
    private static int size, max;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            max = Integer.parseInt(stringTokenizer.nextToken());
            size = Integer.parseInt(stringTokenizer.nextToken());

        } catch (IOException e) {
            e.printStackTrace();
        }

        NM nm = new NM(size, max);
        System.out.println(nm.getResult());
    }
}

final class NM {
    private int size, max;
    private boolean[] isVisited;
    private int[] result;
    private StringBuilder builder;

    public NM(int size, int max) {
        this.size = size;
        this.max = max;

        isVisited = new boolean[max];
        result = new int[size];
        builder = new StringBuilder();

        track(0);
    }

    public String getResult() {
        return builder.toString();
    }

    private void track(int depth) {
        if (depth == size) {
            for (int value : result) {
                builder.append(value + " ");
            }
            builder.append('\n');
            return;
        }

        for (int i = 0; i < max; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = i + 1;
                track(depth + 1);

                isVisited[i] = false;
            }
        }
        return;
    }
}

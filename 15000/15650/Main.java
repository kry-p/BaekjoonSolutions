import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int max = Integer.parseInt(tokenizer.nextToken());
        int size = Integer.parseInt(tokenizer.nextToken());

        NM2 nm = new NM2(size, max);
        System.out.println(nm.getResult());
    }
}

class NM2 {

    private int size, max;
    private int[] result;
    private boolean[] isVisited;
    private StringBuilder builder;

    public NM2(int size, int max) {
        this.size = size;
        this.max = max;

        builder = new StringBuilder();
        result = new int[size];
        isVisited = new boolean[max];

        track(0, 0);
    }

    public String getResult() {
        return builder.toString();
    }

    private void track(int depth, int latest) {
        if (depth == size) {
            for (int value : result) {
                builder.append(value + " ");
            }
            builder.append("\n");
            return;
        }

        for (int i = 0; i < max; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = i + 1;

                if (latest <= result[depth]) {
                    track(depth + 1, result[depth]);
                }
                isVisited[i] = false;
            }
        }
        return;
    }
}
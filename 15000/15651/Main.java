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

        NM3 nm = new NM3(size, max);
        System.out.println(nm.getResult());
    }
}

class NM3 {

    private int size, max;
    private int[] result;
    private StringBuilder builder;

    public NM3(int size, int max) {
        this.size = size;
        this.max = max;

        builder = new StringBuilder();
        result = new int[size];

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
            builder.append("\n");
            return;
        }

        for (int i = 0; i < max; i++) {
            result[depth] = i + 1;
            track(depth + 1);
        }
        return;
    }
}
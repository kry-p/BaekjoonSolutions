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

        NM4 nm = new NM4(size, max);
        System.out.println(nm.getResult());
    }
}

class NM4 {

    private int size, max;
    private int[] result;
    private StringBuilder builder;

    public NM4(int size, int max) {
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
                builder.append((value + 1) + " ");
            }
            builder.append("\n");
            return;
        }

        for (int i = 0; i < max; i++) {
            if (depth == 0 || result[depth - 1] <= i) {
                result[depth] = i;
                track(depth + 1);
            }
        }
        return;
    }
}
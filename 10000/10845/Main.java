import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int attempt = Integer.parseInt(reader.readLine());
        int[] queue = new int[10000];
        int head = 0, tail = 0;

        String[] line;
        for (int i = 0; i < attempt; i++) {
            line = reader.readLine().split(" ");

            switch (line[0]) {
                case "push":
                    queue[tail] = Integer.parseInt(line[1]);
                    tail += 1;
                    break;
                case "pop":
                    if (head < tail) {
                        builder.append(queue[head]);
                        head += 1;
                    } else
                        builder.append(-1);
                    break;
                case "size":
                    builder.append(tail - head);
                    break;
                case "empty":
                    if (head >= tail)
                        builder.append(1);
                    else
                        builder.append(0);
                    break;
                case "front":
                    if (head == tail)
                        builder.append(-1);
                    else
                        builder.append(queue[head]);
                    break;
                case "back":
                    if (head == tail)
                        builder.append(-1);
                    else
                        builder.append(queue[tail - 1]);
                    break;
                default:
                    break;
            }
            if (!line[0].equals("push"))
                builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}

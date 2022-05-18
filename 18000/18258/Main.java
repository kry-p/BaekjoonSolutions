import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int attempt = Integer.parseInt(reader.readLine());
        int[] queue = new int[2000000];
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
                        writer.write(Integer.toString(queue[head]));
                        head += 1;
                    } else
                        writer.write("-1");
                    break;
                case "size":
                    writer.write(Integer.toString(tail - head));
                    break;
                case "empty":
                    if (head >= tail)
                        writer.write("1");
                    else
                        writer.write("0");
                    break;
                case "front":
                    if (head == tail)
                        writer.write("-1");
                    else
                        writer.write(Integer.toString(queue[head]));
                    break;
                case "back":
                    if (head == tail)
                        writer.write("-1");
                    else
                        writer.write(Integer.toString(queue[tail - 1]));
                    break;
                default:
                    break;
            }
            if (!line[0].equals("push"))
                writer.write("\n");
        }
        writer.flush();
        writer.close();
    }
}
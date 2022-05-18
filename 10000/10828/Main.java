import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<Integer>();

        int attempt = Integer.parseInt(reader.readLine());
        String[] input;

        for (int i = 0; i < attempt; i++) {
            input = reader.readLine().split(" ");

            if (input[0].equals("push")) {
                stack.push(Integer.parseInt(input[1]));
            }
            if (input[0].equals("pop")) {
                writer.write(stack.empty() ? "-1" : Integer.toString(stack.pop()));
                writer.write("\n");
            }
            if (input[0].equals("size")) {
                writer.write(Integer.toString(stack.size()));
                writer.write("\n");
            }
            if (input[0].equals("empty")) {
                writer.write(stack.empty() ? "1" : "0");
                writer.write("\n");
            }
            if (input[0].equals("top")) {
                writer.write(stack.empty() ? "-1" : Integer.toString(stack.peek()));
                writer.write("\n");
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}

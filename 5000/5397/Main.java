import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int attempt = Integer.parseInt(reader.readLine());

        Stack<Character> leftStack = new Stack<Character>();
        Stack<Character> rightStack = new Stack<Character>();

        for (int i = 0; i < attempt; i++) {
            String[] input = reader.readLine().split("");

            for (int j = 0; j < input.length; j++) {
                String current = input[j];

                if (current.equals("<")) {
                    if (!leftStack.empty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (current.equals(">")) {
                    if (!rightStack.empty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (current.equals("-")) {
                    if (!leftStack.empty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(current.charAt(0));
                }
            }

            while (!leftStack.empty())
                rightStack.push(leftStack.pop());

            while (!rightStack.empty())
                writer.write(rightStack.pop());

            writer.write("\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

}

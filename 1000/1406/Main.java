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

        String init = reader.readLine();
        String input;

        Stack<Character> leftStack = new Stack<Character>();
        Stack<Character> rightStack = new Stack<Character>();

        int attempt = Integer.parseInt(reader.readLine());

        // 초기 편집기 입력내용
        for (int i = 0; i < init.length(); i++) {
            leftStack.push(init.charAt(i));
        }

        for (int i = 0; i < attempt; i++) {
            input = reader.readLine();

            if (input.startsWith("L")) {
                if (!leftStack.empty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (input.startsWith("D")) {
                if (!rightStack.empty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if (input.startsWith("B")) {
                if (!leftStack.empty()) {
                    leftStack.pop();
                }
            } else if (input.startsWith("P")) {
                String[] split = input.split(" ");
                leftStack.push(split[1].charAt(0));
            }
        }

        while (!leftStack.empty())
            rightStack.push(leftStack.pop());

        while (!rightStack.empty())
            writer.write(rightStack.pop());

        reader.close();
        writer.flush();
        writer.close();
    }

}

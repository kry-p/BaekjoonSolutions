import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = reader.readLine().split("");
        Calculator calc = new Calculator();
        System.out.println(calc.infixToPostfix(token));
    }
}

class Calculator {
    public int getPriority(String operator) {
        switch (operator) {
            case "(":
                return 0;
            case "+":
            case "-":
                return 1;
            default:
                return 2;
        }
    }

    public String infixToPostfix(String[] token) {
        Stack<String> stack = new Stack<>();
        Stack<String> result = new Stack<>();

        for (String s : token) {
            if (isNumeric(s)) {
                // 숫자는 그대로 내보냄
                result.push(s);
            } else {
                if (s.equals("(")) {
                    // ( 이면 반드시 스택에 push
                    stack.push(s);
                } else if (s.equals(")")) {
                    // ) 이면 ( 가 나올 때까지 모두 pop
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        result.push(stack.pop());
                    }
                    if (!stack.empty())
                        stack.pop();
                } else {
                    // 괄호를 제외한 일반 연산자 처리
                    // 스택이 비었을 경우 스택에 push
                    if (stack.isEmpty())
                        stack.push(s);
                    else {
                        // 스택에 연산자가 남아 있으면 스택 내 연산자와 현재 연산자의 우선순위 비교
                        // 우선순위가 높으면 스택에 추가, 아니면 pop 후 현재 연산자를 스택에 추가
                        while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(s)) {
                            result.push(stack.pop());
                        }
                        stack.push(s);
                    }
                }
            }
        }
        // 스택에 남아있는 모든 연산자를 꺼냄
        while (!stack.isEmpty())
            result.add(stack.pop());

        StringBuilder builder = new StringBuilder();
        while (!result.isEmpty())
            builder.append(result.pop());

        builder.reverse();
        return builder.toString();
    }

    public static boolean isNumeric(String str) {
        char check = str.charAt(0);
        if (check < 91 && check > 64) {
            return true;
        }
        return false;
    }
}
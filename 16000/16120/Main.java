import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Stack<Character> stack = new Stack<>();     
    
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == 'P')
                stack.push('P');
            else {
                if (stack.size() >= 2 && i < input.length() - 1 && input.charAt(i + 1) == 'P') {
                    stack.pop();
                    stack.pop();
                } else {
                    System.out.print("NP");
                    return;
                }
            }
        }
        String result = stack.size() == 1 ? "PPAP" : "NP";
        System.out.print(result); 
    }
}

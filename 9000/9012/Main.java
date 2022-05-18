import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        Stack<String> ps = new Stack<>();

        for (int i = 0; i < input; i++) {
            boolean result = true;
            int opened = 0;
            String[] psArray = bufferedReader.readLine().split("");

            for (int j = 0; j < psArray.length; j++) {
                ps.add(psArray[j]);
            }

            while (true) {
                if (ps.isEmpty()) {
                    if (opened != 0)
                        result = false;
                    break;
                }
                String latest = ps.pop();

                if (latest.equals(")"))
                    opened += 1;
                else if (latest.equals("("))
                    opened -= 1;

                if (opened < 0) {
                    result = false;
                    break;
                }
            }
            ps.clear();
            System.out.println(result ? "YES" : "NO");
        }
    }
}
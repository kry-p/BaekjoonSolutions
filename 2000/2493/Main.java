import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int size = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[size + 1];
        Stack<Tower> lStack = new Stack<>();
        Stack<Tower> rStack = new Stack<>();

        for (int i = 0; i < array.length; i++) 
            lStack.add(new Tower(array[i], i + 1));
        
        while(!lStack.isEmpty() || !rStack.isEmpty()) {
            // 왼쪽 스택이 비워져 있으면 비교 대상 없음, rStack pop
            if (lStack.isEmpty()) {
                if (!rStack.isEmpty())
                    rStack.pop();
            } else {
                // 오른쪽 스택이 비워져 있으면 일단 채움
                if (rStack.isEmpty() && !lStack.isEmpty())
                    rStack.add(lStack.pop());
                // 왼쪽 스택이 비워져 있으면 도달 불가
                if (lStack.isEmpty()) {
                    continue;
                }
                // 양쪽 값을 비교
                // lStack의 height가 더 크면 rStack pop, 높이 반영
                if (lStack.peek().height > rStack.peek().height) {
                    Tower right = rStack.pop();
                    result[right.index] = lStack.peek().index;
                } else {
                    if(!lStack.isEmpty())
                        rStack.add(lStack.pop());
                }
            }
        }

        for (int i = 1; i <= size; i++)
            builder.append(result[i] + " ");

        System.out.print(builder.toString());
    }
}

class Tower {
    public int height, index;
    public Tower(int height, int index) {
        this.height = height;
        this.index = index;
    }
}
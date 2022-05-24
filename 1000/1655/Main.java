import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int attempt = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (int i = 0; i < attempt; i++) {
            int current = Integer.parseInt(reader.readLine());
            if (leftQueue.size() == rightQueue.size()) {
                rightQueue.add(current);
            } else {
                leftQueue.add(current);
            }

            if (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                if (leftQueue.peek() < rightQueue.peek()) {
                    int temp = leftQueue.poll();
                    leftQueue.add(rightQueue.poll());
                    rightQueue.add(temp);
                }
            }

            builder.append(rightQueue.peek() + "\n");
        }
        System.out.print(builder.toString());
    }
}
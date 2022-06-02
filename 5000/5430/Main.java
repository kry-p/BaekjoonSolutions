import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();
        int testCase = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCase; i++) {
            int direction = 1; // 삽입 / 삭제할 방향
            boolean isError = false; // 오류 발생 여부 (데크가 비어있는 등)
            String func = reader.readLine(); // 수행할 함수
            int size = Integer.parseInt(reader.readLine());
            String[] array = reader.readLine().split(",");
            
            // 데크에 값을 집어넣음
            if (size != 0) {
                array[0] = array[0].substring(1, array[0].length());
                array[array.length - 1] = array[array.length - 1].substring(0, array[array.length - 1].length() - 1);
                for (String s : array)
                    deque.addLast(s);
            }
            
            for (int j = 0; j < func.length(); j++) {
                char command = func.charAt(j);
                // 방향 뒤집기
                if (command == 'R') {
                    direction *= -1;
                }
                // 첫 번째 수 제거
                if (command == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (direction == 1) deque.pollFirst();
                        else deque.pollLast();
                    }
                }
            }
            
            // 결과 builder에 입력
            if (!isError) {
                builder.append("[");
                boolean isDequeLengthZero = deque.isEmpty(); // Deque 크기가 0일 때 예외처리

                if (direction == 1) {
                    while (!deque.isEmpty())
                        builder.append(deque.pollFirst() + ",");
                } else {
                    while (!deque.isEmpty())
                        builder.append(deque.pollLast() + ",");
                }
                if (!isDequeLengthZero)
                    builder.setLength(builder.length() - 1);
                builder.append("]\n");
            } else {
                builder.append("error\n");
            }
            deque.clear();
        }
        System.out.print(builder.toString());
    }
}

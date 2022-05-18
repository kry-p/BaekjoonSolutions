import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

final class Josephus {
    private String result;
    private int person, recognizer;

    private int[] resultArray;

    public Josephus(int person, int recognizer) {
        this.person = person;
        this.recognizer = recognizer;

        resultArray = new int[person];
        run();
    }

    private void setResult() {
        StringBuilder builder = new StringBuilder();

        builder.append("<");

        for (int i = 0; i < person; i++) {
            if (i >= person - 1)
                builder.append(Integer.toString(resultArray[i]));
            else
                builder.append(Integer.toString(resultArray[i]) + ", ");
        }

        builder.append(">");
        result = builder.toString();
    }

    public String getResult() {
        return result;
    }

    private void run() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int pos = 0;
        for (int i = 1; i <= person; i++)
            list.add(i);

        while (!list.isEmpty()) {
            for (int i = 0; i < recognizer; i++) {
                if (i == recognizer - 1) {
                    int removed = list.remove();
                    resultArray[pos] = removed;
                    pos++;
                } else {
                    list.add(list.remove());
                }
            }
        }

        setResult();
    }
}

public final class Main {
    private static int person, recognizer;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            person = Integer.parseInt(stringTokenizer.nextToken());
            recognizer = Integer.parseInt(stringTokenizer.nextToken());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Josephus josephus = new Josephus(person, recognizer);
        System.out.println(josephus.getResult());
    }
}
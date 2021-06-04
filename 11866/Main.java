import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

final class Josephus {
    private int result;
    private int person, recognizer;

    public Josephus(int person, int recognizer) {
        this.person = person;
        this.recognizer = recognizer;
    }

    public int getResult() {
        return result;
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
        int result = josephus.getResult();

        System.out.println(result);
    }
}
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    private static HashMap<String, Integer> map = new HashMap<>();
    private final static String[] COLORS = { "black", "brown", "red", "orange", "yellow",
                                             "green", "blue", "violet", "grey", "white" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < COLORS.length; i++) {
            map.put(COLORS[i], i);
        }

        for (int i = 0; i < 3; i++) {
            if (i != 2)
                result.append(map.get(scanner.nextLine()));
            else {
                Integer last = map.get(scanner.nextLine());
                for (int j = 0; j < last; j++)
                    result.append("0");
            }
        }
        scanner.close();
        System.out.println(Long.parseLong(result.toString()));
        
    }
}
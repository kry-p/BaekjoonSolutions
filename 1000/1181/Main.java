import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        ArrayList<String>[] bySize = new ArrayList[50 + 1];

        for (int i = 0; i < bySize.length; i++)
            bySize[i] = new ArrayList<String>();

        for (int i = 0; i < size; i++) {
            String s = reader.readLine();
            if (!bySize[s.length()].contains(s))
                bySize[s.length()].add(s);
        }

        for (int i = 0; i < bySize.length; i++) {
            if (bySize[i].size() != 0) {
                Collections.sort(bySize[i]);
                
                for (String s : bySize[i])
                    builder.append(s + "\n");
            }
        }
        System.out.println(builder.toString()); 
    }   
}

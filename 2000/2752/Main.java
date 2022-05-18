import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int[] input = Arrays.asList(scanner.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray(); 
        Arrays.sort(input);

        for(int i:input){
            builder.append(i+" ");
        }

        System.out.print(builder.toString());
    }   
}
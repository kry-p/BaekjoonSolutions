import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input = scanner.nextLine();

        int[] count = new int[26];

        for(int i=0;i<input.length();i++){
            count[input.charAt(i)-'a']+=1;
        }

        StringBuilder builder=new StringBuilder();

        for(int i:count)
            builder.append(i+" ");

        System.out.print(builder.toString());
    }
}
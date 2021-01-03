import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int[] input=new int[3];
        int result=1;

        for(int i=0;i<input.length;i++){
            input[i]=scanner.nextInt();
            result *= input[i];
        }

    }
}
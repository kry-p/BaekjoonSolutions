import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int[] array;
        int min, max;

        array = new int[scanner.nextInt()];

        for(int i=0;i<array.length;i++){
            array[i]=scanner.nextInt();
        }

        min = array[0];
        max = array[0];

        for(int i=0;i<array.length-1;i++){
            if(min > array[i+1]) min = array[i+1];
            if(max < array[i+1]) max = array[i+1];
        }

        System.out.println(min+" "+max);
    }
}
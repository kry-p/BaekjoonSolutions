import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int[] array;
        int max, pos;

        array = new int[9];

        for(int i=0;i<array.length;i++){
            array[i]=scanner.nextInt();
        }

        max = array[0];
        pos = 0;

        for(int i=0;i<array.length-1;i++){
            if(max < array[i+1]){
                max = array[i+1];
                pos = i+1; // absolute position
            }
        }

        System.out.println(max);
        System.out.println(pos+1); // position started as 0
    }
}
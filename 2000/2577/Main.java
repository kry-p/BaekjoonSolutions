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
        
        int[] digits=new int[((int)Math.log10(result))+1];

        int i=0;
        while(result!=0){
            digits[i]=result%10;
            result/=10;
            i+=1;
        }

        for(int j=0;j<10;j++){
            int temp=0;
            for(int k=0;k<digits.length;k++){
                if(digits[k]==j) temp+=1;
            }

            System.out.println(temp);
        }
    }
}
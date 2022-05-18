import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        
        String temp=Integer.toString(b);
        for(int i=2;i>=0;i--) {
        	System.out.println(a*Integer.parseInt(Character.toString(temp.charAt(i))));
        }
        
        System.out.println(a*b);
    }
}
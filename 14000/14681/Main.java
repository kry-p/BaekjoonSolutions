import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int xPos=sc.nextInt();
        int yPos=sc.nextInt();
        
        if(xPos>0) {
        	if(yPos>0) System.out.println("1");
        	else if(yPos<0) System.out.println("4");
        }
        else if(xPos<0) {
        	if(yPos>0) System.out.println("2");
        	else if(yPos<0) System.out.println("3");
        }
    }
}
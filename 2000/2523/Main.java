import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<size-1;i++) {
			for(int j=size-1;j>i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
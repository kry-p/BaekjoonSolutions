import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int input=sc.nextInt();
		
		if(input==1) System.out.println("*");
		else {
			String[][] arr=new String[2*input][input];
			for(int i=0;i<arr.length;i++) {
				if(i%2==0) {
					for(int j=0;j<arr[0].length;j++) {
						if(j%2==0) arr[i][j]="*";
						else arr[i][j]=" ";
					}
				}
				else {
					for(int j=0;j<arr[0].length;j++) {
						if(j%2==1) arr[i][j]="*";
						else arr[i][j]=" ";
					}
				}
			}
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
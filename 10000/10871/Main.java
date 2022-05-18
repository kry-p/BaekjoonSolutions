import java.util.Scanner;

public class Main{
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		int size,smallerThan;
		
		size=sc.nextInt();
		smallerThan=sc.nextInt();
		
		int []arr=new int[size];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<smallerThan) System.out.print(arr[i]+" ");
		}
	}
}
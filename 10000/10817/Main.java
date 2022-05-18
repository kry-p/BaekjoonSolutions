import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[3];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				int temp=arr[j+1];
				if(arr[j]>arr[j+1]) {
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		System.out.print(arr[1]);
	}
}
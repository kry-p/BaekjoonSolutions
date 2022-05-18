import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input,temp=0,a,b,res=0,cycle=0;
		input=sc.nextInt();
		temp=input;

		while(true){
			if(temp<10) a=0;
			else a=temp/10;
			b=temp%10;

			res=a+b;
			cycle++;

			a=temp%10;
			b=res%10;
			temp=(a*10)+b;

			if(temp==input) break;
		}
		System.out.print(cycle);
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] burger=new int[3];
		int[] drink=new int[2];
		
		
		for(int i=0;i<burger.length;i++) burger[i]=sc.nextInt();
		for(int i=0;i<drink.length;i++) drink[i]=sc.nextInt();
		
		int minBurger=burger[0];
		int minDrink=drink[0];
		for(int i=1;i<burger.length;i++) {
			if(burger[i]<minBurger) minBurger=burger[i];
		}
		if(minDrink>drink[1]) minDrink=drink[1];
		System.out.println(minBurger+minDrink-50);
	}
}
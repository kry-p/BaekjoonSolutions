/*
 * 크리 문자열 길이 구하기
 */
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String str=sc.next(); // 문자열 입력
		
		int windowSize=(int)(str.length()/2)*2; // 짝수 길이의 연속 문자열 초기값(최대치)
		
		/*
		 * 일치 여부 판단 로직
		 * 연속된 문자열을 window로 가정, 크기가 최솟값이 될 때까지 반복
		 * 발견되면 프로그램 종료
		 */
		int left,right;
		do {
			for(int i=0;i<=str.length()-windowSize;i++) {
				left=0; // window 기준 왼쪽 값의 합
				right=0; // window 기준 오른쪽 값의 합
				
				// window의 절반만큼 left로 지정, 자릿수를 읽어온 다음 더함
				for(int j=i;j<i+windowSize/2;j++) {
					left+=Character.getNumericValue(str.charAt(j));
				}
				for(int j=i+windowSize/2;j<i+windowSize;j++) {
					right+=Character.getNumericValue(str.charAt(j));
				}
				
				// 일치 여부 판단
				if(left==right) {
					System.out.println(windowSize);
					System.exit(0);
				}
			}
			windowSize-=2;
		}while(windowSize>=2);
	}
}
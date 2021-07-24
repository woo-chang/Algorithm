import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int digits = 1; // 몇 자릿수 인지?
		int digitCount = 9; // 해당 자릿수의 개수
		int result = 0;
		do {
			if(n-digitCount <= 0) { // 자릿수 증가가 더 이상 발생하지 않는 경우
				result += n * digits;
				break;
			}
			
			n -= digitCount; // 처리한 자릿수 빼기
			result += digits * digitCount; // 자릿수에 해당하는 개수만큼 결과 증가
			digits++; // 자릿수 증가
			digitCount *= 10; // 자릿수에 맞춰 개수도 증가
			
		} while(true);
		
		System.out.println(result);
		
		sc.close();
	}
}
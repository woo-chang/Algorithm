import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] result = new int[n];
		int[] numArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		result[0] = numArray[0];
		int answer = result[0];
		for(int i = 1; i < n; i++) {
			if(result[i-1] + numArray[i] > numArray[i]) {
				result[i] = result[i-1] + numArray[i];
			} else {
				result[i] = numArray[i];
			}
			
			if(result[i] > answer)
				answer = result[i];
		}
		System.out.println(answer);
		sc.close();
	}
}
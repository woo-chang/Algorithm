import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] values = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int result = 0;
		int[] toHigh = new int[n];
		int[] toLow = new int[n];
		toHigh[0] = 1;
		toLow[n-1] = 1;
		for(int i = 1; i < n; i++) {
			toHigh[i] = 1;
			for(int j = i-1; j >=0; j--) {
				if(values[i] > values[j] && toHigh[i] < toHigh[j]+1)
					toHigh[i] = toHigh[j] + 1;
			}
		}
		for(int i = n-2; i >=0; i--) {
			toLow[i] = 1;
			for(int j = i+1; j < n; j++) {
				if(values[i] > values[j] && toLow[i] < toLow[j]+1)
					toLow[i] = toLow[j] + 1;
			}
		}
		for(int i = 0; i < n; i++) {
			int dp = toHigh[i] + toLow[i] - 1;
			if(result < dp) result = dp;
		}
		System.out.println(result);
		sc.close();
	}
}
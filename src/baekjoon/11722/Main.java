import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] values = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] dp = new int[n];
		int result = 0;
		for(int i = n-1; i >= 0; i--) {
			dp[i] = 1;
			for(int j = i+1; j < n; j++) {
				if(values[i] > values[j] && dp[i] < dp[j]+1)
					dp[i] = dp[j] + 1;
			}
			
			if(dp[i] > result) result = dp[i];
		}
		System.out.println(result);
		sc.close();
	}
}
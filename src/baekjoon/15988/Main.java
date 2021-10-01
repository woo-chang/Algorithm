import java.util.Scanner;

public class Main {

	final static long D = 1000000009;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] dp = new long[1000001];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < 1000001; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			dp[i] %= D;
		}
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
		sc.close();
	}
}
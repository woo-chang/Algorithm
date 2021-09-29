import java.util.Scanner;

public class Main {

	final static long D = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long[][] dp = new long[201][201];
		for(int i = 0; i < k+1; i++) {
			dp[0][i] = 1;
		}
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < k+1; j++) {
				long sum = 0;
				for(int l = 0; l <= i; l++) {
					sum += dp[l][j-1];
					sum %= D;
				}
				dp[i][j] = sum;
			}
		}
		System.out.println(dp[n][k]);
		sc.close();
	}
}
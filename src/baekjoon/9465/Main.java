import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n+1][3];
			int[][] data = new int[2][n];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[1][0] = 0;
			dp[1][1] = data[0][0];
			dp[1][2] = data[1][0];
			for(int i = 2; i < n+1; i++) {
				dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
				dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + data[0][i-1];
				dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + data[1][i-1];
			}
			System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
		}
	}
}
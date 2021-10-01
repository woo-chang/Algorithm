import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int answer = 0;
		int[][] dp = new int[1001][3];
		int[][] valueForDp = new int[1001][3];
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				valueForDp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < 3; i++) {
			dp[1][i] = valueForDp[1][i];
		}
		for(int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + valueForDp[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + valueForDp[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + valueForDp[i][2];
		}
		answer = dp[n][0];
		for(int i = 1; i < 3; i++) {
			if(answer > dp[n][i])
				answer = dp[n][i];
		}
		bw.write(answer+"\n");
		bw.flush();
	}
}
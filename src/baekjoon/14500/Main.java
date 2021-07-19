
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	static int M;
	static int[][] table;
	static int[][] pathTable;
	static int answer = 0;

	public static void tetromino(int x, int y, int sum, int cnt) {
		if(cnt == 4) {
			if(answer < sum) answer = sum;
			return;
		}
		if(x < 0 || y < 0 || x >= M || y >= N) return;
		if(pathTable[y][x] == 1) return;
		
		pathTable[y][x] = 1;
		for(int i = 0; i < 4; i++) {
			tetromino(x+dx[i], y+dy[i], sum+table[y][x], cnt+1);
		}
		pathTable[y][x] = 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		table = new int[N][M];
		pathTable = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tetromino(j, i, 0, 0);
				if(j+2 < M) {
					int subSum = table[i][j] + table[i][j+1] + table[i][j+2];
					if(i+1 < N) {
						int subSum2 = subSum + table[i+1][j+1];
						if(answer < subSum2) answer = subSum2;
					}
					if(i-1 >= 0) {
						int subSum2 = subSum + table[i-1][j+1];
						if(answer < subSum2) answer = subSum2;
					}
				}
				if(i+2 < N) {
					int subSum = table[i][j] + table[i+1][j] + table[i+2][j];
					if(j+1 < M) {
						int subSum2 = subSum + table[i+1][j+1];
						if(answer < subSum2) answer = subSum2;
					}
					if(j-1 >= 0) {
						int subSum2 = subSum + table[i+1][j-1];
						if(answer < subSum2) answer = subSum2;
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}
}

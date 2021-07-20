
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int gcd(int x, int y) {
		while(y != 0) {
			int r = x % y;
			x = y;
			y = r;
		}
		return x;
	}
	
	public static int lcm(int x, int y) {
		return x * y / gcd(x, y);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int cnt = x % (m+1);
			int pivotY = x;
			
			for(int i = 0; i < n; i++) {
				int dy = pivotY % n == 0 ? n : pivotY % n;
				if(dy == y)
					break;
				
				pivotY = dy + m;
				cnt += m;
			}
			
			if(cnt > lcm(m, n)) System.out.println(-1);
			else System.out.println(cnt);
			
		}
	}
}
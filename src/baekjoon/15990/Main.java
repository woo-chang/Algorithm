import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[][] table = new long[100001][3];
		table[1][0] = 1;
		table[2][1] = 1;
		table[3][0] = 1;
		table[3][1] = 1;
		table[3][2] = 1;
		for(int i = 4; i <= 100000; i++) {
			table[i][0] = (table[i-1][1] + table[i-1][2]) % 1000000009;
			table[i][1] = (table[i-2][0] + table[i-2][2]) % 1000000009;
			table[i][2] = (table[i-3][0] + table[i-3][1]) % 1000000009;
		}
		while(t-- > 0) {
			int n = sc.nextInt();
			long result = (table[n][0] + table[n][1] + table[n][2]) % 1000000009;
			System.out.println(result);
		}
		sc.close();
	}
}
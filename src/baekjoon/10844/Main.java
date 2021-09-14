import java.util.Scanner;

public class Main {
	
	static final int R = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[][] table = new long[101][10];
		table[1][0] = 0;
		for(int i = 1; i < 10; i++) {
			table[1][i] = 1;
		}
		for(int i = 2; i < 101; i++) {
			table[i][0] = table[i-1][1] % R;
			table[i][1] = (table[i-1][0] + table[i-1][2]) % R;
			table[i][2] = (table[i-1][1] + table[i-1][3]) % R;
			table[i][3] = (table[i-1][2] + table[i-1][4]) % R;
			table[i][4] = (table[i-1][3] + table[i-1][5]) % R;
			table[i][5] = (table[i-1][4] + table[i-1][6]) % R;
			table[i][6] = (table[i-1][5] + table[i-1][7]) % R;
			table[i][7] = (table[i-1][6] + table[i-1][8]) % R;
			table[i][8] = (table[i-1][7] + table[i-1][9]) % R;
			table[i][9] = table[i-1][8] % R;
		}
		int N = sc.nextInt();
		long result = 0;
		for(int i = 0; i < 10; i++) {
			result += table[N][i];
		}
		System.out.println(result % R);
		sc.close();
	}
}
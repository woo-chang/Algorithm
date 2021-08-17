import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] pTable = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] d = new int[1001];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				if(d[i] == 0 || d[i] > d[i-j] + pTable[j-1])
					d[i] = d[i-j] + pTable[j-1];
			}
		}
		System.out.println(d[n]);
		sc.close();
	}
}
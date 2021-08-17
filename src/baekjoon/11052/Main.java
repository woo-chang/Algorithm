import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] pTable = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] d = new int[1001];
		d[1] = pTable[0];
		for(int i = 0; i < n; i++) {
			d[i+1] = pTable[i];
		}
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < n; j++) {
				if(i+j > n) continue;
				d[i+j] = Math.max(d[i+j], d[i]+pTable[j-1]);
			}
		}
		System.out.println(d[n]);
		sc.close();
	}
}
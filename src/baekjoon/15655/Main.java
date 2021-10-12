import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[] myNum;
	static int[] myPick;
	
	public static void nToM(int n, int m, int select, int index) {
		if(select == m) {
			for(int i = 0; i < m; i++) {
				if(i == m-1) sb.append(myPick[i]);
				else sb.append(myPick[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = index; i < n; i++) {
			myPick[select] = myNum[i];
			nToM(n, m, select+1, i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		myPick = new int[m];
		myNum = new int[n];
		for(int i = 0; i < n; i++) {
			myNum[i] = sc.nextInt();
		}
		Arrays.sort(myNum);
		nToM(n, m, 0, 0);
		System.out.println(sb.toString());
		sc.close();
	}
}
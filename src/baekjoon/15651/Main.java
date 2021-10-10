import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[] myPick;
	
	public static void nToM(int n, int m, int select) {
		if(select == m) {
			for(int i = 0; i < m; i++) {
				if(i == m-1) sb.append(myPick[i]);
				else sb.append(myPick[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			myPick[select] = i;
			nToM(n, m, select+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		myPick = new int[m];
		nToM(n, m, 0);
		System.out.println(sb.toString());
		sc.close();
	}
}
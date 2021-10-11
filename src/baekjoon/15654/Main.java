import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[] myPick;
	static boolean[] selected;
	static int[] myInput;
	
	public static void nToM(int n, int m, int select) {
		if(select == m) {
			for(int i = 0; i < m; i++) {
				if(i == m-1) sb.append(myPick[i]);
				else sb.append(myPick[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			myPick[select] = myInput[i];
			nToM(n, m, select+1);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		myPick = new int[m];
		selected = new boolean[n];
		myInput = new int[n];
		for(int i = 0; i < n; i++) {
			myInput[i] = sc.nextInt();
		}
		Arrays.sort(myInput);
		nToM(n, m, 0);
		System.out.println(sb.toString());
		sc.close();
	}
}
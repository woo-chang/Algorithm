import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[] selected;
	static int[] myInput;
	
	public static void nToM(int n, int m, int select, int index) {
		if(select == m) {
			for(int i = 0; i < m; i++) {
				if(i == m-1) sb.append(selected[i]);
				else sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = index; i < n; i++) {
			selected[select] = myInput[i];
			nToM(n, m, select+1, i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		selected = new int[m];
		myInput = new int[n];
		for(int i = 0; i < n; i++) {
			myInput[i] = sc.nextInt();
		}
		Arrays.sort(myInput);
		nToM(n, m, 0, 0);
		System.out.println(sb.toString());
		sc.close();
	}
	
}
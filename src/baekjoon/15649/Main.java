import java.util.Scanner;

public class Main {

	static boolean[] selected = new boolean[9];
	
	public static void print(int[] myPick) {
		for(int i : myPick) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void nToM(int n, int m, int select, int[] myPick) {
		if(select == m) {
			print(myPick);
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			myPick[select] = i;
			nToM(n, m, select+1, myPick);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] myPick = new int[m];
		nToM(n, m, 0, myPick);
		sc.close();
	}
}
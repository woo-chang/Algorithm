import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] table = new int[3000001];
	
	public static void fillTable(int n) {
		Arrays.fill(table, -1);
		table[1] = 0;
		for(int i = 1; i <= n; i++) {
			if(table[i+1] != -1) {
				table[i+1] = table[i+1] > table[i] + 1 ? table[i] + 1 : table[i+1];
			} else {
				table[i+1] = table[i] + 1;
			}
			
			if(table[i*2] != -1) {
				table[i*2] = table[i*2] > table[i] + 1 ? table[i] + 1 : table[i*2];
			} else {
				table[i*2] = table[i] + 1;
			}
			
			if(table[i*3] != -1) {
				table[i*3] = table[i*3] > table[i] + 1 ? table[i] + 1 : table[i*3];
			} else {
				table[i*3] = table[i] + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fillTable(n);
		System.out.println(table[n]);
		sc.close();
	}
}
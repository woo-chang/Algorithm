import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] values = new int[n];
		for(int i = 0; i < n; i++) {
			values[i] = sc.nextInt();
		}
		int[] front = new int[n];
		int[] back = new int[n];
		int result = values[0];
		front[0] = values[0];
		back[n-1] = values[n-1];
		for(int i = 1; i < n; i++) {
			front[i] = Math.max(values[i], front[i-1]+values[i]);
			back[n-1-i] = Math.max(values[n-1-i], back[n-i] + values[n-1-i]);
			if(front[i] > result) result = front[i];
			if(back[n-1-i] > result) result = back[n-1-i];
		}
		
		for(int i = 1; i < n; i++) {
			int num = front[i-1];
			if(i+1 < n) num += back[i+1];
			if(num > result) result = num;
		}
		System.out.println(result);
		sc.close();
	}
}
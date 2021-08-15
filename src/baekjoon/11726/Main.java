import java.util.Scanner;

public class Main {

	static int[] table;
	
	public static int findSolution(int n) {
		if(table[n] > 0) return table[n];
		
		table[n] = (findSolution(n-1)%10007) + (findSolution(n-2)%10007);
		
		return table[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		table = new int[n+1];
		table[0] = 1;
		table[1] = 1;
		long answer = findSolution(n);
		System.out.println(answer%10007);
		sc.close();
	}
}
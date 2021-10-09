import java.util.Scanner;

public class Main {

	public static boolean check(int n, boolean[] broken) {
		String s = Integer.toString(n);
		for(int i = 0; i < s.length(); i++) {
			if(broken[Character.getNumericValue(s.charAt(i))])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer = 987654321;
		boolean[] broken = new boolean[10];
		for(int i = 0; i < m; i++) {
			broken[sc.nextInt()] = true;
		}
		if(n == 100) {
			System.out.println(0);
		} else {
			answer = Math.min(answer, Math.abs(n-100));
			for(int i = 0; i <= 1000000; i++) {
				if(!check(i, broken)) continue;
				int subAnswer = Integer.toString(i).length();
				subAnswer += Math.abs(n-i);
				answer = Math.min(answer, subAnswer);
			}
			System.out.println(answer);
		}
		sc.close();
	}
}
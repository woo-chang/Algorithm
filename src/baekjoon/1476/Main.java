import java.util.Scanner;

public class Main {

	public static int findFirst(int e) {
		int init = 1;
		int count = 1;
		while(init != e) {
			count += 1;
			init += 1;
			if(init > 15)
				init = 1;
		}
		return count;
	}
	
	public static boolean check(int count, int s, int m) {
		int checkS = count % 28;
		int checkM = count % 19;
		if(checkS == 0) checkS = 28;
		if(checkM == 0) checkM = 19;
		if(s != checkS) return false;
		if(m != checkM) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		int answer = findFirst(e);
		while(true) {
			if(check(answer, s, m)) {
				break;
			}
			answer += 15;
		}
		System.out.println(answer);
		sc.close();
	}
}